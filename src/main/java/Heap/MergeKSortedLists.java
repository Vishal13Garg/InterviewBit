package Heap;

import LinkedList.common.ListNode;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedLists {
    public ListNode mergeKLists(ArrayList<ListNode> inputList) {
        if(inputList == null || inputList.size() == 0)
            return null;

        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val -o2.val;
            }
        });

        for (int i=0; i<inputList.size(); i++)
            queue.add(inputList.get(i));

        ListNode current = null;
        ListNode head = null;

        while (!queue.isEmpty()){
            ListNode minNode = queue.poll();
            ListNode nextNode = minNode.next;

            if(nextNode != null)
                queue.add(nextNode);

            if(current == null)
                current = head = minNode;
            else{
                current.next = minNode;
                current = current.next;
            }

        }

        return head;
    }

    class ListNode {
      public int val;
      public ListNode next;
      ListNode(int x) { val = x; next = null; }
  }
}
