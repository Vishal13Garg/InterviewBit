package Tree.BinaryTree;

import Tree.BinarySearchTree.TreeNode;

import java.util.Stack;

public class BurnATree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(14);
        root.left = new TreeNode(11);

        root.left.left = new TreeNode(7);
        root.left.right = new TreeNode(13);

        root.left.right.left = new TreeNode(12);
        root.left.right.right = new TreeNode(1);

        root.left.right.right.left = new TreeNode(5);
        int path = solve(root, 12);

        System.out.println(path);
    }

    public static int solve(TreeNode root, int target) {
        Stack<TreeNode> path = new Stack<>();
        findPathToNode(root, target, path);

        TreeNode current = path.pop();
        int maxPath = findMaxPath(current);

        int distanceFromTarget = 1;
        while (!path.isEmpty() ){
            TreeNode parent = path.pop();
            TreeNode pathToTraverse = current == parent.left ? parent.right : parent.left;

            int currentPathLength = pathToTraverse == null ? distanceFromTarget :  findMaxPath(pathToTraverse) + distanceFromTarget + 1;
            maxPath = Math.max(maxPath, currentPathLength);
            distanceFromTarget++;
            current = parent;
        }

        return maxPath;
    }

    private static boolean findPathToNode(TreeNode root, int target, Stack<TreeNode> stack){
        if(root == null)
            return false;

        stack.push(root);
        if(root.val == target)
            return true;

        if(findPathToNode(root.left, target, stack))
            return true;

        if(findPathToNode(root.right, target, stack))
            return true;

        stack.pop();
        return false;
    }

    private static int findMaxPath(TreeNode root){
        if(root == null)
            return 0;

        if(root.left == null && root.right == null)
            return 0;

        return Math.max(findMaxPath(root.left), findMaxPath(root.right)) + 1;
    }
}
