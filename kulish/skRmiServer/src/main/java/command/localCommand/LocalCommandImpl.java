package command.localCommand;

import model.UserTO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.rmi.RemoteException;

public class LocalCommandImpl {
    public static UserTO createUpdateUserTO(UserTO user) throws RemoteException {
        try {
            Configuration configuration = new Configuration().configure();
            SessionFactory sessionFactory = configuration.buildSessionFactory();
            Session session = sessionFactory.openSession();
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
            throw new RemoteException(ex.getMessage(), ex);
        }
        return user;
    }

    public static UserTO removeUser() {
            UserTO removedUser = null;
//        for (UserTO user : rmiserver.users) {
//            if (user.getId().equals(userTO.getId())) {
//                removedUser = user;
//                break;
//            }
//        }
//
//        if(!rmiserver.users.remove(removedUser)) {
//            throw new RemoteException(removedUser.getId()+" not exist");
//        }
//        System.out.println(rmiserver.users.size());
            return removedUser;
    }
}
