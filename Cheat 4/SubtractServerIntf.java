import java.rmi.*;

public interface SubtractServerIntf extends Remote {
    // Method signature for subtraction[cite: 1]
    double subtract(double d1, double d2) throws RemoteException;
}