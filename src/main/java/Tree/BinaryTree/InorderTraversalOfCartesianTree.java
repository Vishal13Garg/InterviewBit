package Tree.BinaryTree;

import Tree.BinarySearchTree.TreeNode;

import java.util.ArrayList;

public class InorderTraversalOfCartesianTree {
    public TreeNode buildTree(ArrayList<Integer> A) {
        TreeNode root = buildTreeUtil(A, 0, A.size()-1);
        return root;
    }

    private TreeNode buildTreeUtil(ArrayList<Integer> nodeList, int start, int end){
        if(end < start)
            return null;

        if(start == end)
            return new TreeNode(nodeList.get(start));


        int maxIndex = start;
        for (int i =start+1; i<=end; i++){
            if(nodeList.get(i) > nodeList.get(maxIndex))
                maxIndex = i;
        }

        TreeNode root = new TreeNode(nodeList.get(maxIndex));
        root.left = buildTreeUtil(nodeList, start, maxIndex-1);
        root.right = buildTreeUtil(nodeList, maxIndex+1, end);
        return root;
    }
}
