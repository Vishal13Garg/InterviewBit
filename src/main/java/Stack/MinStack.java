package Stack;

public class MinStack {
    private Node top;
    private Node minTop;

    MinStack(){
        top = null;
        minTop = null;
    }

    public void push(int x) {
        Node newNode = new Node(x);
        newNode.next = top;
        top = newNode;

        if(minTop == null || minTop.value >= x){
            Node minNode = new Node(x);
            minNode.next = minTop;
            minTop = minNode;
        }
    }

    public void pop() {
        if(top == null)
            return;

        Node poppedNode = top;
        top = top.next;

        if(minTop.value == poppedNode.value)
            minTop = minTop.next;
    }

    public int top() {
        if(top == null)
            return -1;

        return top.value;
    }

    public int getMin() {
        if(minTop == null)
            return -1;

        return minTop.value;
    }

    class Node{
        private int value;
        private Node next;

        Node(int value){
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}
