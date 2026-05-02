import java.rmi.*;

public class SubtractServer {
    public static void main(String args[]) {
        try {
            // Instantiate the implementation and bind it to the registry[cite: 1]
            SubtractServerImpl subtractServerImpl = new SubtractServerImpl();
            Naming.rebind("SubtractServer", subtractServerImpl);
            
            System.out.println("Subtraction Server is ready and waiting for requests...");
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
    }
}