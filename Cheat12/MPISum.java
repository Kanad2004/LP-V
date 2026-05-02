import mpi.*;

public class MPISum {
    public static void main(String args[]) throws Exception {
        // Initialize the MPI execution environment
        MPI.Init(args);
        
        int rank = MPI.COMM_WORLD.Rank();
        int size = MPI.COMM_WORLD.Size();

        int unitsize = 5; 
        int root = 0;     

        // THE FIX: We must instantiate the array on ALL processors to prevent the NullPointerException
        int total_elements = unitsize * size;
        int send_buffer[] = new int[total_elements];

        // Only the Root Process fills the array with actual data
        if (rank == root) {
            System.out.println("Root (Processor " + rank + ") initializing array of size " + total_elements + "...");
            for (int i = 0; i < total_elements; i++) {
                send_buffer[i] = i + 1; 
            }
        }

        // Scatter the array to all processors
        int receive_buffer[] = new int[unitsize];
        MPI.COMM_WORLD.Scatter(send_buffer, 0, unitsize, MPI.INT,
                               receive_buffer, 0, unitsize, MPI.INT, root);

        // Worker Processes Calculate Intermediate Sums
        int local_sum = 0;
        for (int i = 0; i < unitsize; i++) {
            local_sum += receive_buffer[i];
        }
        System.out.println("Processor " + rank + " calculated intermediate sum: " + local_sum);

        // Prepare arrays for the Reduce operation
        int local_sum_arr[] = new int[1];
        local_sum_arr[0] = local_sum;
        int final_sum[] = new int[1];

        // Reduce: Gather all local_sums and ADD them together at the root
        MPI.COMM_WORLD.Reduce(local_sum_arr, 0, final_sum, 0, 1, MPI.INT, MPI.SUM, root);

        // Root Process prints the final result
        if (rank == root) {
            System.out.println("Root (Processor " + rank + ") calculated Final Total Sum: " + final_sum[0]);
        }

        // Clean up the MPI environment
        MPI.Finalize();
    }
}


