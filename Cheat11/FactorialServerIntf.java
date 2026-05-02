import java.rmi.Remote;
import java.rmi.RemoteException;

public interface FactorialServerIntf extends Remote {
    int factorial(int n) throws RemoteException;
}
