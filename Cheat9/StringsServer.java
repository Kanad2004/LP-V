import java.rmi.Naming;

public class StringsServer {
    public static void main(String[] args) {
        try{
            StringsServerImpl stringsServerImpl = new StringsServerImpl();
            Naming.rebind("StringsServer", stringsServerImpl);
            System.out.println("Server listening ...");
        }catch(Exception e){
            System.out.println("Exception : " + e);
        }
    }
}
