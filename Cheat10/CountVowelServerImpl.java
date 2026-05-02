import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CountVowelServerImpl extends UnicastRemoteObject implements CountVowelServerIntf{
    public CountVowelServerImpl() throws RemoteException{
        super();
    }

    public int countVowel(String str) throws RemoteException{
        int count = 0;

        String lowerStr = str.toLowerCase();

        for(int i = 0 ; i < lowerStr.length() ; i++){
            char c = lowerStr.charAt(i);
            if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'){
                count++;
            }
        }
        return count;
    }
}
