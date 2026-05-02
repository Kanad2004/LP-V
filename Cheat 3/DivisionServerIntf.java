import java.rmi.*;

public interface DivisionServerIntf extends Remote {
    // Method signature for division
    double divide(double d1, double d2) throws RemoteException;
}