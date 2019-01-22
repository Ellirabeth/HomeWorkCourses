import command.*;
import model.TransferObject;

import command.localCommand.*;

import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;

public class LocalServerCommandManagerImpl implements command.IRmiCommandManager {

    private Map<Class, Command> commands;

    public LocalServerCommandManagerImpl() throws RemoteException {
        commands = new HashMap<>();
        commands.put(RemoveUserCommand.class, new RemoveUserLocalCommandImpl());
        commands.put(CreateUserCommand.class, new CreateUserLocalCommandImpl());
    }

    @Override
    public <T, D extends TransferObject> D startCommand(Class<T> clazz, D obj) throws Exception {
        CommandWorker<D> dCommandWorker = new CommandWorker<D>(commands.get(clazz), obj);
        return dCommandWorker.call();
    }
}
