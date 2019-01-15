import command.CreateUserCommand;
import model.UserTO;
import sqlbuilder.SqlBuilder;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CreateUserCommandImpl extends UnicastRemoteObject implements CreateUserCommand, Remote {

    //@Inject()
    //SqlBuilder sqlBuilder;

    public CreateUserCommandImpl() throws RemoteException {
    }

    @Override
    public UserTO execute(final UserTO user) throws RemoteException {
        try {
            //sqlBuilder.getInsertSQL(user);
            //UserTO s=null;
            //s.setId(1l);
            user.setId(++rmiserver.currentUserId);

            System.out.println(rmiserver.users.size());
        } catch (RuntimeException ex) {
            throw new RemoteException(ex.getMessage(), ex);
        }
        return user;
    }
}
