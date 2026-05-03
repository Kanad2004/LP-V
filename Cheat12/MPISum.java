import mpi.*;

public class MPISum{
    public static void main(String[] args) throws Exception {
        MPI.Init(args);

        int rank = MPI.COMM_WORLD.Rank();

        int size = MPI.COMM_WORLD.Size();

        int unitsize = 5;

        int root = 0;

        int total_elements = unitsize * size;

        int send_buffer[] = new int[total_elements];

        if(root == rank){
            System.out.println("Root (Processor " + rank + ") initializing array...");

            for(int i = 0 ; i < total_elements ; i++){
                send_buffer[i] = i + 1;
            }
        }

        int receive_buffer[] = new int[unitsize];

        MPI.COMM_WORLD.Scatter(send_buffer , 0 , unitsize , MPI.INT , 
            receive_buffer , 0 , unitsize , MPI.INT , 
            root
        );



        

        int local_sum = 0;

        for(int i = 0 ; i < unitsize ; i++){
            local_sum += receive_buffer[i];
        }

        System.out.println("Processor " + rank + " calculated intermediate sum: " + local_sum);

        int local_sum_arr[] = new int[1];
        local_sum_arr[0] = local_sum;

        int final_sum[] = new int[1];

        MPI.COMM_WORLD.Reduce(
            local_sum_arr,  0,
            final_sum , 0,
            1, MPI.INT,
            MPI.SUM,
            root
        );

        if(root == rank){
            System.out.println("Root (Processor " + rank + ") Final Total Sum: " + final_sum[0]);
        }

        MPI.Finalize();
    }
}