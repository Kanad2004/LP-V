import java.rmi.Remote;
import java.rmi.RemoteException;

public interface StringsServerIntf extends Remote {
    String getLargeString(String s1 , String s2) throws RemoteException;
}
