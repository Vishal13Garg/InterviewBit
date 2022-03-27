package Heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class FindMedianFromDataStream {

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        System.out.println(medianFinder.findMedian());
    }

    static class MedianFinder {
        PriorityQueue<Integer> maxHeap;
        PriorityQueue<Integer> minHeap;

        public MedianFinder() {
            maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2-o1;
                }
            });

            minHeap = new PriorityQueue<>();
        }

        public void addNum(int num) {
            if(!minHeap.isEmpty() && minHeap.peek() < num)
                minHeap.add(num);
            else
                maxHeap.add(num);

            if(minHeap.size() > maxHeap.size())
                maxHeap.add(minHeap.poll());
            if(maxHeap.size() > minHeap.size()+1)
                minHeap.add(maxHeap.poll());
        }

        public double findMedian() {
            if(maxHeap.size() == 0 && minHeap.size() == 0)
                return 0;

            if(maxHeap.size() > minHeap.size())
                return maxHeap.peek();
            else {
                return (maxHeap.peek() + minHeap.peek())/2.0;
            }
        }
    }
}
