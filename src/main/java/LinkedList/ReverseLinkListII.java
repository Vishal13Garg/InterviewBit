package LinkedList;

import LinkedList.common.ListNode;
import LinkedList.common.ListUtil;

public class ReverseLinkListII {
    public static void main(String[] args) {
        ListNode list = ListUtil.CreateList(new Integer[]{1, 2, 3, 4,});
        ListUtil.PrintList(list);

        list = reverseBetween(list, 1, 4);
        ListUtil.PrintList(list);
    }


    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null || head.next == null)
            return head;

        ListNode reversedListHead = null;
        ListNode reversedListTail = null;

        ListNode current = head;
        int index = 1;

        for (; index<m; index++){
            if(reversedListHead == null)
                reversedListHead = reversedListTail = current;
            else
                reversedListTail = reversedListTail.next;

            current = current.next;
        }

        ListNode pre = null;
        ListNode next = null;
        ListNode innerTail = current;

        for (; index <= n; index++){
            next = current.next;
            current.next = pre;

            pre = current;
            current = next;
        }

        if(reversedListHead == null)
            reversedListHead = reversedListTail = pre;
        else
            reversedListTail.next = pre;

        innerTail.next = current;

        return reversedListHead;
    }
}
