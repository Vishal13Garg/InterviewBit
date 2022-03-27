package Tree.BinaryTree;

import Tree.BinarySearchTree.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class DiagonalTraversal {

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
        ArrayList<Integer> traversal = new ArrayList<>();

        if(root == null)
            return traversal;

        Deque<TreeNode> current = new LinkedList<>();
        Deque<TreeNode> next = new LinkedList<>();

        current.addLast(root);
        while (current.size() >0){
            while (current.size() >0){
                TreeNode top = current.removeFirst();
                while (top != null){
                    traversal.add(top.val);
                    if(top.left != null)
                        next.addLast(top.left);
                    top = top.right;
                }

            }
            current = next;
        }

        return traversal;
    }
}
