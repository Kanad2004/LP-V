import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class MilesToKmImpl extends UnicastRemoteObject implements MilesToKmIntf{
    public MilesToKmImpl() throws RemoteException{
        super();
    }

    public double convert(double miles) throws RemoteException{
        return miles * 1.60934;
    }
}
