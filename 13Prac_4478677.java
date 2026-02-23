// Miguel Wentzel
//4478677
//Practical 3
import java.lang.Math.*;   import java.io.*;   import java.text.*;

public class timeMethods{
    public static int N;
    static class Node{
        int key;
        String data;
        Node(int key, String data){
            this.key = key;
            this.data = data;
        }
    }
    public static void main(String args[]){
        loadfile("ulysses.numbered");

        DecimalFormat twoD = new DecimalFormat("0.00");
        DecimalFormat fourD = new DecimalFormat("0.0000");
        DecimalFormat fiveD = new DecimalFormat("0.00000");

        int repetitions = 30;
        Random rand = new Random;
        double linearTime = 0;
        double linearTimesq = 0;
        double binaryTime = 0;
        double binaryTimesq = 0;


        



        runTime = 0;
        for(int i = 0; i < repetitions; repetition++) {
            int randomkey = rand.nextInt(32654)+1;

            long start = System.nanoTime();
            LinearSearch(randomkey);
            long finish = System.nanoTime();
            double time = (finish-start) / 1_000_000.0;
            linearTime += time;
            linearTimesq += time*time;

            //Binary
            start = System.nanoTime();
            binarySearch(randomkey);
            finish = System.nanoTime();
            time = (finish - start)/ 1_000_000.0;
            binaryTime += time;
            binaryTimesq = time * time;
        }
        double linearAve = linearTime / repetitions;
        double linearstd = Math.sqrt((linearTimesq-repetitions*linearAve*linearstd)/(repetitions-1));

        
            

   

        System.out.printf("\n\n\fStatistics\n");
        System.out.println("________________________________________________");
        System.out.println("Total time   =           " + runTime/1000 + "s.");
        System.out.println("Total time\u00b2  =           " + runTime2);
        System.out.println("Average time =           " + fiveD.format(aveRuntime/1000)
                + "s. " + '\u00B1' + " " + fourD.format(stdDeviation) + "ms.");
        System.out.println("Standard deviation =     " + fourD.format(stdDeviation));
        System.out.println("n            =           " + n);
        System.out.println("Average time / run =     " + fiveD.format(aveRuntime/n*1000)
                + '\u00B5' + "s. ");

        System.out.println("Repetitions  =             " + repetitions);
        System.out.println("________________________________________________");
        System.out.println();
        System.out.println(); }	}

    static void oneofyourMethods(int n,
                                 yourMethodParameter1,
                                 yourMethodParameter2, . . . ) {
    // The declarations and body of your method / s
    // The final statement of this code.} 
    }
}
