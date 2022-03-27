package LinkedList;

import LinkedList.common.ListNode;
import LinkedList.common.ListUtil;

public class SortBinaryLinkedList {

    public static void main(String[] args) {
        ListNode list = ListUtil.CreateList(new Integer[]{1, 0, 0, 1, 0, 1, 0});
        ListUtil.PrintList(list);

        list = solve(list);
        ListUtil.PrintList(list);
    }


    public static ListNode solve(ListNode head) {
        if(head == null || head.next == null )
            return head;

        ListNode zeroHead = null;
        ListNode zeroTail = null;

        ListNode oneHead = null;
        ListNode oneTail = null;

        ListNode current = head;
        while (current != null){
            if(current.val == 0){
                if(zeroHead == null)
                    zeroHead = zeroTail = current;
                else {
                    zeroTail.next = current;
                    zeroTail = zeroTail.next;
                }
            }
            else {
                if(oneHead == null)
                    oneHead = oneTail = current;
                else {
                    oneTail.next = current;
                    oneTail = oneTail.next;
                }
            }

            current = current.next;
        }

        if(oneTail != null){
            oneTail.next = null;
        }

        if(zeroHead == null){
            return oneHead;
        }
        else {
            zeroTail.next = oneHead;
            return zeroHead;
        }
    }
}
