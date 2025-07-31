class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        // using binary search 
        int left = 0;
        int right = n-1;
        while(left < right){
            int middle = (left + right )/2;
            if(nums[middle]>nums[middle+1]){
                right = middle;
            }
            else{
                left = middle + 1;
            }
        }
        return left;
    }
}