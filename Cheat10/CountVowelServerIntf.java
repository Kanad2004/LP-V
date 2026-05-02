import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CountVowelServerIntf extends Remote {
    int countVowel(String str) throws RemoteException;
}
