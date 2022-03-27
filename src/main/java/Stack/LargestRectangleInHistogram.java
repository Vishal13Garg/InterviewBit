package Stack;

import java.util.ArrayList;
import java.util.Stack;

public class LargestRectangleInHistogram {

    public static void main(String[] args) {
        ArrayList<Integer> input = new ArrayList<>();
        //5, 9, 6, 8, 6, 4, 6, 9, 5, 4, 9
        input.add(2);

        System.out.println(input);
        System.out.println(largestRectangleArea(input));
    }


    public static int largestRectangleArea(ArrayList<Integer> input) {
        if(input == null || input.size() == 0)
            return 0;

        Integer[] nextSmallerElementIndexArray = getNextSmallerElementIndex(input);
        Integer[] previousSmallerElementIndexArray = getPreviousSmallerElementIndex(input);

        int currentMax = 0;
        for (int i=0; i<input.size(); i++){
            int height = input.get(i);
            int width = nextSmallerElementIndexArray[i] - previousSmallerElementIndexArray[i] - 1;

            currentMax = Math.max(currentMax, height*width);
        }
        return currentMax;
    }

    private static Integer[] getNextSmallerElementIndex(ArrayList<Integer> input){
        Integer[] nextSmallerElementIndexArray = new Integer[input.size()];
        Stack<Integer> stack = new Stack<>();

        for (int i= input.size()-1; i>=0; i--){
            while (!stack.isEmpty() && input.get(stack.peek()) >= input.get(i))
                stack.pop();

            int nextSmallerElementIndex = stack.isEmpty() ? input.size() : stack.peek();
            nextSmallerElementIndexArray[i] = nextSmallerElementIndex;
            stack.add(i);
        }
        return nextSmallerElementIndexArray;
    }

    private static Integer[] getPreviousSmallerElementIndex(ArrayList<Integer> input){
        Integer[] previousSmallerElementIndexArray = new Integer[input.size()];
        Stack<Integer> stack = new Stack<>();

        for (int i= 0; i<input.size(); i++){
            while (!stack.isEmpty() && input.get(stack.peek()) >= input.get(i))
                stack.pop();

            int previousSmallerElementIndex = stack.isEmpty() ? -1 : stack.peek();
            previousSmallerElementIndexArray[i] = previousSmallerElementIndex;
            stack.add(i);
        }
        return previousSmallerElementIndexArray;
    }
}
