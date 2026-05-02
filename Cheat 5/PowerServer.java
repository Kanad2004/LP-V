import java.rmi.*;

public class PowerServer {
    public static void main(String args[]) {
        try {
            // Instantiate the implementation and bind it to the registry[cite: 1]
            PowerServerImpl powerServerImpl = new PowerServerImpl();
            Naming.rebind("PowerServer", powerServerImpl);
            
            System.out.println("Power Server is ready and waiting for requests...");
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
    }
}
