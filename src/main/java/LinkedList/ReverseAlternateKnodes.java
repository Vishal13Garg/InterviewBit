package LinkedList;

import LinkedList.common.ListNode;
import LinkedList.common.ListUtil;

public class ReverseAlternateKnodes {

    public static void main(String[] args) {
        ListNode list = ListUtil.CreateList(new Integer[]{3, 4, 7, 5, 6, 9, 10, 11});
        ListUtil.PrintList(list);

        list = solve(list, 3);
        ListUtil.PrintList(list);
    }


    public static ListNode solve(ListNode head, int k) {
        if(head == null || head.next == null || k==1)
            return head;

        ListNode reversedListHead = null;
        ListNode reversedListTail = null;

        ListNode current = head;
        while (current != null){
            ListNode startNode = current;
            for (int i=1; i<k && current != null; i++)
                current = current.next;

            ListNode next = current != null ? current.next : null;
            if(current!= null)
                current.next = null;


            ListNode reversed = reverse(startNode);
            if(reversedListHead == null)
                reversedListHead = reversedListTail = reversed;
            else
                reversedListTail.next = reversed;

            while (reversedListTail.next != null)
                reversedListTail = reversedListTail.next;

            reversedListTail.next = next;
            for (int i=0; i<k && next != null; i++){
                next = next.next;
                reversedListTail = reversedListTail.next;
            }
            current = next;
        }

        return reversedListHead;
    }

    private static ListNode reverse(ListNode head){
        if(head == null || head.next == null)
            return head;

        ListNode pre = null;
        ListNode current = head;

        while (current != null){
            ListNode next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }
        return pre;
    }
}
