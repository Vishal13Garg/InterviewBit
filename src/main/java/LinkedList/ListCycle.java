package LinkedList;

import LinkedList.common.ListNode;

public class ListCycle {

    public static void main(String[] args) {
        ListNode nodeOne = new ListNode(1);
        ListNode nodeTwo = new ListNode(2);
        ListNode nodeThree = new ListNode(3);
        ListNode nodeFour = new ListNode(4);
        ListNode nodeFive = new ListNode(5);
        ListNode nodeSix = new ListNode(6);
        ListNode nodeSeven = new ListNode(7);

        nodeOne.next = nodeTwo;
        nodeTwo.next = nodeThree;
        nodeThree.next = nodeFour;
        nodeFour.next = nodeFive;
        nodeFive.next = nodeSix;
        nodeSix.next = nodeSeven;
        nodeSeven.next = nodeThree;

        ListNode loopStart = detectCycle(nodeOne);
        if(loopStart != null)
            System.out.println(loopStart.val);
    }

    public static ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null)
            return null;

        ListNode slow = head;
        ListNode fast = head.next;

        while(slow != fast){
            if(fast == null || fast.next == null)
                return null;

            slow = slow.next;
            fast = fast.next.next;
        }

        int loopLength = 1;
        ListNode innerLoopNode = slow.next;

        while (innerLoopNode != slow){
            innerLoopNode = innerLoopNode.next;
            loopLength++;
        }

        ListNode pointerOne = head;
        ListNode pointerTwo = head;

        for (int i=1; i<loopLength; i++)
            pointerTwo = pointerTwo.next;

        while (pointerTwo.next != pointerOne){
            pointerOne = pointerOne.next;
            pointerTwo = pointerTwo.next;
        }

        return pointerOne;
    }
}
