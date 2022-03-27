package Tree.BinaryTree;

import Tree.BinarySearchTree.TreeNode;

public class BinaryTreeFromInorderAndPostorder {
    public TreeNode buildTree(int[] inOrder, int[] postOrder) {
        return buildTreeUtil(inOrder, 0, inOrder.length-1,
                             postOrder, 0, postOrder.length-1);
    }

    private TreeNode buildTreeUtil(int[] inOrder, int inOrderStart, int inOrderEnd,
                                   int[] postOrder, int postOrderStart, int postOrderEnd){
        if(inOrderStart > inOrderEnd)
            return null;

        if(inOrderStart == inOrderEnd)
            return new TreeNode(inOrder[inOrderStart]);

        TreeNode root = new TreeNode(postOrder[postOrderEnd]);
        int rootIndexInInorderTraversal = inOrderStart;

        while (rootIndexInInorderTraversal <= inOrderEnd){
            if(inOrder[rootIndexInInorderTraversal] == postOrder[postOrderEnd])
                break;
            rootIndexInInorderTraversal++;
        }

        int leftTreeSize = rootIndexInInorderTraversal-inOrderStart;

        root.left = buildTreeUtil(inOrder, inOrderStart, rootIndexInInorderTraversal-1,
                                  postOrder, postOrderStart, postOrderStart+leftTreeSize-1);
        root.right = buildTreeUtil(inOrder, rootIndexInInorderTraversal+1, inOrderEnd,
                postOrder, postOrderStart+leftTreeSize, postOrderEnd-1);

        return root;
    }
}
