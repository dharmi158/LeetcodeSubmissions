class Solution {
    public boolean search(int[] nums, int target) {
        int left =0,right = nums.length -1;
        while(left<=right){
            int middle = (left+right)/2;
            if(nums[middle] == target){
                return true;
            }
            //condition for duplicates
            if(nums[middle] == nums[left]){
                left++;
                continue;
            }
            // Target is between L AND M - this is in ascending order
            else if(nums[middle] >= nums[left]){
                //checking if target is present in this part
                if(nums[left] <= target && target <= nums[middle]){
                    right = middle - 1;
                }
                // move to another part of array
                else{
                    left = middle + 1;
                }
            }
            // target is between M AND R - this is in ascending order
            else{
                //checking if target is present in this part
                if(nums[middle] <= target && target <= nums[right]){
                    left = middle + 1;
                }
                //move to another part of array
                else{
                    right = middle - 1;
                }
            }
        }
        return false;
    }
}