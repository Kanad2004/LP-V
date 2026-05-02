import java.rmi.Naming;

public class MilesToKmClient {
    public static void main(String[] args) {
        try{
            String serverUrl = "rmi://" + args[0] + "/MilesToKmServer";
            MilesToKmIntf milesToKmIntf = (MilesToKmIntf) Naming.lookup(serverUrl);

            double miles = Double.parseDouble(args[1]);

            System.out.println("Distance in miles : " + miles);

            double km = milesToKmIntf.convert(miles);

            System.out.println("Distance in kilometres : " + km);
        }catch(Exception e){
            System.out.println("Exception : " + e);
        }
    }
}
