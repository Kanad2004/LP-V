import java.rmi.Naming;

public class FactorialServer {
    public static void main(String[] args) {
        try{
            FactorialServerImpl factorialServerImpl = new FactorialServerImpl();
            Naming.rebind("FactorialServer", factorialServerImpl);
            System.out.println("Server listening...");
        }catch(Exception e){
            System.out.println("Exception : " + e);
        }
    }
}
