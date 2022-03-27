package Tree.BinaryTree;

import Tree.BinarySearchTree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> path = new LinkedList<>();
        preorderTraversalUtil(root, path);
        return path;
    }

    private void preorderTraversalUtil(TreeNode root, List<Integer> path){
        if(root == null)
            return;

        path.add(root.val);
        preorderTraversalUtil(root.left, path);
        preorderTraversalUtil(root.right, path);
    }
}
