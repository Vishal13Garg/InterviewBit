package Tree.BinaryTree;

import Tree.BinarySearchTree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class RightViewOfBinaryTree {

    public static void main(String[] args) {

        // 1 15 2 -1 -1 -1 -1
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(15);
        root.right = new TreeNode(1);

        root.left.left = new TreeNode(2);

        ArrayList<Integer> traversal = solve(root);
        System.out.println(traversal);
    }

    public static ArrayList<Integer> solve(TreeNode root) {
        ArrayList<Integer> rightView = new ArrayList<>();
        if(root == null)
            return rightView;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
            int nodeCount = queue.size();
            for (int i=0; i<nodeCount; i++){
                TreeNode current = queue.remove();

                if(current.left != null)
                    queue.add(current.left);

                if(current.right != null)
                    queue.add(current.right);

                if(i == nodeCount-1)
                    rightView.add(current.val);
            }
        }

        return rightView;
    }
}
