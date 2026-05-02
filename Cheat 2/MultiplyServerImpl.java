import java.rmi.*;
import java.rmi.server.*;

public class MultiplyServerImpl extends UnicastRemoteObject implements MultiplyServerIntf {
    
    public MultiplyServerImpl() throws RemoteException {
        super();
    }

    // Multiplication logic
    public double multiply(double d1, double d2) throws RemoteException {
        return d1 * d2;
    }
}