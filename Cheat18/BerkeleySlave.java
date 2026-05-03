import java.io.*;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class BerkeleySlave{
    public static void main(String[] args) {
        try{
            Scanner sc = new Scanner(System.in);
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");

            System.out.print("Enter Master's IP Address (or type localhost if on same machine): ");
            String ip = sc.nextLine();

            System.out.print("Enter Slave's time (HH:mm): ");
            String timeStr = sc.nextLine();
            long slaveTime = sdf.parse(timeStr).getTime();

            Socket s = new Socket(ip, 6000);
            DataInputStream din = new DataInputStream(s.getInputStream());
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());

            dout.writeUTF(timeStr);
            System.out.println("Sent current time " + timeStr + " to Master.");

            long adjustment = din.readLong();
            System.out.println("\nReceived adjustment offset from Master: " + (adjustment / 60000) + " minutes.");


            long newSlaveTime = slaveTime + adjustment;
            System.out.println("Synchronized Slave Time set to: " + sdf.format(new Date(newSlaveTime)));

            s.close();
            sc.close();

        }
        catch(Exception e){
            System.out.println("Connection Error. Is the Master running? (" + e.getMessage() + ")");
        }
    }
}