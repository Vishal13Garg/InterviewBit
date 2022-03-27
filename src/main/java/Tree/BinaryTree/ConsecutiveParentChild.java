package Tree.BinaryTree;

import Tree.BinarySearchTree.TreeNode;

public class ConsecutiveParentChild {
    public int consecutiveNodes(TreeNode A) {
        return (consecutiveNodeUtil(A.left, A.val) + consecutiveNodeUtil(A.right, A.val));
    }

    private int consecutiveNodeUtil(TreeNode root, int parentValue){
        if(root == null)
            return 0;

        int consecutiveNodesCount = 0;
        if(Math.abs(root.val - parentValue) == 1)
            consecutiveNodesCount++;

        consecutiveNodesCount += consecutiveNodeUtil(root.left, root.val);
        consecutiveNodesCount += consecutiveNodeUtil(root.right, root.val);

        return consecutiveNodesCount;
    }
}
