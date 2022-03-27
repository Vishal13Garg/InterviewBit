package LinkedList;

import LinkedList.common.ListNode;
import LinkedList.common.ListUtil;

public class EvenReverse {
    public static void main(String[] args) {
        ListNode list = ListUtil.CreateList(new Integer[]{1, 2, 3, 4, 5, 6});
        ListUtil.PrintList(list);

        list = solve(list);
        ListUtil.PrintList(list);
    }

    public static ListNode solve(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode oddHead = head;
        ListNode oddTail = head;

        ListNode evenHead = head.next;
        ListNode evenTail = head.next;

        ListNode current = head.next.next;
        while (current != null){
            oddTail.next = current;
            oddTail = oddTail.next;
            current = current.next;

            if(current != null){
                evenTail.next = current;
                evenTail = evenTail.next;
                current = current.next;
            }
        }

        oddTail.next = null;
        evenTail.next = null;

        evenHead = reverse(evenHead);

        ListNode oddCurrent = oddHead;
        ListNode evenCurrent = evenHead;

        while (oddCurrent != null && evenCurrent != null){
            ListNode next = oddCurrent.next;
            oddCurrent.next = evenCurrent;
            oddCurrent = oddCurrent.next;

            evenCurrent = evenCurrent.next;
            oddCurrent.next = next;
            oddCurrent = next;
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
