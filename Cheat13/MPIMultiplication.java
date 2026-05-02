import mpi.*;

public class MPIMultiplication{
    public static void main(String[] args) throws Exception {
        MPI.Init(args);

        int rank = MPI.COMM_WORLD.Rank();
        int size = MPI.COMM_WORLD.Size();

        int unitsize = 4;
        int root = 0;

        int total_elements = unitsize * size;

        int send_buffer[] = new int[total_elements];

        if(rank == root){
            System.out.println("Root (Processor " + rank + ") initiliazing array of size " + total_elements + "...");
            for(int i = 0 ; i < total_elements ; i++){
                send_buffer[i] = (i % 3) + 1;
            }
        }

        int receive_buffer[] = new int[unitsize];
        
        MPI.COMM_WORLD.Scatter(send_buffer , 0 , unitsize , MPI.INT , receive_buffer , 0 , unitsize , MPI.INT , root);


        int local_prod = 1;
        for(int i = 0 ; i < unitsize ; i++){
            local_prod *= receive_buffer[i];
        }

        System.out.println("Processor " + rank + " calculated intermediate multiplication " + local_prod);

        int local_prod_arr[] = new int[2];
        local_prod_arr[0] = local_prod;
        int final_prod[] = new int[2];

        MPI.COMM_WORLD.Reduce(local_prod_arr , 0 , final_prod , 0 , 1 , MPI.INT ,MPI.PROD , root);

        if(rank == root){
            System.out.println("Root (Processor " + rank + ") calculated final prod : " + final_prod[0]);
        }

        MPI.Finalize();
    }
}