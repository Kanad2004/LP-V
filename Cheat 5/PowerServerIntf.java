import java.rmi.*;

public interface PowerServerIntf extends Remote {
    // Method signature for calculating power[cite: 1]
    double calculatePower(double n) throws RemoteException;
}
