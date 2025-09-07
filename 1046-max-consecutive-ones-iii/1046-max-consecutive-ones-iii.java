class Solution {
    public int longestOnes(int[] nums, int k) {
        int zerosCount = 0, longest = 0;
        int left = 0, n = nums.length;
        for(int right = 0; right < n; right++){
            if(nums[right] == 0) 
                zerosCount++;
            if(zerosCount > k){
                if(nums[left] == 0) 
                    zerosCount--;
                left++;
            }
            longest = Math.max(longest, right - left + 1);
        }
        return longest;
    }
}