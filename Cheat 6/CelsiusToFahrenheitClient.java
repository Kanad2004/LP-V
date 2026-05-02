import java.rmi.*;

public class CelsiusToFahrenheitClient {
    public static void main(String args[]) {
        try {
            // URL format: rmi://<ServerIP>/CelsiusToFahrenheitServer[cite: 1]
            String serverURL = "rmi://" + args[0] + "/CelsiusToFahrenheitServer";
            CelsiusToFahrenheitIntf cToFIntf = (CelsiusToFahrenheitIntf) Naming.lookup(serverURL);

            // Fetch the Celsius temperature from the command line[cite: 1]
            double celsius = Double.parseDouble(args[1]);

            System.out.println("Temperature in Celsius: " + celsius);
            
            // Calling the remote conversion method[cite: 1]
            double fahrenheit = cToFIntf.convert(celsius);
            System.out.println("Temperature in Fahrenheit is: " + fahrenheit);

        } catch (Exception e) {
            System.out.println("Exception: " + e);
            System.out.println("Usage: java CelsiusToFahrenheitClient <ServerIP> <CelsiusValue>");
        }
    }
}
