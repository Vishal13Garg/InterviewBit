package Heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class MergeKSortedArrays {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> input = new ArrayList<>();
        input.add(new ArrayList<>(Arrays.asList(1, 2, 3)));
        input.add(new ArrayList<>(Arrays.asList(2, 4, 6)));
        input.add(new ArrayList<>(Arrays.asList(0, 9, 10)));

        ArrayList<Integer> sorted = solve(input);
        System.out.println(sorted);
    }

    public static ArrayList<Integer> solve(ArrayList<ArrayList<Integer>> A) {
        ArrayList<Integer> sortedArray = new ArrayList<>();
        PriorityQueue<Index> queue = new PriorityQueue<>();

        for (int i=0; i<A.size(); i++){
            queue.add(new Index(A.get(i).get(0), i, 0));
        }

        while (queue.size() > 0){
            Index current = queue.poll();
            sortedArray.add(current.value);

            if(current.arrayIndex + 1 < A.get(current.array).size())
                queue.add(new Index(A.get(current.array).get(current.arrayIndex+1), current.array, current.arrayIndex+1));

        }

        return sortedArray;
    }

    public static class Index implements Comparable<Index>{
        private int value;
        private int array;
        private int arrayIndex;

        public Index(int value, int array, int arrayIndex){
            this.value = value;
            this.array = array;
            this.arrayIndex = arrayIndex;
        }

        @Override
        public int compareTo(Index i1){
            return value - i1.value;
        }

    }
}
