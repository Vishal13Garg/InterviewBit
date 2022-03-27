package LinkedList;

import LinkedList.common.ListNode;
import LinkedList.common.ListUtil;

public class ReorderList {

    public static void main(String[] args) {
        ListNode list = ListUtil.CreateList(new Integer[]{1, 2, 3, 4, 5});
        ListUtil.PrintList(list);

        list = reorderList(list);
        ListUtil.PrintList(list);
    }


    public static ListNode reorderList(ListNode head) {
        if(head == null || head.next == null)
            return head;

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode secondHalf = slow.next;
        slow.next = null;

        secondHalf = reverse(secondHalf);

        ListNode firstHalfHead = head;
        ListNode secondHalfHEad = secondHalf;

        while (firstHalfHead != null && secondHalfHEad != null){
            ListNode firstHalfNext = firstHalfHead.next;
            ListNode secondHalfNext = secondHalfHEad.next;

            firstHalfHead.next = secondHalfHEad;
            secondHalfHEad.next = firstHalfNext;

            firstHalfHead = firstHalfNext;
            secondHalfHEad = secondHalfNext;
        }

        return head;
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
