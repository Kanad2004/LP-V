import java.rmi.Naming;

public class MultiplyClient {
    public static void main(String[] args) {
        try{
            String multiplyServerURL = "rmi://" + args[0] + "/MultiplyServer";
            MultiplyServerIntf multiplyServerIntf = (MultiplyServerIntf) Naming.lookup(multiplyServerURL);

            double d1 = Double.parseDouble(args[1]);
            double d2 = Double.parseDouble(args[2]);

            System.out.println("Number 1 : " + d1);
            System.out.println("Number 2 : " + d2);

            System.out.println("Product: " + multiplyServerIntf.multiply(d1, d2));
        }catch(Exception e){
            System.out.println("Exception: " + e);
        }
    }
}