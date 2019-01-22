package command;

import model.TransferObject;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.concurrent.ExecutionException;

public interface ServerCommandManager extends Remote, Serializable {

    <T, D extends TransferObject> D startCommand(final Class<T> clazz, D obj) throws RemoteException, ExecutionException, InterruptedException;

}
