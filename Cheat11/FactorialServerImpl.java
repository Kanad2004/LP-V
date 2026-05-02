import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class FactorialServerImpl  extends UnicastRemoteObject implements FactorialServerIntf{
    public FactorialServerImpl() throws RemoteException{
        super();
    }

    public int factorial(int n) throws RemoteException{
        if(n == 0 || n == 1) return 1;
        return n * factorial(n - 1);
    }
}
