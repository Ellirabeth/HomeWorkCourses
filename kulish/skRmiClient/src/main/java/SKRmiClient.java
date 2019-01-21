import command.CreateUserCommand;
import model.User;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.concurrent.ExecutionException;

public class SKRmiClient {
    private RmiCommandManager commandManager;

    SKRmiClient() {
        try {
            Registry registry = LocateRegistry.getRegistry(2005);

            commandManager = new RmiCommandManager(registry);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    User addUser(User user) throws InterruptedException, ExecutionException, RemoteException {
        User resUser = commandManager.startCommand(CreateUserCommand.class, user);

        System.out.println(user.getId() + " " + user.getName() + " " + user.getPasswd());
        return resUser;
//            commands.put(CreateUserCommand.class, new CreateUserCommandImpl());
//            scm.setCommands(commands);
//
//            Remote remoteServerCommandManager = null;
//            remoteServerCommandManager = UnicastRemoteObject.exportObject(scm, 2005);
//
//            registry.bind(ServerCommandManager.class.getName(), remoteServerCommandManager);

    }
}
