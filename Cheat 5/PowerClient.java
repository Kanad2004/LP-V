import java.rmi.*;

public class PowerClient {
    public static void main(String args[]) {
        try {
            // URL format: rmi://<ServerIP>/PowerServer[cite: 1]
            String powerServerURL = "rmi://" + args[0] + "/PowerServer";
            PowerServerIntf powerServerIntf = (PowerServerIntf) Naming.lookup(powerServerURL);

            // Fetch the number from the command line[cite: 1]
            // We only need one number for this specific operation
            double n = Double.parseDouble(args[1]);

            System.out.println("The given number (N) is: " + n);
            
            // Calling the remote power method[cite: 1]
            System.out.println("2 raised to the power of " + n + " is: " + powerServerIntf.calculatePower(n));

        } catch (Exception e) {
            System.out.println("Exception: " + e);
            System.out.println("Usage: java PowerClient <ServerIP> <Number>");
        }
    }
}
