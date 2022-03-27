package Tree.BinaryTree;

import Tree.BinarySearchTree.TreeNode;

import java.util.ArrayList;

public class PostorderTraversal {
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> path = new ArrayList<>();
        postorderTraversalUtil(root, path);
        return path;
    }

    private void postorderTraversalUtil(TreeNode root, ArrayList<Integer> path){
        if(root == null)
            return;

        postorderTraversalUtil(root.left, path);
        postorderTraversalUtil(root.right, path);
        path.add(root.val);
    }
}
