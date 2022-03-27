package Tree.BinaryTree;

import Tree.BinarySearchTree.TreeNode;

public class SymmetricBinaryTree {
    public int isSymmetric(TreeNode root) {
        if(root == null)
            return 1;

        return isSymmetricUtil(root.left, root.right);
    }

    private int isSymmetricUtil(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null)
            return 1;

        if((root1 == null && root2 != null) || (root1 != null && root2 == null) || (root1.val != root2.val))
            return 0;

        if(isSymmetricUtil(root1.left, root2.right) == 0 || isSymmetricUtil(root1.right, root2.left) == 0)
            return 0;

        return 1;
    }
}
