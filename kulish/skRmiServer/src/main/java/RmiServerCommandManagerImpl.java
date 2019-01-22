import command.Command;
import command.IRmiCommandManager;
import command.ServerCommandManager;
import lombok.Setter;
import model.TransferObject;

import java.rmi.RemoteException;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class RmiServerCommandManagerImpl  implements ServerCommandManager, IRmiCommandManager {

        @Setter
        private Map<Class, Command> commands;

        @Override
        public <T, D extends TransferObject> D startCommand(final Class<T> clazz, D obj) throws RemoteException, ExecutionException, InterruptedException {
            Future<D> future = RmiServer.executorService.submit(new CommandWorker<D>(commands.get(clazz), obj));

            return future.get();
        }
}