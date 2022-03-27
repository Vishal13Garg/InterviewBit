package Tree.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class PopulateNextRightPointersTree {
    public void connect(TreeLinkNode root) {
        if(root == null)
            return;

        Queue<TreeLinkNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i=0; i<size; i++){
                TreeLinkNode current = queue.remove();
                if(i < size-1)
                    current.next = queue.peek();

                if(current.left != null)
                    queue.add(current.left);

                if(current.right != null)
                    queue.add(current.right);
            }
        }
    }




    public class TreeLinkNode {
      int val;
      TreeLinkNode left, right, next;
      TreeLinkNode(int x) { val = x; }
    }
}
