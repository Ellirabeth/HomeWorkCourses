package command;

import model.UserTO;

import command.localCommand.*;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CreateUserCommandImpl extends UnicastRemoteObject implements CreateUserCommand, Remote {

    public CreateUserCommandImpl() throws RemoteException {
    }

    @Override
    public UserTO execute(final UserTO user) throws RemoteException {
        return LocalCommandImpl.createUpdateUserTO(user);
    }
}
