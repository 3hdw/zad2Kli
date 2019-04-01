import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Concat extends Remote {
    Person[] concat(Person[] peopleA, Person[] peopleB) throws RemoteException;
}
