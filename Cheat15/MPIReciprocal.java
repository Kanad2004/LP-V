import mpi.*;

public class MPIReciprocal{
    public static void main(String[] args) throws Exception {
        MPI.Init(args);

        int rank = MPI.COMM_WORLD.Rank();
        int size = MPI.COMM_WORLD.Size();

        int elementProcess = 1;
        int root = 0;

        double sendBuffer[] = new double[size];


        if(rank == root){
            System.out.println("Root (Processor " + rank + ") initializing array of size " + size + "...");
            System.out.print("Original Array: [ ");
            for (int i = 0; i < size; i++) {
                // We use i + 1 to avoid dividing by zero! (e.g., 1.0, 2.0, 3.0...)
                sendBuffer[i] = (double) (i + 1); 
                System.out.print(sendBuffer[i] + " ");
            }
            System.out.println("]\n");
        }


        double receiveBuffer[] = new double[elementProcess];

        MPI.COMM_WORLD.Scatter(sendBuffer , 0 , elementProcess , MPI.DOUBLE , receiveBuffer , 0 , elementProcess , MPI.DOUBLE , root);


        double receivedNumber = receiveBuffer[0];
        double reciprocal = 1.0 / receivedNumber;

        System.out.println("Processor " + rank + " received " + receivedNumber + " -> calculated reciprocal: " + reciprocal);

        double localResultArray[] = new double[1];
        localResultArray[0] = reciprocal;

        double gatherBuffer[] = new double[size];

        MPI.COMM_WORLD.Gather(localResultArray , 0 , elementProcess , MPI.DOUBLE , gatherBuffer , 0 , elementProcess, MPI.DOUBLE , root);

        if(rank == root){
            System.out.println("\nGathering complete.");
            System.out.print("Root (Processor " + rank + ") Final Resultant Array (Reciprocals): [ ");
            for (int i = 0; i < size; i++) {
                // Formatting to 3 decimal places for cleaner output
                System.out.printf("%.3f ", gatherBuffer[i]);
            }
            System.out.println("]");
        }

        MPI.Finalize();
    }
}