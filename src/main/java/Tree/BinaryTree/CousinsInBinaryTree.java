package Tree.BinaryTree;

import Tree.BinarySearchTree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CousinsInBinaryTree {
    public ArrayList<Integer> solve(TreeNode A, int B) {
        if(A==null || A.val == B)
            return new ArrayList<>();

        ArrayList<Integer> cousinList = new ArrayList<>();

        boolean nodeFound = false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(A);

        while (!queue.isEmpty() && !nodeFound){
            int size = queue.size();
            for (int i=0; i<size; i++){
                TreeNode node = queue.remove();

                if((node.left != null && node.left.val == B) || (node.right != null && node.right.val == B)){
                    nodeFound = true;
                    continue;
                }

                if(node.left != null)
                    queue.add(node.left);

                if(node.right != null)
                    queue.add(node.right);
            }
        }

        if (nodeFound){
            while (!queue.isEmpty())
                cousinList.add(queue.remove().val);
        }

        return cousinList;
    }
}
