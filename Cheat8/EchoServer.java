import java.rmi.Naming;

public class EchoServer {
    public static void main(String[] args) {
        try{
            EchoImpl echoImpl = new EchoImpl();
            Naming.rebind("EchoServer", echoImpl);
            System.out.println("Echo Server running....");            
        }catch(Exception e){
            System.out.println("Exception : " + e);
        }
    }   
}
