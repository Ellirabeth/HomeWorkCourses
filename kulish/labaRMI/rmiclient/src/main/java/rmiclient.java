import command.Command;
import command.CreateUserCommand;
import javafx.concurrent.Worker;
import model.User;

import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class rmiclient {
    public static void main(String args[]) throws NotBoundException, ExecutionException, InterruptedException {
        //    Naming.rebind("//localhost/TheBroker", brokerModel);
        //    Naming.rebind("//localhost/TheBroker", brokerModel);
        //ServerCommandManagerImpl scm = new ServerCommandManagerImpl();

//        List<Thread> d = new ArrayList<>();
//for(int i = 0; i < 10; i++) {
//    Thread ldap = new Thread() {
//        @Override
//        public void run() {
            try {
                Registry registry = LocateRegistry.getRegistry(2005);

                //Map<Class, Command> commands = new HashMap<>();
//        commands.put(RemoveUserCommand.class, new RemoveUserCommandImpl());
                //registry.

                CommandManager commandManager = new CommandManager(registry);
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
        //}
    //};
//    d.add(ldap);
//}
//for(int i = 0; i < 10; i++) {
//    d.get(i).run();
//}
//        try {
//            Registry registry = LocateRegistry.getRegistry(2005);
//
//            //Map<Class, Command> commands = new HashMap<>();
////        commands.put(RemoveUserCommand.class, new RemoveUserCommandImpl());
//            //registry.
//
//            CommandManager commandManager = new CommandManager(registry);
//            User usr = new User();
//            usr.setName("admin");
//            usr.setPasswd("123");
//            User user = commandManager.startCommand(CreateUserCommand.class, usr);
//
//            System.out.println(user.getId() + " " + user.getName() + " " + user.getPasswd());
////            commands.put(CreateUserCommand.class, new CreateUserCommandImpl());
////            scm.setCommands(commands);
////
////            Remote remoteServerCommandManager = null;
////            remoteServerCommandManager = UnicastRemoteObject.exportObject(scm, 2005);
////
////            registry.bind(ServerCommandManager.class.getName(), remoteServerCommandManager);
//        } catch (RemoteException e) {
//            e.printStackTrace();
//        }

    }
}
