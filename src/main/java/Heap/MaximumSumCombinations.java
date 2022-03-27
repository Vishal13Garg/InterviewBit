package Heap;

import java.util.*;

public class MaximumSumCombinations {

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(3, 2));
        ArrayList<Integer> B = new ArrayList<>(Arrays.asList(1, 4));

        System.out.println(solve(A, B, 2));
    }

    public static ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B, int C) {
        PriorityQueue<Index> queue = new PriorityQueue<>();
        ArrayList<Integer>  sorted = new ArrayList<>();

        Collections.sort(B, Collections.reverseOrder());

        for (int i=0; i<A.size(); i++)
            queue.add(new Index(i,0,A.get(i)+B.get(0)));

        while (!queue.isEmpty() && sorted.size() < C){
            Index maxElement = queue.poll();
            sorted.add(maxElement.value);

            if(maxElement.indexB+1 < B.size()){
                Index nextB = new Index(maxElement.indexA, maxElement.indexB+1, A.get(maxElement.indexA)+ B.get(maxElement.indexB+1));
                queue.add(nextB);
            }
        }

        return sorted;
    }

    static class Index implements Comparable<Index>{
        private int indexA;
        private int indexB;
        private int value;

        Index(int indexA, int indexB, int value){
            this.indexA = indexA;
            this.indexB = indexB;
            this.value = value;
        }

        @Override
        public int compareTo(Index index){
            return index.value-value;
        }
    }
}
