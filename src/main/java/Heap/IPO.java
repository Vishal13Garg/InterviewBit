package Heap;

import java.util.*;

public class IPO {

    public static void main(String[] args) {
        System.out.println(findMaximizedCapital(3, 0, new int[]{1,2,3}, new int[]{0,1,1}));
    }

    public static int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        List<Project> list = new ArrayList<>();
        for(int i=0; i<profits.length; i++)
            list.add(new Project(capital[i], profits[i]));

        Collections.sort(list, new Comparator<Project>() {
            @Override
            public int compare(Project o1, Project o2) {
                return o1.capital - o2.capital;
            }
        });

        PriorityQueue<Project> queue = new PriorityQueue<>(new Comparator<Project>() {
            @Override
            public int compare(Project o1, Project o2) {
                return o2.profit - o1.profit;
            }
        });

       int index = 0;
       while (index < capital.length && list.get(index).capital <= w){
           queue.add(list.get(index));
           index++;
       }

       for (int i=0; i<k && !queue.isEmpty(); i++){
           Project current = queue.poll();
           w += current.profit;

           while (index < capital.length && list.get(index).capital <= w){
               queue.add(list.get(index));
               index++;
           }
       }

       return w;
    }

    static class Project{
        private int capital;
        private int profit;

        Project(int capital, int profit){
            this.capital = capital;
            this.profit = profit;
        }
    }
}
