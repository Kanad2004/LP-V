import java.rmi.*;
import java.rmi.server.*;

public class SubtractServerImpl extends UnicastRemoteObject implements SubtractServerIntf {
    
    public SubtractServerImpl() throws RemoteException {
        super();
    }

    // Subtraction logic: returns d1 - d2[cite: 1]
    public double subtract(double d1, double d2) throws RemoteException {
        return d1 - d2;
    }
}