import command.Command;
import model.TransferObject;

import java.util.concurrent.Callable;

    public class CommandWorker<T extends TransferObject> implements Callable<T> {

        private Command<T> command;
        private T transferObject;

        public CommandWorker(final Command<T> command, final T transferObject) {
            this.command = command;
            this.transferObject = transferObject;
        }

        @Override
        public T call() throws Exception {
            try {
                return command.execute(transferObject);
            } catch (Exception ex) {
                return null;
            }
        }
    }