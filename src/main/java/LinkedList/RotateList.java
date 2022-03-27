package LinkedList;

import LinkedList.common.ListNode;
import LinkedList.common.ListUtil;

public class RotateList {
    public static void main(String[] args) {
        ListNode list = ListUtil.CreateList(new Integer[]{1, 2, 3, 4, 5});
        ListUtil.PrintList(list);

        list = rotateRight(list, 5);
        ListUtil.PrintList(list);
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k ==0 )
            return head;

        ListNode current = head;
        int length = 0;

        while (current != null){
            current = current.next;
            length++;
        }

        k = k%length;
        k = length-k;

        if(k == 0 || k == length)
            return head;

        current = head;
        for (int i=1; i<k; i++)
            current = current.next;

        ListNode newHead = current.next;
        current.next = null;

        current = newHead;
        while (current.next != null)
            current = current.next;

        current.next = head;
        return newHead;
    }
}
