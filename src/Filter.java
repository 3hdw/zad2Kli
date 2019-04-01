import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Filter extends Remote {
    Person[] filter(Person[] people, String name) throws RemoteException;
}
