class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return subArrayWithLessOrEqualToSum(nums, goal) - subArrayWithLessOrEqualToSum(nums, goal - 1);
    }

     // TC: O(2N), SC: O(1)
    public int subArrayWithLessOrEqualToSum(int[] nums, int goal){
        if(goal < 0) return 0;
        int left = 0, sum = 0, cnt = 0;
        for(int right = 0; right < nums.length; right++){
            sum += nums[right]; // Add to the initial sum.

            while(sum > goal){
                // Shrink window till the sum is less than or equal to goal.
                sum -= nums[left];
                left++;
            }

            cnt += (right - left + 1); // Cnt gives us number of subarrays for each iteration
        }

        return cnt;
    }
}