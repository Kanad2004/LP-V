import ReverseApp.*;
import org.omg.CORBA.*;
import org.omg.CosNaming.*;
import java.util.Scanner;

public class ReverseClient {
    public static void main(String args[]) {
        try {
            // 1. Create and initialize the ORB
            ORB orb = ORB.init(args, null);

            // 2. Get the root naming context
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

            // 3. Resolve the Object Reference in Naming
            Reverse reverseImpl = ReverseHelper.narrow(ncRef.resolve_str("Reverse"));

            // 4. Take input from the user
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter a string to reverse: ");
            String str = scanner.nextLine();

            // 5. Call the remote reverse method
            String reversedStr = reverseImpl.reverseString(str);
            System.out.println("Reversed String from Server: " + reversedStr);

        } catch (Exception e) {
            System.out.println("ERROR : " + e);
        }
    }
}