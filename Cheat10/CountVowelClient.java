import java.rmi.Naming;

public class CountVowelClient {
    public static void main(String[] args) {
        try{
            String serverUrl = "rmi://" + args[0] + "/CountVowelServer";
            CountVowelServerIntf countVowelServerIntf = (CountVowelServerIntf) Naming.lookup(serverUrl);

            String word = args[1];

            System.out.println("Sending word to server : " + word);

            int count = countVowelServerIntf.countVowel(word);

            System.out.println("Total number of vowels in word :" + word + " is : " + count);
        }catch(Exception e){
            System.out.println("Exception : " + e);
        }
    }
}
