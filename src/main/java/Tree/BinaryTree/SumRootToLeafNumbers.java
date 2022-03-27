package Tree.BinaryTree;

import Tree.BinarySearchTree.TreeNode;

import java.util.ArrayList;

public class SumRootToLeafNumbers {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(8);

        root.right = new TreeNode(3);
        root.right.right = new TreeNode(6);

        Integer traversal = sumNumbers(root);
        System.out.println(traversal);
    }

    public static int sumNumbers(TreeNode root) {
        MutableInteger currentSum = new MutableInteger(0);
        sumNumbersUtil(root, 0, currentSum);
        return currentSum.value;
    }

    public static void sumNumbersUtil(TreeNode root, Integer currentNumber, MutableInteger currentSum) {
        if(root == null)
            return;

        currentNumber = (currentNumber*10 + root.val)%1003;

        if(root.left == null && root.right == null){
            //System.out.println(currentNumber);
            currentSum.value = (currentSum.value + currentNumber)%1003;
            return;
        }

        sumNumbersUtil(root.left, currentNumber, currentSum);
        sumNumbersUtil(root.right, currentNumber, currentSum);
    }

    private static class MutableInteger{
        int value;
        MutableInteger(int value){
            this.value = value;
        }
    }
}
