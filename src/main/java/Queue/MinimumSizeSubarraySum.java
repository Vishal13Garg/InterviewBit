package Queue;

public class MinimumSizeSubarraySum {
    public static void main(String[] args) {
        System.out.println(minSubArrayLen(7, new int[]{2, 1, 5, 2, 3, 2}));
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int startIndex = 0;
        int currentSum = 0;
        int minLength = nums.length+1;

        for (int endIndex=0; endIndex < nums.length; endIndex++){
            currentSum += nums[endIndex];

            while (startIndex <= endIndex && currentSum >= target){
                minLength = Math.min(minLength, endIndex-startIndex+1);
                currentSum -= nums[startIndex];
                startIndex++;
            }
        }

        minLength = minLength == nums.length+1 ? 0 : minLength;
        return minLength;
    }
}
