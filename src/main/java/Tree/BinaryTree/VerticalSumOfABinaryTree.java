package Tree.BinaryTree;

import Tree.BinarySearchTree.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class VerticalSumOfABinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(4);

        root.left.left = new TreeNode(8);
        root.left.right = new TreeNode(5);

        root.left.right.left = new TreeNode(9);
        root.left.right.right = new TreeNode(7);

        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
        root.right.right.left = new TreeNode(6);

        ArrayList<Integer> traversal = verticalSum(root);
        System.out.println(traversal);
    }


    public static ArrayList<Integer> verticalSum(TreeNode root) {
        ArrayList<Integer> sum = new ArrayList<>();

        if(root == null)
            return sum;

        Map<Integer, Integer> sumMap = new HashMap<>();
        computeVerticalSum(root, 0, sumMap);

        int minLevel = Integer.MAX_VALUE;
        for (int i : sumMap.keySet()){
            if(i<minLevel)
                minLevel = i;
        }

        while (sumMap.containsKey(minLevel)){
            sum.add(sumMap.get(minLevel));
            minLevel++;
        }

        return sum;
    }

    private static void computeVerticalSum(TreeNode root, int level, Map<Integer, Integer> sumMap){
        if(root == null)
            return;

        int levelSum = sumMap.getOrDefault(level, 0) + root.val;
        sumMap.put(level, levelSum);

        computeVerticalSum(root.left, level-1, sumMap);
        computeVerticalSum(root.right, level+1, sumMap);
    }
}
