import java.rmi.*;

public class DivisionServer {
    public static void main(String args[]) {
        try {
            // Instantiate the implementation and bind it
            DivisionServerImpl divisionServerImpl = new DivisionServerImpl();
            Naming.rebind("DivisionServer", divisionServerImpl);
            
            System.out.println("Division Server is ready and waiting for requests...");
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
    }
}