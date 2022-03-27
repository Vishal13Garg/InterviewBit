package Tree.BinaryTree;

import Tree.BinarySearchTree.TreeNode;

import java.util.ArrayList;

public class ConstructBSTFromPreorder {
    public TreeNode constructBST(int[] preOrder) {
        return constructBSTUtil(preOrder, 0, preOrder.length-1);
    }

    private TreeNode constructBSTUtil(int[] preOrder, int startIndex, int endIndex){
        if(startIndex > endIndex)
            return null;

        if(startIndex == endIndex)
            return new TreeNode(preOrder[startIndex]);

        TreeNode root = new TreeNode(preOrder[startIndex]);
        int rightChildStartIndex = startIndex+1;

        while (rightChildStartIndex<=endIndex && preOrder[rightChildStartIndex] < root.val)
            rightChildStartIndex++;

        root.left = constructBSTUtil(preOrder, startIndex+1, rightChildStartIndex-1);
        root.right = constructBSTUtil(preOrder, rightChildStartIndex, endIndex);
        return root;
    }
}
