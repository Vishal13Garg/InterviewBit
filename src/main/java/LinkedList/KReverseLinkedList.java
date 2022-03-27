package LinkedList;

import LinkedList.common.ListNode;
import LinkedList.common.ListUtil;

public class KReverseLinkedList {

    public static void main(String[] args) {
        ListNode list = ListUtil.CreateList(new Integer[]{1, 2, 3, 4, 5, 6});
        ListUtil.PrintList(list);

        list = reverseList(list, 4);
        ListUtil.PrintList(list);
    }

    public static ListNode reverseList(ListNode head, int k) {
        if(head == null || k <= 1)
            return head;

        ListNode reversedListHead = null;
        ListNode reversedListTail = null;

        ListNode current = head;
        while (current != null){
            ListNode currentHead = current;

            for(int i=1; i<k && current != null; i++){
                current = current.next;
            }

            ListNode next = current != null ? current.next : null;
            if(current != null)
                current.next = null;

            ListNode reversedList = reverse(currentHead);
            if(reversedListHead == null)
                reversedListHead = reversedListTail = reversedList;
            else
                reversedListTail.next = reversedList;

            while (reversedList.next != null)
                reversedList = reversedList.next;

            reversedListTail = reversedList;
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
