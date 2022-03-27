package Tree.BinaryTree;

import Tree.BinarySearchTree.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class RootToLeafPathsWithSum {
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int k) {
        Deque<Integer> parentPath = new LinkedList<>();
        ArrayList<ArrayList<Integer>> matchingPath = new ArrayList<>();

        pathSumUtil(root, 0, k, parentPath, matchingPath);
        return matchingPath;
    }

    private void pathSumUtil(TreeNode root, int currentSum, int k, Deque<Integer> parentPath, ArrayList<ArrayList<Integer>> matchingPath){
        if(root == null)
            return;

        currentSum += root.val;
        parentPath.addLast(root.val);

        if(root.left == null && root.right == null){
            if(currentSum == k){
                matchingPath.add(new ArrayList<>(parentPath));
            }
        }
        else {
            pathSumUtil(root.left, currentSum, k, parentPath, matchingPath);
            pathSumUtil(root.right, currentSum, k, parentPath, matchingPath);
        }

        parentPath.removeLast();
        return;
    }
}
