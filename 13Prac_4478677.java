// Miguel Wentzel
//4478677
//Practical 3
import java.lang.Math.*;   import java.io.*;   import java.text.*;
import java.util.*;

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
    public static void main(String args[])throws Exception{
        loadFile("ulysses.numbered");

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

        double binaryAve = binaryTime / repetitions;
        double binarystd = Math.sqrt((binaryTimesq-repetitions*binaryAve*linearstd)/(repetitions-1));
            

   

        System.out.printf("\n\n\fStatistics\n");
        System.out.println("________________________________________________");

        System.out.println("Linear Search Average Time =           " + fiveD.format(linearAve)
                + "s. " + '\u00B1' + " " + fourD.format(stdDeviation) + "ms.");
        System.out.println("Linear Search Standard Deviation =     " + fourD.format(linearstd));
        System.out.println("n            =           " + n);
        System.out.println("Binary Search Average Time =     " + fiveD.format(binaryAve));
        System.out.println("Binary Search Standard Deviation =     " + fourD.format(binarystd));

        System.out.println("Repetitions  =             " + repetitions);
        System.out.println("________________________________________________");
        System.out.println();
        System.out.println();
         }	
    static void loadFile(String filename) throws Exception{
        BufferedReader br = new BufferedReader(new FileReader(filename));
        Arraylist<Node> list = new Arraylist<>();

        String line;

        while ((line= br.readline())!= null){
            if (line.trim().length()==0) continue;

            String keyString = line.substring(0, 5).trim();
            int key = Integer.parseInt(keyString);
            String data = line.substring(5).trim();

            list.add(new Node(key, data));
        }
        br.close();
        N = list.size();
        array = list.toArray(new Node[N]);

    }
    static node binaryAve(int key){
        int low = 0;
        int high = N - 1;

        while (low<= high){
            int mid = (low + high)/2;
            if (array[mid].key == key){
                return array[mid];
            }
            if (array[mid].key < key){
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
    }
}



