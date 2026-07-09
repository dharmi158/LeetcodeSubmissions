class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int totalsum = 0;
        // int[] sumLeft = new int[n];
        // int[] sumRight = new int[n];

        int sumLeft = 0;
        for(int val : nums){
            totalsum += val;
        }

        for(int i=0;i<n;i++){
            int sumRight = totalsum - sumLeft - nums[i];
            if(sumRight == sumLeft){
                return i;
            }
            sumLeft += nums[i];
        }
        return -1;
    }
}