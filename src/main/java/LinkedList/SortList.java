package LinkedList;

import LinkedList.common.ListNode;
import LinkedList.common.ListUtil;

public class SortList {

    public static void main(String[] args) {
        ListNode list = ListUtil.CreateList(new Integer[]{1, 12, 13, 11, 111, 23});
        ListUtil.PrintList(list);

        list = sortList(list);
        ListUtil.PrintList(list);
    }

    public static ListNode sortList(ListNode head) {
        if(head == null || head.next == null)
            return head;

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode firstListHead = head;
        ListNode secondListHead = slow.next;
        slow.next = null;

        firstListHead = sortList(firstListHead);
        secondListHead = sortList(secondListHead);

        ListNode mergedList = mergeSorted(firstListHead, secondListHead);
        return mergedList;
    }

    private static ListNode mergeSorted(ListNode list1, ListNode list2){
        if(list1 == null)
            return list2;

        if(list2 == null)
            return list1;

        ListNode mergedListHead = null;
        ListNode mergedListTail = null;

        while (list1 != null && list2 != null){
            ListNode nodeToAdd = null;
            if(list1.val < list2.val){
                nodeToAdd = list1;
                list1 = list1.next;
            }
            else {
                nodeToAdd = list2;
                list2 = list2.next;
            }

            if(mergedListHead == null)
                mergedListHead = mergedListTail = nodeToAdd;
            else {
                mergedListTail.next = nodeToAdd;
                mergedListTail = mergedListTail.next;
            }
        }

        if(list1 != null)
            mergedListTail.next = list1;

        if(list2 != null)
            mergedListTail.next = list2;

        return mergedListHead;
    }
}
