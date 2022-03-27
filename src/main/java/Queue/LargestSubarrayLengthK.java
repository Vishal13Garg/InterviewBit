package Queue;

public class LargestSubarrayLengthK {

    public static void main(String[] args) {
        int[] result = largestSubarray(new int[]{1,4,5,2,3}, 4);
        for (int i:result)
            System.out.print(i + " ");
    }

    public static int[] largestSubarray(int[] nums, int k) {
        if(nums == null || nums.length < k)
            return nums;

        int largestIndex=0;
        for (int i=0; i<=nums.length-k; i++){
            if(nums[i] > nums[largestIndex])
                largestIndex = i;
        }

        int[] result = new int[k];
        for (int i=0; i<k; i++)
            result[i] = nums[i+largestIndex];

        return result;
    }
}
