package LinkedList;

import LinkedList.common.ListNode;
import LinkedList.common.ListUtil;

public class PalindromeList {

    public static void main(String[] args) {
        ListNode list = ListUtil.CreateList(new Integer[]{1, 3, 2, 3, 1});
        ListUtil.PrintList(list);
        System.out.println(lPalin(list));
    }

    public static int lPalin(ListNode head) {
        if(head == null || head.next == null)
            return 1;

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode head2 = slow.next;
        slow.next = null;

        head2 = reverse(head2);

        while (head != null && head2 != null){
            if(head.val != head2.val)
                return 0;
            head = head.next;
            head2 = head2.next;
        }

        return 1;
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
