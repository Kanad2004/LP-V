import java.io.*;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class BerkeleyMaster{
    public static void main(String[] args) {
        try{
            Scanner sc = new Scanner(System.in);
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");

            System.out.println("Enter Master's time (HH:mm) : ");
            String timeStr = sc.nextLine();
            long masterTime = sdf.parse(timeStr).getTime();

            ServerSocket ss = new ServerSocket(6000);
            System.out.println("Master Coordinator is running on port 6000. Waiting for Slave...");

            Socket s = ss.accept();
            System.out.println("Slave node connected");

            DataInputStream din = new DataInputStream(s.getInputStream());
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());

            String slaveTimeStr = din.readUTF();
            long slaveTime = sdf.parse(slaveTimeStr).getTime();
            System.out.println("Received Slave's time: " + slaveTimeStr);


            long diff = slaveTime - masterTime;
            long avgDiff = diff / 2;


            System.out.println("\n--- Synchronization Calculation ---");
            System.out.println("Calculated Average Difference: " + (avgDiff / 60000) + " minutes.");

            long newMasterTime = masterTime + avgDiff;
            System.out.println("Synchronized Master Time set to: " + sdf.format(new Date(newMasterTime)));

            long slaveAdjustment = newMasterTime - slaveTime;
            dout.writeLong(slaveAdjustment);
            System.out.println("Sent adjustment offset of " + (slaveAdjustment / 60000) + " minutes to Slave.");

            s.close();
            ss.close();
            sc.close();
        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}