package LinkedList;

import LinkedList.common.ListNode;
import LinkedList.common.ListUtil;

public class RemoveDuplicatesFromSortedList {

    public static void main(String[] args) {
        ListNode list = ListUtil.CreateList(new Integer[]{0, 0, 0, 4, 4, 12, 110});
        ListUtil.PrintList(list);

        list = deleteDuplicates(list);
        ListUtil.PrintList(list);
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null)
            return head;

        ListNode current = head;
        while (current != null && current.next != null){
            if(current.val == current.next.val){
                current.next = current.next.next;
            }
            else {
                current = current.next;
            }
        }

        return head;
    }
}
