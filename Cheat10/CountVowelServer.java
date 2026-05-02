

import java.rmi.Naming;

public class CountVowelServer {
    public static void main(String[] args) {
        try{
            CountVowelServerImpl countVowelServerImpl = new CountVowelServerImpl();
            Naming.rebind("CountVowelServer", countVowelServerImpl);
            System.out.println("Server listening");
        }catch(Exception e){
            System.out.println("Exception : " +  e);
        }
    }
}
