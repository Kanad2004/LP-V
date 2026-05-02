import java.rmi.Naming;

public class MultiplyServer {
    public static void main(String[] args) {
        try {
            MultiplyServerImpl multiplyServerImpl = new MultiplyServerImpl();

            Naming.rebind("MultiplyServer", multiplyServerImpl);

            System.out.println("Multiplication server is ready ...");
        } catch (Exception e) {
            System.out.println("Exception : " + e);
        }

    }
}