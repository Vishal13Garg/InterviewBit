package Heap;

import java.util.*;

public class FindRightInterval {

    public static void main(String[] args) {
        int[][] arr = new int[][]{{3,4},{2,3},{1,2}};
        int[] rightInterval = findRightInterval(arr);

        for (int i=0; i<rightInterval.length; i++)
            System.out.print(rightInterval[i] + " ");
    }

    public static int[] findRightInterval(int[][] intervals) {
        int[] rightInterval = new int[intervals.length];

        List<Interval> list = new ArrayList<>(intervals.length);
        PriorityQueue<Interval> queue = new PriorityQueue<>(new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });

        for (int i=0; i<intervals.length; i++){
            Interval interval = new Interval(i, intervals[i][0], intervals[i][1]);
            list.add(interval);
            queue.add(interval);
        }

        Collections.sort(list, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.end - o2.end;
            }
        });

        for (int i=0; i<list.size(); i++){
            while (!queue.isEmpty() && queue.peek().start < list.get(i).end)
                queue.poll();

            if(!queue.isEmpty())
                rightInterval[list.get(i).index] = queue.peek().index;
            else
                rightInterval[list.get(i).index] = -1;

        }
        return rightInterval;
    }

    static class Interval{
        private int start;
        private int end;
        private int index;

        Interval(int index, int start, int end){
            this.index = index;
            this.start = start;
            this.end = end;
        }

    }
}
