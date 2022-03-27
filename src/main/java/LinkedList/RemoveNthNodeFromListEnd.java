package LinkedList;

import LinkedList.common.ListNode;
import LinkedList.common.ListUtil;

public class RemoveNthNodeFromListEnd {

    public static void main(String[] args) {
        ListNode list = ListUtil.CreateList(new Integer[]{1, 3, 2, 1, 66, 2, 6});
        ListUtil.PrintList(list);

        list = removeNthFromEnd(list, 17);
        ListUtil.PrintList(list);
    }


    public static ListNode removeNthFromEnd(ListNode head, int k) {
        if(head == null || k <= 0)
            return head;

        ListNode pointerTwo = head;
        for(int i=1; i<k; i++){
            if(pointerTwo.next != null)
                pointerTwo = pointerTwo.next;
        }

        ListNode pointerOne = null;
        while (pointerTwo.next != null){
            pointerOne = pointerOne == null ? head : pointerOne.next;
            pointerTwo = pointerTwo.next;
        }

        if(pointerOne == null)
            return head.next;
        else{
            pointerOne.next = pointerOne.next.next;
        }
        return head;
    }
}
