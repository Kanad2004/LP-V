import java.rmi.*;

public interface MultiplyServerIntf extends Remote {
    // Method signature for multiplication
    double multiply(double d1, double d2) throws RemoteException;
}