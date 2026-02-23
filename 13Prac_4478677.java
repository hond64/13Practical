// Miguel Wentzel
//4478677
//Practical 3

import java.lang.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.text.DecimalFormat;
import java.util.*;
import java.util.ArrayList;

public class timeMethods{
    public static int N;
    static Node[] array;
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
        Random rand = new Random();
        double linearTime = 0;
        double linearTimesq = 0;
        double binaryTime = 0;
        double binaryTimesq = 0;






       ;
        for(int i = 0; i < repetitions; i++) {
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
        double linearstd = Math.sqrt((linearTimesq-repetitions*linearAve*linearAve)/(repetitions-1));

        double binaryAve = binaryTime / repetitions;
        double binarystd = Math.sqrt((binaryTimesq-repetitions*binaryAve*binaryAve)/(repetitions-1));




        System.out.printf("\n\n\fStatistics\n");
        System.out.println("________________________________________________");

        System.out.println("Linear Search Average Time =           " + fiveD.format(linearAve));
        System.out.println("Linear Search Standard Deviation =     " + fourD.format(linearstd));
        System.out.println("n            =           " + N);
        System.out.println("Binary Search Average Time =     " + fiveD.format(binaryAve));
        System.out.println("Binary Search Standard Deviation =     " + fourD.format(binarystd));

        System.out.println("Repetitions  =             " + repetitions);
        System.out.println("________________________________________________");
        System.out.println();
        System.out.println();
    }
    static void loadFile(String filename) throws Exception{
        BufferedReader br = new BufferedReader(new FileReader(filename));
        ArrayList<Node> list = new ArrayList<>();

        String line;

        while ((line= br.readLine())!= null){
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
    static Node binarySearch(int key){
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
        return null;
    }
    static Node LinearSearch(int key){
        for (int i = 0; i < N;i++){
            if(array[i].key == key){
                return array[i];
            }

        }
        return null;
    }
} //Done



