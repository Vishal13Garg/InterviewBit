package Stack;

import java.util.ArrayList;
import java.util.Stack;

public class NearestSmallerElement {

    public static void main(String[] args) {
        ArrayList<Integer> input = new ArrayList<>();
        //4, 5, 2, 10, 8
        input.add(4);
        input.add(5);
        input.add(2);
        input.add(10);
        input.add(8);

        ArrayList<Integer> nearestSmallestElementArray = prevSmaller(input);
        System.out.println(nearestSmallestElementArray);
    }

    public static ArrayList<Integer> prevSmaller(ArrayList<Integer> A) {
        ArrayList<Integer> nearestSmallerElement = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        for (int i=0; i<A.size(); i++){
            while (!stack.isEmpty() && stack.peek() >= A.get(i))
                stack.pop();

            int nearestValue = stack.isEmpty() ? -1 : stack.peek();
            nearestSmallerElement.add(nearestValue);
            stack.push(A.get(i));
        }
        return nearestSmallerElement;
    }
}
