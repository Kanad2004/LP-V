import java.rmi.Naming;

public class MilesToKmServer {
    public static void main(String[] args) {
        try{
            MilesToKmImpl milesToKmImpl = new MilesToKmImpl();
            Naming.rebind("MilesToKmServer", milesToKmImpl);

            System.out.println("MilesToKmServer running ....");
        }catch(Exception e){
            System.out.println("Exception : " + e);
        }
    }
}
