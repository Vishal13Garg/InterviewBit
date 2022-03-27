package LinkedList;

import LinkedList.common.ListNode;
import LinkedList.common.ListUtil;

public class InsertionSortList {

    public static void main(String[] args) {
        ListNode list = ListUtil.CreateList(new Integer[]{1, 12, 3, -4, 15});
        ListUtil.PrintList(list);

        list = insertionSortList(list);
        ListUtil.PrintList(list);
    }


    public static ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null)
            return head;

        ListNode sortedListHead = head;
        ListNode current = head.next;

        sortedListHead.next = null;
        while (current != null){
            ListNode next = current.next;
            current.next = null;

            sortedListHead = insertSorted(sortedListHead, current);
            current = next;
        }
        return sortedListHead;
    }

    private static ListNode insertSorted(ListNode head, ListNode nodeToInsert){
        if(head == null)
            return head;

        if(nodeToInsert.val < head.val){
            nodeToInsert.next = head;
            return nodeToInsert;
        }

        ListNode current = head;
        while (current.next != null && current.next.val < nodeToInsert.val)
            current = current.next;

        nodeToInsert.next = current.next;
        current.next = nodeToInsert;

        return head;
    }
}
