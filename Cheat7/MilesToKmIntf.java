import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MilesToKmIntf extends Remote{
    double convert(double miles) throws RemoteException;
}
