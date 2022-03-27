package Tree.BinaryTree;

import Tree.BinarySearchTree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ReverseLevelOrder {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(4);

        root.left.left = new TreeNode(8);
        root.left.right = new TreeNode(5);

        root.left.right.left = new TreeNode(9);
        root.left.right.right = new TreeNode(7);

        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
        root.right.right.left = new TreeNode(6);

        ArrayList<Integer> traversal = solve(root);
        System.out.println(traversal);
    }


    public static ArrayList<Integer> solve(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();

        if(root == null)
            return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (! queue.isEmpty()){
            ArrayList<Integer> current = new ArrayList<>();
            int size = queue.size();
            for (int i=0; i<size; i++){
                TreeNode top = queue.remove();
                current.add(top.val);

                if(top.left != null)
                    queue.add(top.left);

                if(top.right != null)
                    queue.add(top.right);
            }

            current.addAll(result);
            result = current;
        }

        return result;
    }
}
