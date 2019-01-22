package command.localCommand;

import command.CreateUserCommand;
import model.UserTO;

import java.rmi.RemoteException;

public class CreateUserLocalCommandImpl implements CreateUserCommand {

    @Override
    public UserTO execute(UserTO obj) throws RemoteException {
        return LocalCommandImpl.createUpdateUserTO(obj);
    }
}
