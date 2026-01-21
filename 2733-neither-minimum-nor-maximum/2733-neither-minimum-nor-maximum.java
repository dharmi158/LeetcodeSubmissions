class Solution {
    public int findNonMinOrMax(int[] nums) {
        if(nums.length<=2) return -1;

        int max=Integer.MIN_VALUE,min= Integer.MAX_VALUE;

        for(int i=0; i<nums.length; ++i){
            if(nums[i]> max) max= nums[i];
            if(nums[i]<min) min= nums[i];
        }

        for(int i=0; i<nums.length; ++i){
            if(nums[i]!= max && nums[i] != min) return nums[i];
        }
        return -1;
    }
}