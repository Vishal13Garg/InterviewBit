package Queue;

public class AverageOfSubarrayOfSizeK {

    public static void main(String[] args) {
        System.out.println(findMaxAverage(new int[]{-1}, 1));
    }

    public static double findMaxAverage(int[] nums, int k) {
        double currentSum = 0;
        double maximumSum = 0;

        for(int i=0; i<k; i++)
            currentSum += nums[i];

        maximumSum = currentSum;

        for(int i=k; i<nums.length; i++){
            currentSum += nums[i];
            currentSum -= nums[i-k];

            maximumSum = Math.max(currentSum, maximumSum);
        }

        return maximumSum/k;
    }
}
