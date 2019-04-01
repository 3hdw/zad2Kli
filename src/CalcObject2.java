import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CalcObject2 extends Remote {
    ResultType calcute(InputType inputParam) throws RemoteException;
}
