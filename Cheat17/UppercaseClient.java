import UppercaseApp.*;
import org.omg.CORBA.*;
import org.omg.CosNaming.*;
import java.util.Scanner;

public class UppercaseClient {
    public static void main(String args[]) {
        try {
            // 1. Initialize the ORB
            ORB orb = ORB.init(args, null);

            // 2. Get the root naming context
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

            // 3. Resolve the Object Reference in Naming
            Uppercase uppercaseImpl = UppercaseHelper.narrow(ncRef.resolve_str("Uppercase"));

            // 4. Take input from the user
            Scanner scanner = new Scanner(System.in);
           System.out.print("Enter a string to convert to uppercase: ");
            String str = scanner.nextLine();

            // FIX: Capitalize the 'C' in toUpperCase
            String upperStr = uppercaseImpl.toUpperCase(str);
            System.out.println("Uppercase String from Server: " + upperStr);
        } catch (Exception e) {
            System.out.println("ERROR : " + e);
        }
    }
}