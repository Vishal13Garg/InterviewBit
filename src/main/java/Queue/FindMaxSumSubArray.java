package Queue;

public class FindMaxSumSubArray {
    public static int findMaxSumSubArray(int k, int[] arr) {
        int currentSum = 0;
        int maximumSum = 0;

        for(int i=0; i<k; i++)
            currentSum += arr[i];

        maximumSum = currentSum;

        for(int i=k; i<arr.length; i++){
            currentSum += arr[i];
            currentSum -= arr[i-k];

            maximumSum = Math.max(currentSum, maximumSum);
        }

        return maximumSum;
    }
}
