package LinkedList;

import LinkedList.common.ListNode;
import LinkedList.common.ListUtil;

public class RemoveDuplicatesFromSortedList2 {

    public static void main(String[] args) {
        ListNode list = ListUtil.CreateList(new Integer[]{0, 0, 0, 4, 4, 12, 12, 110, 110});
        ListUtil.PrintList(list);

        list = deleteDuplicates(list);
        ListUtil.PrintList(list);
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null)
            return head;

        ListNode current = head;
        ListNode distinctNodeListHead = null;
        ListNode distinctNodeListCurrent = null;

        while (current != null){
            if(current.next == null || current.val != current.next.val){
                if(distinctNodeListCurrent == null)
                    distinctNodeListCurrent = distinctNodeListHead = current;
                else {
                    distinctNodeListCurrent.next = current;
                    distinctNodeListCurrent = distinctNodeListCurrent.next;
                }
            }
            else {
                while (current.next != null && current.val == current.next.val)
                    current = current.next;
            }

            current = current.next;
        }

        if(distinctNodeListCurrent != null)
            distinctNodeListCurrent.next = null;

        return distinctNodeListHead;
    }
}
