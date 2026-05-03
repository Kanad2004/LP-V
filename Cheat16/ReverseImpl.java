import ReverseApp.*;
import org.omg.CORBA.*;

// This class extends the auto-generated POA (Portable Object Adapter) class
public class ReverseImpl extends ReversePOA {
    private ORB orb;

    public void setORB(ORB orb_val) {
        orb = orb_val;
    }

    // The logic to reverse the string
    public String reverseString(String str) {
        StringBuilder sb = new StringBuilder(str);
        return sb.reverse().toString();
    }
}