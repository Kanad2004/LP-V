import java.rmi.*;
import java.rmi.server.*;

public class DivisionServerImpl extends UnicastRemoteObject implements DivisionServerIntf {
    
    public DivisionServerImpl() throws RemoteException {
        super();
    }

    // Division logic
    public double divide(double d1, double d2) throws RemoteException {
        if (d2 == 0) {
            System.out.println("Error: Client attempted to divide by zero.");
            // Returning 0 or throwing an exception. We'll return 0 for simplicity.
            throw new ArithmeticException("Cannot divide by zero");
        }
        return d1 / d2;
    }
}