package Tree.BinaryTree;

import Tree.BinarySearchTree.TreeNode;

public class InvertTheBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if(root == null)
            return root;

        if(root.left == null && root.right == null)
            return root;

        TreeNode lchild = invertTree(root.left);
        TreeNode rchild = invertTree(root.right);

        root.left = rchild;
        root.right = lchild;

        return root;
    }
}
