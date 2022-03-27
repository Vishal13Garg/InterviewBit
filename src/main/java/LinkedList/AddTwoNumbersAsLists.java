package LinkedList;

import LinkedList.common.ListNode;
import LinkedList.common.ListUtil;

public class AddTwoNumbersAsLists {

    public static void main(String[] args) {
        ListNode list1 = ListUtil.CreateList(new Integer[]{1, 2, 3});
        ListUtil.PrintList(list1);

        ListNode list2 = ListUtil.CreateList(new Integer[]{1, 9, 9});
        ListUtil.PrintList(list2);

        ListNode result = addTwoNumbers(list1, list2);
        ListUtil.PrintList(result);
    }

    public static ListNode addTwoNumbers(ListNode headOne, ListNode headTwo) {
        if(headOne == null)
            return headTwo;

        if(headTwo == null)
            return headOne;


        int carry = 0;

        ListNode head = null;
        ListNode tail = null;

        while (headOne != null || headTwo != null){
            int sum = 0;
            if(headOne != null){
                sum += headOne.val;
                headOne = headOne.next;
            }

            if(headTwo != null){
                sum += headTwo.val;
                headTwo = headTwo.next;
            }

            sum += carry;
            carry = sum/10;
            ListNode newNode = new ListNode(sum%10);

            if(tail == null){
                head = tail = newNode;
            }
            else{
                tail.next = newNode;
                tail = newNode;
            }
        }

        if(carry != 0){
            ListNode newNode = new ListNode(carry);
            tail.next = newNode;
        }

        return head;
    }
}
