package Heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class ProfitMaximisation {

    public static void main(String[] args) {
        System.out.println(solve(new ArrayList<>(Arrays.asList(1, 4)), 2));
    }

    public static int solve(ArrayList<Integer> A, int B) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2){
                return o2-o1;
            }
        });

        for (int i=0; i<A.size(); i++)
            queue.add(A.get(i));

        int maxProfit = 0;
        for (int i=0; i<B; i++){
            int currentRow = queue.poll();
            maxProfit += currentRow;
            currentRow--;

            if(currentRow > 0)
                queue.add(currentRow);
        }

        return maxProfit;
    }
}
