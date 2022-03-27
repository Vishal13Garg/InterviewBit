package Tree.BinaryTree;

import Tree.BinarySearchTree.TreeNode;

public class MaxDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;

        return maxDepthUtil(root);
    }

    private int maxDepthUtil(TreeNode root){
        if(root == null)
            return 0;

        return (Math.max(maxDepthUtil(root.left), maxDepthUtil(root.right)) + 1);
    }

}
