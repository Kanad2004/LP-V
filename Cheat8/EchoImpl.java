import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class EchoImpl extends UnicastRemoteObject implements EchoIntf{
    public EchoImpl() throws RemoteException{
        super();
    }

    public String echo(String name){
        return "Hello" + name;
    }
}
