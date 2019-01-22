package command;

import model.UserTO;

import command.localCommand.*;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RemoveUserCommandImpl extends UnicastRemoteObject implements RemoveUserCommand {

    public RemoveUserCommandImpl() throws RemoteException {
    }

    @Override
    public UserTO execute(final UserTO userTO) throws RemoteException {
        return LocalCommandImpl.removeUser();
    }
}
