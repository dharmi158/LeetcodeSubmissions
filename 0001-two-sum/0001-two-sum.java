class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            
            // Check if complement exists in the map
            if (map.containsKey(complement)) {
                result[0] = i;
                result[1] = map.get(complement);
                return result;
            }
            
            // Store the index of the current number
            map.put(nums[i], i);
        }
        return result;
    }
}