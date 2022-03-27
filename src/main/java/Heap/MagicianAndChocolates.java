package Heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MagicianAndChocolates {

    public static void main(String[] args) {
        System.out.println(nchoc(5, new ArrayList<>(Arrays.asList(2, 4, 6, 8, 10))));
    }

    public static int nchoc(int A, ArrayList<Integer> B) {
        int result = 0;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });

        for (int i=0; i<B.size(); i++)
            priorityQueue.add(B.get(i));

        for (int i=0; i<A && priorityQueue.size() > 0; i++){
            int maxValue = priorityQueue.poll();
            if(maxValue/2 > 0)
                priorityQueue.add(maxValue/2);

            result = (result+maxValue)%1000000007;
        }

        return result;
    }
}
