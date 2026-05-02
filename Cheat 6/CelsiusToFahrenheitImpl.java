import java.rmi.*;
import java.rmi.server.*;

public class CelsiusToFahrenheitImpl extends UnicastRemoteObject implements CelsiusToFahrenheitIntf {
    
    public CelsiusToFahrenheitImpl() throws RemoteException {
        super();
    }

    // Logic to convert Celsius to Fahrenheit[cite: 1]
    public double convert(double celsius) throws RemoteException {
        return (celsius * 9.0 / 5.0) + 32.0;
    }
}
