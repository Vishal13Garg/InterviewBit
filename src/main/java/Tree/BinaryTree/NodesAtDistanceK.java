package Tree.BinaryTree;

import Tree.BinarySearchTree.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

public class NodesAtDistanceK {
    public ArrayList<Integer> distanceK(TreeNode root, int target, int distance) {
        ArrayList<Integer> result = new ArrayList<>();

        if(root == null)
            return result;

        Stack<TreeNode> path = new Stack<>();
        if(!findPath(root, target, path))
            return result;

        TreeNode current = path.pop();
        findSubTreeNodesAtDistanceK(current, distance, result);

        while (!path.isEmpty()){
            distance--;
            TreeNode parent = path.pop();
            TreeNode subtreeToConsider = (current == parent.left) ? parent.right : parent.left;

            if(distance == 0){
                result.add(parent.val);
                break;
            }
            findSubTreeNodesAtDistanceK(subtreeToConsider, distance-1, result);
            current = parent;

        }
        return result;
    }

    private boolean findPath(TreeNode root, int target, Stack<TreeNode> path){
        if(root == null)
            return false;

        path.push(root);

        if(root.val == target)
            return true;

        if(findPath(root.left, target, path))
            return true;

        if(findPath(root.right, target, path))
            return true;

        path.pop();
        return false;
    }

    private void findSubTreeNodesAtDistanceK(TreeNode root, int distance, ArrayList<Integer> result){
        if(root == null || distance <0)
            return;

        if(distance == 0){
            result.add(root.val);
            return;
        }

        findSubTreeNodesAtDistanceK(root.left, distance-1, result);
        findSubTreeNodesAtDistanceK(root.right, distance-1, result);
    }
}
