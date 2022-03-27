package Heap;
import java.util.ArrayList;

public class SlidingWindowMedian {

    public static void main(String[] args) {
        int[] nums = new int[]{2147483647,2147483647};
        double[] result = medianSlidingWindow(nums, 2);

        for (int i=0; i<result.length; i++){
            System.out.print(result[i]+ " ");
        }
    }


    public static double[] medianSlidingWindow(int[] nums, int k) {
        Node[] nodeIndex = new Node[nums.length];
        for (int i=0; i<nums.length; i++){
            nodeIndex[i] = new Node(nums[i]);
        }

        Median median = new Median(nodeIndex);
        double[] result = new double[nums.length-k+1];
        int index=0;

        for (int i=0; i<k-1; i++){
            median.addElement(i);
        }

        for (int i=k-1; i<nums.length; i++){
            median.addElement(i);

            if(i-k >= 0)
                median.removeElement(i-k);

            double currentMedian = median.getMedian();
            result[index] = currentMedian;
            index++;
        }

        return result;
    }

    static class Median{
        private Node[] arrayElements;
        private MinHeap minHeap;
        private MaxHeap maxHeap;

        Median(Node[] arrayElements){
            this.arrayElements = arrayElements;
            minHeap = new MinHeap(arrayElements);
            maxHeap = new MaxHeap(arrayElements);
        }

        private void addElement(int index){
            int value = arrayElements[index].value;

            if(minHeap.size() != 0 && minHeap.peek().value <= value)
                minHeap.add(index, value);
            else
                maxHeap.add(index, value);

            balanceHeaps();
        }

        private void removeElement(int index){
            if(arrayElements[index].minHeapIndex != -1)
                minHeap.removeIndex(index);
            else
                maxHeap.removeIndex(index);

            balanceHeaps();
        }

        private void balanceHeaps(){
            if(minHeap.size() > maxHeap.size()){
                HeapNode top = minHeap.poll();
                maxHeap.add(top.index, top.value);
            }
            else if(maxHeap.size() > minHeap.size() + 1){
                HeapNode top = maxHeap.poll();
                minHeap.add(top.index, top.value);
            }
        }

        private double getMedian(){
            if(maxHeap.size() == minHeap.size()+1){
                return maxHeap.peek().value;
            }
            else{
                long element1 = maxHeap.size() > 0 ? maxHeap.peek().value : 0;
                long element2 = minHeap.size() > 0 ? minHeap.peek().value : 0;

                return (element1+element2)/2.0;
            }
        }
    }

    static class Node{
        private int minHeapIndex;
        private int maxHeapIndex;
        private int value;

        Node(int value){
            this.value = value;
            minHeapIndex = -1;
            maxHeapIndex = -1;
        }
    }

    static class HeapNode{
        private int index;
        private int value;

        HeapNode(int index, int value){
            this.index = index;
            this.value = value;
        }
    }

    static class MinHeap{
        private ArrayList<HeapNode> heap;
        private Node[] nodeIndex;

        MinHeap(Node[] nodeIndex){
            this.nodeIndex = nodeIndex;
            heap = new ArrayList<>();
        }

        private int size(){
            return heap.size();
        }

        private void add(int index, int value){
            HeapNode node = new HeapNode(index, value);
            heap.add(node);
            nodeIndex[index].minHeapIndex = heap.size()-1;
            shiftUp(heap.size()-1);
        }


        private void shiftUp(int heapIndex){
            if(heapIndex == 0)
                return;

            int parentIndex = (heapIndex-1)/2;
            HeapNode parentNode = heap.get(parentIndex);
            HeapNode currentNode = heap.get(heapIndex);


            if(parentNode.value > currentNode.value){
                heap.set(parentIndex, currentNode);
                heap.set(heapIndex, parentNode);

                nodeIndex[currentNode.index].minHeapIndex = parentIndex;
                nodeIndex[parentNode.index].minHeapIndex = heapIndex;

                shiftUp(parentIndex);
            }
        }

        private void shiftDown(int currentIndex){
            if(currentIndex >= heap.size()-1)
                return;

            int leftChild = 2*currentIndex+1;
            int rightChild = 2*currentIndex+2;
            int minIndex = currentIndex;

            if(leftChild < heap.size() && heap.get(leftChild).value < heap.get(minIndex).value)
                minIndex = leftChild;

            if(rightChild < heap.size() && heap.get(rightChild).value < heap.get(minIndex).value)
                minIndex = rightChild;

            if(minIndex != currentIndex){

                HeapNode currentNode = heap.get(currentIndex);
                HeapNode minNode = heap.get(minIndex);

                heap.set(minIndex, currentNode);
                heap.set(currentIndex, minNode);

                nodeIndex[currentNode.index].minHeapIndex = minIndex;
                nodeIndex[minNode.index].minHeapIndex = currentIndex;

                shiftDown(minIndex);
            }
        }

        private void removeIndex(int index){
            int heapIndex = nodeIndex[index].minHeapIndex;
            nodeIndex[index].minHeapIndex = -1;

            if(heapIndex == heap.size()-1){
                heap.remove(heapIndex);
                return;
            }

            HeapNode lastNode = heap.remove(heap.size()-1);
            heap.set(heapIndex, lastNode);

            nodeIndex[lastNode.index].minHeapIndex = heapIndex;
            shiftDown(heapIndex);
        }

        private HeapNode peek(){
            return heap.get(0);
        }

        private HeapNode poll(){
            HeapNode top = heap.get(0);
            nodeIndex[top.index].minHeapIndex = -1;

            if(heap.size() == 1){
                heap.remove(0);
                return top;
            }
            else {
                HeapNode lastNode = heap.remove(heap.size()-1);
                nodeIndex[lastNode.index].minHeapIndex = 0;
                heap.set(0, lastNode);
                shiftDown(0);
                return top;
            }
        }

    }


    static class MaxHeap{
        private ArrayList<HeapNode> heap;
        private Node[] nodeIndex;

        MaxHeap(Node[] nodeIndex){
            this.nodeIndex = nodeIndex;
            heap = new ArrayList<>();
        }

        private int size(){
            return heap.size();
        }

        private void add(int index, int value){
            HeapNode node = new HeapNode(index, value);
            heap.add(node);
            nodeIndex[index].maxHeapIndex = heap.size()-1;
            shiftUp(heap.size()-1);
        }


        private void shiftUp(int heapIndex){
            if(heapIndex == 0)
                return;

            int parentIndex = (heapIndex-1)/2;
            HeapNode parentNode = heap.get(parentIndex);
            HeapNode currentNode = heap.get(heapIndex);


            if(parentNode.value < currentNode.value){
                heap.set(parentIndex, currentNode);
                heap.set(heapIndex, parentNode);

                nodeIndex[currentNode.index].maxHeapIndex = parentIndex;
                nodeIndex[parentNode.index].maxHeapIndex = heapIndex;

                shiftUp(parentIndex);
            }
        }

        private void shiftDown(int currentIndex){
            if(currentIndex >= heap.size()-1)
                return;

            int leftChild = 2*currentIndex+1;
            int rightChild = 2*currentIndex+2;
            int minIndex = currentIndex;

            if(leftChild < heap.size() && heap.get(leftChild).value > heap.get(minIndex).value)
                minIndex = leftChild;

            if(rightChild < heap.size() && heap.get(rightChild).value > heap.get(minIndex).value)
                minIndex = rightChild;

            if(minIndex != currentIndex){

                HeapNode currentNode = heap.get(currentIndex);
                HeapNode minNode = heap.get(minIndex);

                heap.set(minIndex, currentNode);
                heap.set(currentIndex, minNode);

                nodeIndex[currentNode.index].maxHeapIndex = minIndex;
                nodeIndex[minNode.index].maxHeapIndex = currentIndex;

                shiftDown(minIndex);
            }
        }

        private void removeIndex(int index){
            int heapIndex = nodeIndex[index].maxHeapIndex;
            nodeIndex[index].maxHeapIndex = -1;

            if(heapIndex == heap.size()-1){
                heap.remove(heapIndex);
                return;
            }

            HeapNode lastNode = heap.remove(heap.size()-1);
            heap.set(heapIndex, lastNode);

            nodeIndex[lastNode.index].maxHeapIndex = heapIndex;
            shiftDown(heapIndex);
        }

        private HeapNode peek(){
            return heap.get(0);
        }

        private HeapNode poll(){
            HeapNode top = heap.get(0);
            nodeIndex[top.index].maxHeapIndex = -1;

            if(heap.size() == 1){
                heap.remove(0);
                return top;
            }
            else {
                HeapNode lastNode = heap.remove(heap.size()-1);
                nodeIndex[lastNode.index].maxHeapIndex = 0;
                heap.set(0, lastNode);
                shiftDown(0);
                return top;
            }
        }

    }
}
