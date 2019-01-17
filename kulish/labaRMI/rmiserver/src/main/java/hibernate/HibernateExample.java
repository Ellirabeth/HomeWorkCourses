package hibernate;

import java.io.IOException;

import model.User;
import org.hibernate.MappingException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateExample {

    public static void main(String[] args) throws MappingException, IOException {
        User user = new User();
        user.setName("Doe");
        user.setPasswd("dsd");
        createUser(user);
    }

    private static void createUser(User user) {
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.getTransaction();
        try {
//            tx.begin();
//            Query query = session.createQuery("from User where name='Joe'");
//            List<Employee> empList = query.list();
//            System.out.println("Employees found: " + empList.size());
//            for(Employee emp: empList) {
//                session.delete(emp);
//                System.out.println("Deleted " + emp);
//            }
//            tx.commit();

            System.out.println("Create new user");
            tx = session.getTransaction();
            tx.begin();
            //User emp = new User();
            //emp.setName(name);
            //emp.setPasswd("dsd");
            session.saveOrUpdate(user);
            tx.commit();

            //Query query = session.createQuery("from User where name='Joe2'");
            //System.out.println("List all users: " + query.list());
        } catch (RuntimeException e) {
            tx.rollback();
            throw e;

        } finally {
            session.close();
        }
    }
}
