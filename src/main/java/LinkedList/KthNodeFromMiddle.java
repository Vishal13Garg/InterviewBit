package LinkedList;

import LinkedList.common.ListNode;
import LinkedList.common.ListUtil;

public class KthNodeFromMiddle {

    public static void main(String[] args) {
        ListNode list = ListUtil.CreateList(new Integer[]{3, 4, 7, 5, 6, 9});
        ListUtil.PrintList(list);

        System.out.println(solve(list, 2));
    }

    public static int solve(ListNode head, int k) {
        if(head == null)
            return -1;

        //Remove the second half from the list
        head = partitionListFromMiddle(head);

        ListNode pointerOne = head;
        for (int i=0; i<=k; i++){
            if(pointerOne == null)
                return -1;
            pointerOne = pointerOne.next;
        }

        ListNode pointerTwo = head;
        while (pointerOne != null){
            pointerOne = pointerOne.next;
            pointerTwo = pointerTwo.next;
        }

        return pointerTwo.val;
    }

    private static ListNode partitionListFromMiddle(ListNode head){
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        slow.next = null;
        return head;
    }
}
