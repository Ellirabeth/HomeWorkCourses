import command.CreateUserCommand;
import model.User;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class SKRmiClient {

    public void SKRmiClient() {
        try {
            Registry registry = LocateRegistry.getRegistry(2005);

            RmiCommandManager commandManager = new RmiCommandManager(registry);
            User usr = new User();
            usr.setName("admin");
            usr.setPasswd("123");
            User user = commandManager.startCommand(CreateUserCommand.class, usr);

            System.out.println(user.getId() + " " + user.getName() + " " + user.getPasswd());
//            commands.put(CreateUserCommand.class, new CreateUserCommandImpl());
//            scm.setCommands(commands);
//
//            Remote remoteServerCommandManager = null;
//            remoteServerCommandManager = UnicastRemoteObject.exportObject(scm, 2005);
//
//            registry.bind(ServerCommandManager.class.getName(), remoteServerCommandManager);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
