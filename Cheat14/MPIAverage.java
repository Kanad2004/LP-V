import java.util.Random;

import mpi.*;

public class MPIAverage{
    public static void main(String[] args)  throws Exception{
        MPI.Init(args);

        int rank = MPI.COMM_WORLD.Rank();
        int size = MPI.COMM_WORLD.Size();

        int elementsPerProcess = 5;
        int totalElements = elementsPerProcess * size;
        int root = 0;

        double sendBuffer[] = new double[totalElements];

        if(rank == root){
            System.out.println("Root (Processor " + rank + ") generating " + totalElements + " random numbers...");
            Random rand = new Random();

            System.out.println("Original Array : [ ");

            for(int i = 0 ; i < totalElements ; i++){
                sendBuffer[i] = rand.nextInt(100);
                System.out.println(sendBuffer[i] + " ");
            }

            System.out.println(" ]\n");
        }

        double receiveBuffer[] = new double[elementsPerProcess];

        MPI.COMM_WORLD.Scatter(sendBuffer , 0 , elementsPerProcess , MPI.DOUBLE , receiveBuffer , 0 , elementsPerProcess , MPI.DOUBLE , root);

        double localSum = 0;

        for(int i = 0 ; i < elementsPerProcess ; i++){
            localSum += receiveBuffer[i];
        }

        double localAverage = localSum / elementsPerProcess;
        System.out.println("Processor " + rank + " calculated average : " + localAverage);

        double localAvergeArr[] = new double[1];
        localAvergeArr[0] = localAverage;

        double gatherBuffer[] = new double[size];

        MPI.COMM_WORLD.Gather(localAvergeArr , 0 , 1 , MPI.DOUBLE , gatherBuffer , 0 , 1 , MPI.DOUBLE , root);


        if(root == rank){
            System.out.println("Gathering complete");
            double totalSum = 0;
            for(int i = 0 ; i < size ; i++){
                totalSum += gatherBuffer[i];
            }

            double finalAverage = totalSum / size;
            System.out.println("Root (Processor " + rank + ") calculated Final Overall Average: " + finalAverage);
        }

        MPI.Finalize();
    }
}