package Tree.BinaryTree;

import Tree.BinarySearchTree.TreeNode;

import java.util.ArrayList;

public class InorderTraversal {
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> path = new ArrayList<>();
        inorderTraversalUtil(root, path);
        return path;
    }

    private void inorderTraversalUtil(TreeNode root, ArrayList<Integer> path) {
        if(root == null)
            return;

        inorderTraversalUtil(root.left, path);
        path.add(root.val);
        inorderTraversalUtil(root.right, path);
    }
}
