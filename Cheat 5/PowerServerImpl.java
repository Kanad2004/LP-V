import java.rmi.*;
import java.rmi.server.*;

public class PowerServerImpl extends UnicastRemoteObject implements PowerServerIntf {
    
    public PowerServerImpl() throws RemoteException {
        super();
    }

    // Logic to calculate 2 to the power of N[cite: 1]
    public double calculatePower(double n) throws RemoteException {
        return Math.pow(n , 2);
    }
}
