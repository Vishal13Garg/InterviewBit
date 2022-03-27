package Tree.BinaryTree;

import Tree.BinarySearchTree.TreeNode;

import java.util.*;

public class VerticalOrderTraversalOfBinaryTree {

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

        ArrayList<ArrayList<Integer>> traversal = verticalOrderTraversal(root);
        System.out.println(traversal);
    }

    public static ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if(root == null)
            return result;

        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        Deque<TreeLevel> deque = new LinkedList<>();
        deque.addLast(new TreeLevel(root, 0));

        while (!deque.isEmpty()){
            TreeLevel current = deque.removeFirst();

            if(current.node.left != null)
                deque.addLast(new TreeLevel(current.node.left, current.level-1));

            if(current.node.right != null)
                deque.addLast(new TreeLevel(current.node.right, current.level+1));

            if(map.containsKey(current.level))
                map.get(current.level).add(current.node.val);
            else
                map.put(current.level, new ArrayList<>(Arrays.asList(current.node.val)));
        }

        int minLevel = Integer.MAX_VALUE;
        for (int key : map.keySet()){
            if(key < minLevel)
                minLevel = key;
        }


        while (map.containsKey(minLevel)){
            result.add(map.get(minLevel));
            minLevel++;
        }

        return result;
    }

    static class TreeLevel{
        TreeNode node;
        Integer level;

        TreeLevel(TreeNode node, Integer level){
            this.node = node;
            this.level = level;
        }
    }
}
