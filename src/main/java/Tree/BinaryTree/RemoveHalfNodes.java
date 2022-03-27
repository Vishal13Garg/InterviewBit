package Tree.BinaryTree;

import Tree.BinarySearchTree.TreeNode;

public class RemoveHalfNodes {
    public TreeNode solve(TreeNode root) {
        return removeHalfNodes(root);
    }

    private TreeNode removeHalfNodes(TreeNode root){
        if(root == null)
            return root;

        if(root.left == null && root.right == null)
            return root;


        root.left = removeHalfNodes(root.left);
        root.right = removeHalfNodes(root.right);

        if(root.left != null && root.right != null)
            return root;
        else {
            if(root.left == null)
                return root.right;
            else
                return root.left;
        }

    }
}
