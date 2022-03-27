package Tree.BinarySearchTree;

public class KthSmallest {
    public int kthsmallest(TreeNode root, int k) {
        MutableInteger index = new MutableInteger(0);
        MutableInteger result = new MutableInteger(0);

        kthsmallestUtil(root, k, index, result);
        return result.value;
    }

    private void kthsmallestUtil(TreeNode root, int k, MutableInteger index, MutableInteger kthElement) {
        if(root == null)
            return;

        kthsmallestUtil(root.left, k, index, kthElement);
        index.increment();

        if(index.value == k){
            kthElement.value = root.val;
            return;
        }

        kthsmallestUtil(root.right, k, index, kthElement);
    }

    static class MutableInteger{
        int value;

        MutableInteger(int value){
            this.value = value;
        }

        private void increment(){
            this.value = this.value+1;
        }
    }
}
