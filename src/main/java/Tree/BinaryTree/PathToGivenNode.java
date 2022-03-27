package Tree.BinaryTree;

import Tree.BinarySearchTree.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class PathToGivenNode {
    public ArrayList<Integer> solve(TreeNode root, int k) {
        Deque<Integer> currentPath = new LinkedList<>();
        boolean isPresent = solveUtil(root, currentPath, k);

        ArrayList<Integer> path = new ArrayList<>(currentPath);
        return path;
    }

    private static boolean solveUtil(TreeNode root, Deque<Integer> currentPath, int k) {
        if(root == null)
            return false;

        currentPath.addLast(root.val);
        if(root.val == k)
            return true;

        boolean isPresentInLeftTree = solveUtil(root.left, currentPath, k);
        if(isPresentInLeftTree)
            return true;

        boolean isPresentInRightTree = solveUtil(root.right, currentPath, k);
        if(isPresentInRightTree)
            return true;

        currentPath.removeLast();
        return false;
    }
}
