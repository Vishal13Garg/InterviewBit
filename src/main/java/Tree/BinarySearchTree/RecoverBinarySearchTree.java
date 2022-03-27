package Tree.BinarySearchTree;

import java.security.KeyPair;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class RecoverBinarySearchTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        System.out.println(recoverTree(root));
    }

    public static ArrayList<Integer> recoverTree(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if(root == null)
            return result;


        List<Pair> unorderedNodes = new LinkedList<>();
        TreeNode pre = null;

        getInOrderTraversal(root, pre, unorderedNodes);

        if(unorderedNodes.size() == 1){
            result.add(unorderedNodes.get(0).value2);
            result.add(unorderedNodes.get(0).value1);
        }
        else {
            result.add(unorderedNodes.get(1).value2);
            result.add(unorderedNodes.get(0).value1);
        }

        return result;
    }

    private static TreeNode getInOrderTraversal(TreeNode root, TreeNode pre, List<Pair> unorderedNodes){
        if(root == null)
            return pre;

        pre = getInOrderTraversal(root.left, pre, unorderedNodes);

        if(pre != null && pre.val > root.val)
            unorderedNodes.add(new Pair(pre.val, root.val));

        pre = getInOrderTraversal(root.right, root, unorderedNodes);
        return pre;
    }

    static class Pair{
        int value1;
        int value2;

        Pair(int value1, int value2){
            this.value1 = value1;
            this.value2 = value2;
        }
    }

}
