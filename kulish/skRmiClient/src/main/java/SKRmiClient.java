import command.CreateUserCommand;
import command.IRmiCommandManager;
import model.User;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class SKRmiClient {
    private IRmiCommandManager commandManager;

    SKRmiClient(boolean isLocal) {
        try {
            if(isLocal) {
                commandManager = new LocalServerCommandManagerImpl();
            } else {
                Registry registry = LocateRegistry.getRegistry(2005);
                commandManager = new RmiCommandManager(registry);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    User addUser(User user) throws Exception {
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
