package Tree.BinaryTree;

import Tree.BinarySearchTree.TreeNode;

public class FlattenBinaryTreeToLinkedList {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);

        root.right.right = new TreeNode(6);

        TreeNode list = flatten(root);
        System.out.println(list.val);
    }

    public static TreeNode flatten(TreeNode root) {
        if(root == null)
            return root;

        ListMetaData list = flattenListUtil(root);
        return list.first;
    }


    private static ListMetaData flattenListUtil(TreeNode root){
        if(root == null)
            return null;

        ListMetaData left = flattenListUtil(root.left);
        ListMetaData right = flattenListUtil(root.right);

        TreeNode first = root;
        TreeNode last = root;
        root.left = null;

        if(left != null){
            first.right = left.first;
            last = left.last;
        }

        if(right != null){
            last.right = right.first;
            last = right.last;
        }

        return new ListMetaData(first, last);
    }

    private static class ListMetaData{
        TreeNode first;
        TreeNode last;

        ListMetaData(TreeNode first, TreeNode last){
            this.first = first;
            this.last = last;
        }
    }
}
