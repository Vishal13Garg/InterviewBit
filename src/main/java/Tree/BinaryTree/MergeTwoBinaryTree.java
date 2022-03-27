package Tree.BinaryTree;

import Tree.BinarySearchTree.TreeNode;

public class MergeTwoBinaryTree {
    public TreeNode solve(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null)
            return null;

        TreeNode mergedRoot = new TreeNode((root1 != null ? root1.val : 0) + (root2 != null ? root2.val : 0));
        mergedRoot.left = solve(root1 != null ? root1.left : null, root2 != null ? root2.left : null);
        mergedRoot.right = solve(root1 != null ? root1.right : null, root2 != null ? root2.right : null);

        return mergedRoot;
    }
}
