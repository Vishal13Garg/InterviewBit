package Tree.BinarySearchTree;

import java.util.ArrayList;
import java.util.List;

public class TwoSumBinaryTree {
    public int t2Sum(TreeNode root, int k) {
        if(root == null)
            return 0;

        ArrayList<Integer> inOrder = new ArrayList<>();
        getInOrderTraversal(root, inOrder);

        int start =0;
        int end = inOrder.size()-1;

        while (start<end){
            if(inOrder.get(start) + inOrder.get(end) == k)
                return 1;
            else if(inOrder.get(start) + inOrder.get(end) > k)
                end--;
            else
                start++;
        }
        return 0;
    }

    private static void getInOrderTraversal(TreeNode root, List<Integer> inOrder){
        if(root == null)
            return;

        getInOrderTraversal(root.left, inOrder);
        inOrder.add(root.val);
        getInOrderTraversal(root.right, inOrder);
    }
}
