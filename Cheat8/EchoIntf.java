import java.rmi.Remote;
import java.rmi.RemoteException;

public interface EchoIntf extends Remote {
    String echo(String name) throws RemoteException;
}
