import UppercaseApp.*;
import org.omg.CORBA.*;

public class UppercaseImpl extends UppercasePOA {
    private ORB orb;

    public void setORB(ORB orb_val) {
        orb = orb_val;
    }

    // FIX: Capitalize the 'C' in toUpperCase
    public String toUpperCase(String str) {
        return str.toUpperCase();
    }
}