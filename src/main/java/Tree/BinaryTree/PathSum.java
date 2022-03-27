package Tree.BinaryTree;

import Tree.BinarySearchTree.TreeNode;

import java.util.ArrayList;

public class PathSum {

    //7 1000 2000 -1 -3001 -1 -1 -1
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1000);
        root.left = new TreeNode(2000);

        root.left.left = new TreeNode(-3001);

        Integer result = hasPathSum(root, -1);
        System.out.println(result);
    }

    public static int hasPathSum(TreeNode root, int B) {
        return hasPathSumUtil(root, B, 0);
    }

    private static int hasPathSumUtil(TreeNode root, int B, int currentSum) {
        if(root == null)
            return 0;

        currentSum += root.val;
        if(root.left == null && root.right == null && currentSum == B)
            return 1;
        else
            return (hasPathSumUtil(root.left, B, currentSum) == 1 || hasPathSumUtil(root.right, B, currentSum) == 1 ? 1 : 0);

    }
}
