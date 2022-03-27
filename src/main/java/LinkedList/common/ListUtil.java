package LinkedList.common;

public class ListUtil {
    public static ListNode CreateList(Integer[] arr){
        if(arr == null || arr.length == 0)
            return null;

        ListNode head = null;
        ListNode current = null;

        for(int i=0; i<arr.length; i++){
            ListNode newNode = new ListNode(arr[i]);

            if(current == null){
                head = current = newNode;
            }
            else {
                current.next = newNode;
                current = newNode;
            }
        }

        return head;
    }

    public static void PrintList(ListNode head){
        ListNode current = head;
        while (current != null){
            System.out.print(current.val + " --> ");
            current = current.next;
        }
        System.out.println();
    }
}
