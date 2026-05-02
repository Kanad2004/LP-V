import java.rmi.Naming;

public class EchoClient {
    public static void main(String[] args) {
        try{
            String serverUrl = "rmi://" + args[0] + "/EchoServer";
            EchoIntf echoIntf = (EchoIntf) Naming.lookup(serverUrl);

            String name = args[1];
            
            System.out.println("Sending name to server : " + name);

            String response = echoIntf.echo(name);

            System.out.println("Echoced name : " + response);
        }catch(Exception e){
            System.out.println("Exception : " + e );
        }
    }
}
