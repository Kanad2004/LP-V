import java.rmi.*;

public class DivisionClient {
    public static void main(String args[]) {
        try {
            // URL format: rmi://<ServerIP>/DivisionServer
            String divisionServerURL = "rmi://" + args[0] + "/DivisionServer";
            DivisionServerIntf divisionServerIntf = (DivisionServerIntf) Naming.lookup(divisionServerURL);

            double d1 = Double.parseDouble(args[1]);
            double d2 = Double.parseDouble(args[2]);

            System.out.println("The Dividend (first number) is: " + d1);
            System.out.println("The Divisor (second number) is: " + d2);
            
            // Calling the remote division method
            System.out.println("The Quotient is: " + divisionServerIntf.divide(d1, d2));

        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
    }
}