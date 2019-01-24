import model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.ejb.EntityManagerImpl;
import org.jglue.cdiunit.AdditionalClasses;
import org.jglue.cdiunit.CdiRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.rmi.RemoteException;

@RunWith(CdiRunner.class) // Runs the test with CDI-Unit
@AdditionalClasses(EntityManagerProducer.class)
public class MyTest {



    @Inject
    private EntityManagerFactory entityManagerFactory;

    @Inject
    private EntityManager entityManager;



    @Test
    public void getSomething() {
        System.out.println("foo");// + something.toString());
        System.out.println("emf" + entityManagerFactory);
        System.out.println("em" + entityManager);

        try {
//            Configuration configuration = new Configuration().configure();
//            SessionFactory sessionFactory = configuration.buildSessionFactory();
//            Session session = sessionFactory.openSession();
            Session session = ((EntityManagerImpl) entityManager).getSession();
            Transaction tx = session.getTransaction();
            try {
//                tx.begin();
//                Query query = session.createQuery("from Employee where name='Joe'");
//                List<Employee> empList = query.list();
//                System.out.println("Employees found: " + empList.size());
//                for(Employee emp: empList) {
//                    session.delete(emp);
//                    System.out.println("Deleted " + emp);
//                }
//                tx.commit();

                System.out.println("Create new employee");
                tx = session.getTransaction();
                tx.begin();
                User user = new User();
                user.setName("admin");
                user.setPasswd("admin");
                session.saveOrUpdate(user);
                tx.commit();

//                query = session.createQuery("from Employee where name='Joe'");
//                System.out.println("List all employees: " + query.list());
            } catch (RuntimeException e) {
                tx.rollback();
                throw e;

            } finally {
                session.close();
            }
            //sqlBuilder.getInsertSQL(user);
            //UserTO s=null;
            //s.setId(1l);
//            user.setId(++rmiserver.currentUserId);
//
//            System.out.println(rmiserver.users.size());
        } catch (RuntimeException ex) {
            //throw new RemoteException(ex.getMessage(), ex);
            System.out.println(ex.getMessage());
        }
        //return nulluser;
    }



}



