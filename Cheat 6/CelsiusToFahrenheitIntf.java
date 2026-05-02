import java.rmi.*;

public interface CelsiusToFahrenheitIntf extends Remote {
    // Method signature for the temperature conversion
    double convert(double celsius) throws RemoteException;
}
