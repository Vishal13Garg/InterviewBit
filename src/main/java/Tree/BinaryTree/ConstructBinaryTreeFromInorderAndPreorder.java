package Tree.BinaryTree;

import Tree.BinarySearchTree.TreeNode;

public class ConstructBinaryTreeFromInorderAndPreorder {
    public TreeNode buildTree(int[] preOrder, int[] inOrder) {
        return buildTreeUtil(preOrder, 0, preOrder.length-1,
                             inOrder, 0, inOrder.length -1);
    }

    private TreeNode buildTreeUtil(int[] preOrder, int preOrderStart, int preOrderEnd,
                                   int[] inOrder, int inOrderStart, int inOrderEnd ){
        if(preOrderEnd < preOrderStart)
            return null;

        if(preOrderEnd == preOrderStart)
            return new TreeNode(preOrder[preOrderStart]);

        TreeNode root = new TreeNode(preOrder[preOrderStart]);
        int rootIndexInInOrder = inOrderStart;

        for (; rootIndexInInOrder<inOrderEnd; rootIndexInInOrder++){
            if(inOrder[rootIndexInInOrder] == preOrder[preOrderStart])
                break;
        }

        int leftChildSize = rootIndexInInOrder-inOrderStart;
        int righChildSize = inOrderEnd-rootIndexInInOrder;


        root.left = buildTreeUtil(preOrder, preOrderStart+1, preOrderStart+leftChildSize,
                                  inOrder, inOrderStart, rootIndexInInOrder-1);

        root.right = buildTreeUtil(preOrder, preOrderStart+leftChildSize+1, preOrderEnd,
                                   inOrder, rootIndexInInOrder+1, inOrderEnd);

        return root;
    }
}
