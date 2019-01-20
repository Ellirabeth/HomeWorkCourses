import command.*;

import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RmiServer {
    public static final ExecutorService executorService = Executors.newFixedThreadPool(10);

    public static void main(String args[]) throws RemoteException {
        RmiServerCommandManagerImpl scm = new RmiServerCommandManagerImpl();

        try {
            Registry registry = LocateRegistry.createRegistry(2005);

            Map<Class, Command> commands = new HashMap<>();
            commands.put(RemoveUserCommand.class, new RemoveUserCommandImpl());
            commands.put(CreateUserCommand.class, new CreateUserCommandImpl());
            scm.setCommands(commands);

            Remote remoteServerCommandManager = UnicastRemoteObject.exportObject(scm, 2005);

            registry.bind(ServerCommandManager.class.getName(), remoteServerCommandManager);
        } catch (RemoteException | AlreadyBoundException e) {
            e.printStackTrace();
        }
    }
}
