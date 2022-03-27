package Tree.BinaryTree;

import Tree.BinarySearchTree.TreeNode;

public class BalancedBinaryTree {
    public int isBalanced(TreeNode root) {
        MutableInteger height = new MutableInteger(0);
        return (isBalancedUtil(root, height) ? 1 : 0);
    }

    private boolean isBalancedUtil(TreeNode root, MutableInteger height){
        if(root == null)
            return true;

        MutableInteger leftTreeHeight = new MutableInteger(0);
        MutableInteger rightTreeHeight = new MutableInteger(0);

        if(!isBalancedUtil(root.left, leftTreeHeight))
            return false;

        if(!isBalancedUtil(root.right, rightTreeHeight))
            return false;

        if(Math.abs(leftTreeHeight.value - rightTreeHeight.value) > 1)
            return false;

        height.value = Math.max(leftTreeHeight.value, rightTreeHeight.value) + 1;
        return true;
    }

    class MutableInteger{
        Integer value;
        MutableInteger(Integer value){
            this.value = value;
        }
    }
}
