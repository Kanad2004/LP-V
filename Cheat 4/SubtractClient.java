import java.rmi.*;

public class SubtractClient {
    public static void main(String args[]) {
        try {
            // URL format: rmi://<ServerIP>/SubtractServer[cite: 1]
            String subtractServerURL = "rmi://" + args[0] + "/SubtractServer";
            SubtractServerIntf subtractServerIntf = (SubtractServerIntf) Naming.lookup(subtractServerURL);

            // Fetch numbers from the command line[cite: 1]
            double d1 = Double.parseDouble(args[1]);
            double d2 = Double.parseDouble(args[2]);

            System.out.println("The first number is: " + d1);
            System.out.println("The second number is: " + d2);
            
            // Calling the remote subtraction method[cite: 1]
            System.out.println("The difference is: " + subtractServerIntf.subtract(d1, d2));

        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
    }
}