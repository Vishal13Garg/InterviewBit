package Queue;

public class MaxConsecutiveOnesIII {

    public static void main(String[] args) {
        System.out.println(longestOnes(new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1}, 3));
    }

    public static int longestOnes(int[] nums, int k) {
        int zero=0;
        int maxCount=0;

        int startIndex=0;
        for (int endIndex=0; endIndex<nums.length; endIndex++){
            if(nums[endIndex] == 0)
                zero++;

            while (zero > k){
                if(nums[startIndex] == 0)
                    zero--;
                startIndex++;
            }

            maxCount = Math.max(maxCount, endIndex-startIndex+1);
        }
        return maxCount;
    }
}
