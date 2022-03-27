package Tree.BinaryTree;

import Tree.BinarySearchTree.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

public class ZigZagLevelOrderTraversalBT {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(4);

        root.left.left = new TreeNode(8);
        root.left.right = new TreeNode(5);

        root.left.right.left = new TreeNode(9);
        root.left.right.right = new TreeNode(7);

        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
        root.right.right.left = new TreeNode(6);

        ArrayList<ArrayList<Integer>> traversal = zigzagLevelOrder(root);
        System.out.println(traversal);
    }

    public static ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(root == null)
            return result;

        Stack<TreeNode> stackOne = new Stack<>();
        Stack<TreeNode> stackTwo = new Stack<>();

        stackOne.push(root);
        while (!stackOne.isEmpty()){
            ArrayList<Integer> currentLevel = new ArrayList<>();
            while (!stackOne.isEmpty()){
                TreeNode current = stackOne.pop();
                currentLevel.add(current.val);

                if(current.left != null)
                    stackTwo.push(current.left);

                if(current.right != null)
                    stackTwo.push(current.right);


            }
            if(!currentLevel.isEmpty())
                result.add(currentLevel);

            ArrayList<Integer> nextLevel = new ArrayList<>();
            while (!stackTwo.isEmpty()){
                TreeNode current = stackTwo.pop();
                nextLevel.add(current.val);

                if(current.right != null)
                    stackOne.push(current.right);

                if(current.left != null)
                    stackOne.push(current.left);

            }

            if(!nextLevel.isEmpty())
                result.add(nextLevel);
        }

        return result;
    }
}
