package command;

import model.TransferObject;

import java.rmi.RemoteException;
import java.util.concurrent.ExecutionException;

public interface IRmiCommandManager {
    <T, D extends TransferObject> D startCommand(final Class<T> clazz, final D obj) throws Exception;
}
