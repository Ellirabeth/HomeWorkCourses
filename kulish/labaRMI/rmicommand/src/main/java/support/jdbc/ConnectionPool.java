package support.jdbc;


import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

public class ConnectionPool {

    private int min;
    private int max;
    private String jdbcClassName;
    private String jdbcUrl;
    private String login;
    private String passwd;

    private List<PooledConnection> free = Collections.synchronizedList(new ArrayList<PooledConnection>());
    private List<PooledConnection> used = Collections.synchronizedList(new ArrayList<PooledConnection>());

    public ConnectionPool() {
        try (InputStream is = getClass().getResourceAsStream("/db.properties")) {
            Properties props = new Properties();
            props.load(is);
            jdbcClassName = "org.postgresql.Driver";// props.getProperty("jdbc.driver.class");
            jdbcUrl = props.getProperty("db.url");
            login = props.getProperty("db.username");
            passwd = props.getProperty("db.password");
            min = Integer.parseInt(props.getProperty("db.min"));
            max = Integer.parseInt(props.getProperty("db.max"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        init(min, max, jdbcClassName, jdbcUrl, login, passwd);
    }

    private void init(int min, int max, String jdbcClassName, String jdbcUrl, String login, String passwd) {
//        try {
//            Class.forName(jdbcClassName);
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
        try {
//            DriverManager.getConnection(
//                    "jdbc:postgresql://192.168.99.100:5433/postgres", login,
//                    passwd);
            try {
                Class.forName("org.postgresql.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            DriverManager.getConnection("jdbc:postgresql://192.168.99.100:5433/", login, passwd);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.min = min;
        this.max = max;
        this.jdbcUrl = jdbcUrl;
        this.login = login;
        this.passwd = passwd;
        for (int i = 0; i < this.min; i++) {
            free.add(createPooledConnection());
        }
    }

    public PooledConnection createPooledConnection() {
        try {
            Connection con = DriverManager.getConnection(jdbcUrl, login, passwd);
            PooledConnection pcon = new PooledConnection(this, con);
            return pcon;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    protected void freePooledConnection(PooledConnection pcon) {
        used.remove(pcon);
        free.add(pcon);
    }

    public Connection getConnection() throws SQLException {
        PooledConnection pcon = null;
        if (!free.isEmpty()) {
            pcon = free.remove(free.size() - 1);
        } else if (used.size() < max) {
            pcon = createPooledConnection();
        } else {
            throw new RuntimeException("Unable to create a new connection");
        }
        used.add(pcon);
        return pcon;
    }

    @Override
    protected void finalize() throws Throwable {
        for (PooledConnection pcon : free) {
            try {
                pcon.getOriginal().close();
            } catch (Exception e) {
            }
        }
        for (PooledConnection pcon : used) {
            try {
                pcon.getOriginal().close();
            } catch (Exception e) {
            }
        }
    }
}
