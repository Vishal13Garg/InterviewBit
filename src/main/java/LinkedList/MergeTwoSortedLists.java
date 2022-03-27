package LinkedList;

import LinkedList.common.ListNode;
import LinkedList.common.ListUtil;

public class MergeTwoSortedLists {

    public static void main(String[] args) {
        ListNode list1 = ListUtil.CreateList(new Integer[]{1, 2, 4, 6, 8, 10});
        ListUtil.PrintList(list1);

        ListNode list2 = ListUtil.CreateList(new Integer[]{100, 115, 152});
        ListUtil.PrintList(list2);

        ListNode mergedList = mergeTwoLists(list1, list2);
        ListUtil.PrintList(mergedList);
    }


    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null)
            return list2;

        if(list2 == null)
            return list1;

        ListNode head = null;
        ListNode current = null;

        while (list1 != null && list2 != null){
            ListNode nextNode = null;

            if(list1.val <= list2.val){
                nextNode = list1;
                list1 = list1.next;
            }
            else {
                nextNode = list2;
                list2 = list2.next;
            }

            if(head == null)
                head = current = nextNode;
            else {
                nextNode.next = null;
                current.next = nextNode;
                current = current.next;
            }
        }

        if(list1 != null)
            current.next = list1;

        if(list2 != null)
            current.next = list2;

        return head;
    }
}
