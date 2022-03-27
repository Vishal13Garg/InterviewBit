package Tree.BinarySearchTree;

import java.util.ArrayList;
import java.util.Arrays;

public class ValidBstFromPreorder {

    public static void main(String[] args) {
        ArrayList<Integer> preOrder = new ArrayList<>(Arrays.asList(10, 10, 4, 100));
        System.out.println(solve(preOrder));
    }

    public static int solve(ArrayList<Integer> preOrder) {
        boolean isValidBST = validateBST(preOrder, 0, preOrder.size()-1, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return (isValidBST == true ? 1 : 0);
    }

    private static boolean validateBST(ArrayList<Integer> preOrder, int startIndex, int endIndex, int lowerBound, int upperBound){
        if(startIndex > endIndex)
            return true;

        if(startIndex == endIndex){
            boolean validNode = (preOrder.get(startIndex) >= lowerBound && preOrder.get(endIndex) <= upperBound);
            return validNode;
        }

        int midIndex = startIndex+1;
        while (midIndex <= endIndex && preOrder.get(midIndex) <= preOrder.get(startIndex)){
                midIndex++;
        }

        boolean leftChild = validateBST(preOrder, startIndex+1, midIndex-1, lowerBound, preOrder.get(startIndex));
        if(leftChild == false)
            return false;

        boolean rightChild = validateBST(preOrder, midIndex, endIndex, preOrder.get(startIndex), upperBound);
        return rightChild;
    }
}
