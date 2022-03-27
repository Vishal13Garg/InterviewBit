package LinkedList;

import LinkedList.common.ListNode;
import LinkedList.common.ListUtil;

public class SwapListNodesInPairs {

    public static void main(String[] args) {
        ListNode list = ListUtil.CreateList(new Integer[]{1, 2, 3, 4, 5});
        ListUtil.PrintList(list);

        list = swapPairs(list);
        ListUtil.PrintList(list);
    }

    public static ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null)
            return head;

        ListNode newHead = head.next;

        ListNode pre = null;
        ListNode current = head;
        while (current != null && current.next != null){
            ListNode nextNextNode = current.next.next;
            ListNode next = current.next;

            next.next = current;
            current.next = nextNextNode;

            if(pre != null)
                pre.next = next;

            pre = current;
            current = nextNextNode;
        }

        return newHead;
    }
}
