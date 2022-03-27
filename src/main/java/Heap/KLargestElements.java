package Heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class KLargestElements {

    public static void main(String[] args) {
        System.out.println(solve(new ArrayList<>(Arrays.asList(11, 3, 4, 6)), 3));
    }

    public static ArrayList<Integer> solve(ArrayList<Integer> A, int B) {
        if(A == null || A.size() == 0)
            return new ArrayList<>();

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i=0; i<A.size(); i++){
            if(queue.size() <B){
                queue.add(A.get(i));
            }
            else {
                if(queue.peek() < A.get(i)){
                    queue.poll();
                    queue.add(A.get(i));
                }
            }
        }

        ArrayList<Integer> arrayList = new ArrayList<>();
        for(int i=0; i<B; i++)
            arrayList.add(queue.poll());

        return arrayList;
    }
}
