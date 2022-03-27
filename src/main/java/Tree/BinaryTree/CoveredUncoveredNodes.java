package Tree.BinaryTree;

import Tree.BinarySearchTree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CoveredUncoveredNodes {
    public static void main(String[] args) {

        // 7 3 -1 -1 8 -1 6 2 -1 -1 1 -1 5 4 9 -1 -1 -1 -1
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.left.right = new TreeNode(5);

        Long treeSum = coveredNodes(root);
        System.out.println(treeSum);
    }

    public static Long coveredNodes(TreeNode root) {
        if(root == null)
            return 0L;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        Long coveredNodeSum = 0L;
        Long unCoveredNodeSum = 0L;

        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i=1; i<= size; i++){
                TreeNode current = queue.remove();

                if(i ==1 || i==size)
                    unCoveredNodeSum += current.val;
                else
                    coveredNodeSum += current.val;

                if(current.left != null)
                    queue.add(current.left);

                if(current.right != null)
                    queue.add(current.right);
            }
        }

        return Math.abs(coveredNodeSum -unCoveredNodeSum);

    }
}
