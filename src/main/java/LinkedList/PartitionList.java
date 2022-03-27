package LinkedList;

import LinkedList.common.ListNode;
import LinkedList.common.ListUtil;

public class PartitionList {
    public static void main(String[] args) {
        ListNode list = ListUtil.CreateList(new Integer[]{1, 0, 0, 4, 0, 2, 0});
        ListUtil.PrintList(list);

        list = partition(list, 2);
        ListUtil.PrintList(list);
    }


    public static ListNode partition(ListNode head, int value) {
        if(head == null || head.next == null)
            return head;

        ListNode smallerHead = null;
        ListNode smallerTail = null;

        ListNode nonSmallHead = null;
        ListNode nonSmallTail = null;

        ListNode current = head;

        while (current != null){
            if(current.val < value){
                if(smallerTail == null){
                    smallerHead = smallerTail = current;
                }
                else {
                    smallerTail.next = current;
                    smallerTail = smallerTail.next;
                }
            }
            else {
                if(nonSmallTail == null){
                    nonSmallHead = nonSmallTail = current;
                }
                else {
                    nonSmallTail.next = current;
                    nonSmallTail = nonSmallTail.next;
                }
            }
            current = current.next;
        }

        if(nonSmallTail != null)
            nonSmallTail.next = null;

        if(smallerHead == null)
            return nonSmallHead;
        else {
            smallerTail.next = nonSmallHead;
            return smallerHead;
        }
    }
}
