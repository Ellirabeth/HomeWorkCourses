import command.IRmiCommandManager;
import command.ServerCommandManager;
import lombok.Setter;
import model.TransferObject;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.util.concurrent.ExecutionException;

public class RmiCommandManager implements IRmiCommandManager {

        @Setter
        private Registry registry;

        private ServerCommandManager scm;

        public RmiCommandManager(final Registry registry) throws RemoteException, NotBoundException {
            this.registry = registry;
            scm = (ServerCommandManager) registry.lookup(ServerCommandManager.class.getName());
        }

        public <T, D extends TransferObject> D startCommand(final Class<T> clazz, final D obj) throws RemoteException, ExecutionException, InterruptedException {
            D result = scm.startCommand(clazz, obj);
            return result;
        }
    }
