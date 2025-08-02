class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while(left < right){
            int middle = (left + right) / 2;
            // left part has lowest value
            if(nums[middle] <= nums[right]){
                right = middle;
            }
            // right part has lowest value
            else{
                left = middle + 1;
            }
        }
        return nums[left];
    }
}