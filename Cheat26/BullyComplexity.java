import java.util.*;

public class BullyComplexity {

    static boolean[] alive;
    static int n;
    static int messageCount = 0; // Counter to track message complexity

    static void election(int p) {
        System.out.println("\n--> Process " + p + " initiates an ELECTION!");

        boolean higherResponded = false;

        // Step 1: Send ELECTION messages to all higher processes
        for (int i = p + 1; i < n; i++) {
            System.out.println("Message: Process " + p + " sends [ELECTION] to Process " + i);
            messageCount++;
        }

        // Step 2: Higher processes that are alive reply with OK
        for (int i = p + 1; i < n; i++) {
            if (alive[i]) {
                System.out.println("Message: Process " + i + " responds with [OK] to Process " + p);
                messageCount++;
                higherResponded = true;
            }
        }

        // Step 3: If a higher process responded, it takes over the election
        if (higherResponded) {
            for (int i = p + 1; i < n; i++) {
                if (alive[i]) {
                    System.out.println("Process " + i + " takes over the election...");
                    election(i);
                    return; // Current process stops its election
                }
            }
        }

        // Step 4: If NO higher process responded, this process wins
        System.out.println("\n*** WINNER: Process " + p + " is the new COORDINATOR! ***");

        // Step 5: Send COORDINATOR message to all active processes
        for (int i = 0; i < n; i++) {
            if (i != p && alive[i]) {
                System.out.println("Message: Process " + p + " sends [COORDINATOR] to Process " + i);
                messageCount++;
            }
        }
    }

    static void showStatus() {
        System.out.print("Status: ");
        for (int i = 0; i < n; i++) {
            System.out.print("P" + i + (alive[i] ? "(UP)  " : "(DOWN)  "));
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter total number of processes: ");
        n = sc.nextInt();

        alive = new boolean[n];
        Arrays.fill(alive, true);

        int choice;

        System.out.println("\n========= MENU =========");
        System.out.println("1. UP a process");
        System.out.println("2. DOWN a process");
        System.out.println("3. ELECT leader (Demonstrates Complexity)");
        System.out.println("4. SHOW STATUS");
        System.out.println("5. EXIT");

        do {
            System.out.print("\nEnter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Process to UP (0-" + (n - 1) + "): ");
                    alive[sc.nextInt()] = true;
                    break;

                case 2:
                    System.out.print("Process to DOWN (0-" + (n - 1) + "): ");
                    alive[sc.nextInt()] = false;
                    break;

                case 3:
                    System.out.print("Start election from process (0-" + (n - 1) + "): ");
                    int p = sc.nextInt();

                    if (!alive[p]) {
                        System.out.println("This Process is DOWN.");
                    } else {
                        messageCount = 0; // Reset counter before election
                        
                        long startTime = System.nanoTime(); // Start tracking time
                        
                        election(p);
                        
                        long endTime = System.nanoTime(); // End tracking time
                        
                        // Print the demonstrated complexity
                        System.out.println("\n--- COMPLEXITY DEMONSTRATION ---");
                        System.out.println("Total Messages Exchanged: " + messageCount);
                        System.out.println("Time taken (Nanoseconds): " + (endTime - startTime));
                    }
                    break;

                case 4:
                    showStatus();
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 5);
        
        sc.close();
    }
}