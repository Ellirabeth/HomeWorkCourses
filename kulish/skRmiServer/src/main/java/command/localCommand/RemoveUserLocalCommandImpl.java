package command.localCommand;

import command.CreateUserCommand;
import model.UserTO;

import java.rmi.RemoteException;

public class RemoveUserLocalCommandImpl implements CreateUserCommand {

    @Override
    public UserTO execute(UserTO obj) throws RemoteException {
        return LocalCommandImpl.createUpdateUserTO(obj);
    }
}
