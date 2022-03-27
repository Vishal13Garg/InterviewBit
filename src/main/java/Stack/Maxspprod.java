package Stack;

import java.util.ArrayList;
import java.util.Stack;

public class Maxspprod {

    public static void main(String[] args) {
        ArrayList<Integer> input = new ArrayList<>();
        //5, 9, 6, 8, 6, 4, 6, 9, 5, 4, 9
        input.add(5);
        input.add(9);
        input.add(6);
        input.add(8);
        input.add(6);
        input.add(4);
        input.add(6);
        input.add(9);
        input.add(5);
        input.add(4);
        input.add(9);

        System.out.println(input);
        System.out.println(maxSpecialProduct(input));
    }

    public static int maxSpecialProduct(ArrayList<Integer> input) {
        ArrayList<Integer> leftSpecialValue = new ArrayList<>();
        ArrayList<Integer> rightSpecialValue = new ArrayList<>();

        Stack<Integer> leftStack = new Stack<>();
        Stack<Integer> rightStack = new Stack<>();

        for (int i=0; i<input.size(); i++){
            while (!leftStack.isEmpty() && input.get(leftStack.peek()) <= input.get(i))
                leftStack.pop();

            if(leftStack.isEmpty())
                leftSpecialValue.add(0);
            else
                leftSpecialValue.add(leftStack.peek());

            leftStack.push(i);
        }

        for (int i=input.size()-1; i>=0; i--){
            while (!rightStack.isEmpty() && input.get(rightStack.peek()) <= input.get(i))
                rightStack.pop();

            if(rightStack.isEmpty())
                rightSpecialValue.add(0, 0);
            else
                rightSpecialValue.add(0, rightStack.peek());

            rightStack.push(i);
        }

        long currentMax = 0;
        for (int i=0; i<input.size(); i++){
            long currentProduct = (leftSpecialValue.get(i)*rightSpecialValue.get(i));
            currentMax = Math.max(currentMax, currentProduct);
            //System.out.println(i + " " + leftSpecialValue.get(i) + " " + rightSpecialValue.get(i));
        }
        int result = (int) (currentMax%1000000007);
        return result;
    }
}
