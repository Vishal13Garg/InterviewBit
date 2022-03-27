package Heap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class NMaxPairCombinations {

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 4, 2, 3));
        ArrayList<Integer> B = new ArrayList<>(Arrays.asList(2, 5, 1, 6));

        ArrayList<Integer> result = solve(A, B);
        System.out.println(result);
    }

    public static ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        if(A == null || B == null || A.size() == 0)
            return new ArrayList<>();

        int N = A.size();

        PriorityQueue<Index> queue = new PriorityQueue<>();
        ArrayList<Integer>  sorted = new ArrayList<>(N);

        Collections.sort(B, Collections.reverseOrder());

        for (int i=0; i<A.size(); i++)
            queue.add(new Index(i,0,A.get(i)+B.get(0)));

        while (!queue.isEmpty() && sorted.size() < N){
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
