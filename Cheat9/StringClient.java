import java.rmi.Naming;

public class StringClient{
    public static void main(String[] args) {
        try{
            String serverUrl = "rmi://" + args[0] + "/StringsServer";
            StringsServerIntf stringsServerIntf = (StringsServerIntf) Naming.lookup(serverUrl);

            String s1 = args[1];
            String s2 = args[2];

            System.out.println("First name : " + s1);
            System.out.println("Second name : " + s2);

            String result = stringsServerIntf.getLargeString(s1, s2);

            System.out.println("The lexographically big string is : " + result);
        }catch(Exception e){
            System.out.println("Exception : " + e);
        }
    }
}