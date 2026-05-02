import java.rmi.*;

public class CelsiusToFahrenheitServer {
    public static void main(String args[]) {
        try {
            // Instantiate the implementation and bind it to the registry[cite: 1]
            CelsiusToFahrenheitImpl cToFImpl = new CelsiusToFahrenheitImpl();
            Naming.rebind("CelsiusToFahrenheitServer", cToFImpl);
            
            System.out.println("Celsius to Fahrenheit Server is ready and waiting for requests...");
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
    }
}
