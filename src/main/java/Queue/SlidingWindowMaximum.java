package Queue;

import java.util.*;

public class SlidingWindowMaximum {

    public static void main(String[] args) {
        System.out.println(slidingMaximum(Arrays.asList(637, 446, 882, 760, 354, 523, 935, 277, 158, 698, 536, 165, 892, 327, 574, 516, 36, 705, 900, 482, 558, 937, 207, 368), 9));
    }

    public static ArrayList<Integer> slidingMaximum(final List<Integer> A, int B) {
        int windowLength = A.size() - B + 1;

        ArrayList<Integer> window = new ArrayList<>(windowLength);
        Deque<Integer> queue = new LinkedList<>();

        for(int i=0; i<B; i++){
            while (!queue.isEmpty() && A.get(queue.getLast()) < A.get(i))
                queue.removeLast();

            queue.add(i);
        }
        window.add(A.get(queue.getFirst()));

        for (int i=B; i<A.size(); i++){
            if(queue.getFirst() == i-B)
                queue.removeFirst();

            while (!queue.isEmpty() && A.get(queue.getLast()) < A.get(i))
                queue.removeLast();

            queue.add(i);
            window.add(A.get(queue.getFirst()));
        }

        return window;
    }
}
