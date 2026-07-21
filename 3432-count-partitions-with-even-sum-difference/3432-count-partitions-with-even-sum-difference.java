class Solution {
    public int countPartitions(int[] nums) {
        int ans = 0;
        int n = nums.length;
        int totalSum = 0;
        int leftSum = 0, rightSum = 0;

        for(int i : nums){
            totalSum += i;
        }
        for(int i=0;i<n-1;i++){
            leftSum += nums[i];
            rightSum = totalSum - leftSum;
            if((leftSum - rightSum)%2 == 0){
                ans++;
            }
        }
        return ans;
    }
}