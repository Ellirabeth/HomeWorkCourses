package command;

import command.RemoveUserCommand;
import model.UserTO;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RemoveUserCommandImpl extends UnicastRemoteObject implements RemoveUserCommand {

    public RemoveUserCommandImpl() throws RemoteException {
    }

    @Override
    public UserTO execute(final UserTO userTO) throws RemoteException {
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
