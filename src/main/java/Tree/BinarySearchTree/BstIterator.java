package Tree.BinarySearchTree;

import java.util.Stack;

public class BstIterator {
    private TreeNode root;
    private Stack<TreeNode> stack;

    BstIterator(TreeNode root){
        this.root = root;

        TreeNode current = root;
        while (current != null){
            stack.push(current);
            current = current.left;
        }
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    public int next() {
        TreeNode nextNode = stack.pop();
        TreeNode current = nextNode.right;

        while (current != null){
            stack.push(current);
            current = current.left;
        }
        return nextNode.val;
    }
}
