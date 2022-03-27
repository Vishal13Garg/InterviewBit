package Tree.BinaryTree;

import Tree.BinarySearchTree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MinDepthOfBinaryTree {
    public int minDepth(TreeNode root) {
        if(root == null)
            return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int currentLevel = 0;

        while (!queue.isEmpty()){
            currentLevel++;
            int size = queue.size();

            for (int i=0; i<size; i++){
                TreeNode current = queue.remove();
                if(current.left == null && current.right == null){
                    return currentLevel;
                }

                if(current.left != null)
                    queue.add(current.left);

                if(current.right != null)
                    queue.add(current.right);

            }
        }

        return currentLevel;
    }
}
