import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class StringsServerImpl extends UnicastRemoteObject implements StringsServerIntf{
    public StringsServerImpl() throws RemoteException{
        super();
    }

    public String getLargeString(String s1 , String s2) throws RemoteException{
        if(s1.compareTo(s2) > 0){
            return s1;
        }
        else if(s1.compareTo(s2) < 0){
            return s2;
        }
        System.out.println("Both are lexographically same : " + s1 );
        return s1;
    }
}
