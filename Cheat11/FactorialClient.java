import java.rmi.Naming;

public class FactorialClient {
    public static void main(String[] args) {
        try{
            String serverUrl = "rmi://" + args[0] + "/FactorialServer";
            FactorialServerIntf factorialServerIntf = (FactorialServerIntf) Naming.lookup(serverUrl);

            int n = Integer.parseInt(args[1]);
        
            System.out.println("Sending number to server : " + n);

            int res = factorialServerIntf.factorial(n);

            System.out.println("Response from server : " + res);
        }catch(Exception e){
            System.out.println("Exception : " + e);
        }
    }
}
