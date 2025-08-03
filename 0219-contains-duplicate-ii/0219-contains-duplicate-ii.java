class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> mp = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int val = nums[i];
            if(mp.containsKey(val) && i-mp.get(val) <= k){
                return true;
            }
            mp.put(val,i);
        }
        return false;
    }
}