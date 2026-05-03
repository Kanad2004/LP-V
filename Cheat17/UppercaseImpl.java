import UppercaseApp.*;
import org.omg.CORBA.*;

public class UppercaseImpl extends UppercasePOA {
    private ORB orb;

    public void setORB(ORB orb_val) {
        orb = orb_val;
    }

    // The actual method that converts the string
    public String toUpperCase(String str) {
        return str.toUpperCase();
    }
}