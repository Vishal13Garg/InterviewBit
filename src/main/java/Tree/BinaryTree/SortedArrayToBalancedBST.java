package Tree.BinaryTree;

import Tree.BinarySearchTree.TreeNode;

public class SortedArrayToBalancedBST {
    public TreeNode sortedArrayToBST(final int[] A) {
        return createBST(A, 0, A.length-1);
    }

    private TreeNode createBST(final int[] A, int startIndex, int endIndex) {
        if(startIndex > endIndex)
            return null;

        if(startIndex == endIndex)
            return new TreeNode(A[startIndex]);

        int mid = (startIndex+endIndex+1)/2;
        TreeNode root = new TreeNode(A[mid]);
        root.left = createBST(A, startIndex, mid-1);
        root.right = createBST(A, mid+1, endIndex);
        return root;
    }
}
