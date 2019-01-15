import command.Command;
import command.CreateUserCommand;
import command.RemoveUserCommand;
import command.ServerCommandManager;
import model.User;
import model.UserTO;

import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class rmiserver {
    public static List<UserTO> users = new ArrayList<>();

    public static final ExecutorService executorService = Executors.newFixedThreadPool(10);
    public static Long currentUserId = 0L;

    public static void main(String args[]) {
        //    Naming.rebind("//localhost/TheBroker", brokerModel);
        ServerCommandManagerImpl scm = new ServerCommandManagerImpl();

        try {
            Registry registry = LocateRegistry.createRegistry(2005);

            Map<Class, Command> commands = new HashMap<>();
//        commands.put(RemoveUserCommand.class, new RemoveUserCommandImpl());
            commands.put(CreateUserCommand.class, new CreateUserCommandImpl());
            scm.setCommands(commands);

            Remote remoteServerCommandManager = UnicastRemoteObject.exportObject(scm, 2005);

            registry.bind(ServerCommandManager.class.getName(), remoteServerCommandManager);
        } catch (RemoteException | AlreadyBoundException e) {
            e.printStackTrace();
        }
    }
}
