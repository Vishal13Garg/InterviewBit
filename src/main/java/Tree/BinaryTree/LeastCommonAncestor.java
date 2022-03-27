package Tree.BinaryTree;

import Tree.BinarySearchTree.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class LeastCommonAncestor {
    public int lca(TreeNode root, int nodeOne, int nodeTwo) {
        LCA result = lcaUtil(root, nodeOne, nodeTwo);

        if(result == null || result.lca == null)
            return -1;
        else
            return result.lca.val;
    }

    private static LCA lcaUtil(TreeNode root, int nodeOne, int nodeTwo){
        if(root == null){
            return null;
        }

        LCA leftTreeResult = lcaUtil(root.left, nodeOne, nodeTwo);
        LCA rightTreeResult = lcaUtil(root.right, nodeOne, nodeTwo);

        if(leftTreeResult != null && leftTreeResult.lca != null)
            return leftTreeResult;

        if(rightTreeResult != null && rightTreeResult.lca != null)
            return rightTreeResult;

        TreeNode nodeOneAddress = null;
        if(root.val == nodeOne)
            nodeOneAddress = root;
        else {
            if(leftTreeResult != null && leftTreeResult.nodeOne != null)
                nodeOneAddress = leftTreeResult.nodeOne;
            if(rightTreeResult != null && rightTreeResult.nodeOne != null)
                nodeOneAddress = rightTreeResult.nodeOne;
        }


        TreeNode nodeTwoAddress = null;
        if(root.val == nodeTwo)
            nodeTwoAddress = root;
        else {
            if(leftTreeResult != null && leftTreeResult.nodeTwo != null)
                nodeTwoAddress = leftTreeResult.nodeTwo;
            if(rightTreeResult != null && rightTreeResult.nodeTwo != null)
                nodeTwoAddress = rightTreeResult.nodeTwo;
        }

        if(nodeOneAddress != null && nodeTwoAddress != null){
            return new LCA(root, nodeOneAddress, nodeTwoAddress);
        }

        return new LCA(null, nodeOneAddress, nodeTwoAddress);
    }

    private static class LCA {
        private TreeNode lca;
        private TreeNode nodeOne;
        private TreeNode nodeTwo;

        LCA(TreeNode lca, TreeNode nodeOne, TreeNode nodeTwo){
            this.lca = lca;
            this.nodeOne = nodeOne;
            this.nodeTwo = nodeTwo;
        }
    }
}
