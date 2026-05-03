import ReverseApp.*;
import org.omg.CORBA.*;
import org.omg.CosNaming.*;
import org.omg.PortableServer.*;

public class ReverseServer {
    public static void main(String args[]) {
        try {
            // 1. Create and initialize the ORB
            ORB orb = ORB.init(args, null);

            // 2. Get reference to rootpoa & activate the POAManager
            POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            rootpoa.the_POAManager().activate();

            // 3. Create servant and register it with the ORB
            ReverseImpl reverseImpl = new ReverseImpl();
            reverseImpl.setORB(orb);

            // 4. Get object reference from the servant
            org.omg.CORBA.Object ref = rootpoa.servant_to_reference(reverseImpl);
            Reverse href = ReverseHelper.narrow(ref);

            // 5. Get the root naming context
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

            // 6. Bind the Object Reference in Naming
            NameComponent path[] = ncRef.to_name("Reverse");
            ncRef.rebind(path, href);

            System.out.println("Reverse Server ready and waiting for client requests...");

            // 7. Wait for invocations from clients
            orb.run();
        } catch (Exception e) {
            System.err.println("ERROR: " + e);
        }
    }
}