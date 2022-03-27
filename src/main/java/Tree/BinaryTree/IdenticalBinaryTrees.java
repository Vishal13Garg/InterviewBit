package Tree.BinaryTree;

import Tree.BinarySearchTree.TreeNode;

public class IdenticalBinaryTrees {
    public int isSameTree(TreeNode root1, TreeNode root2) {
        if( root1==null && root2 == null)
            return 1;

        if((root1==null && root2 != null) || (root1 != null && root2 == null))
            return 0;

        if(root1.val != root2.val)
            return 0;

        if(isSameTree(root1.left, root2.left) == 0 || isSameTree(root1.right, root2.right) == 0)
            return 0;

        return 1;
    }
}
