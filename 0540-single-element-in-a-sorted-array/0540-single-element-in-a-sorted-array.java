class Solution {
    public int singleNonDuplicate(int[] nums) {
    //    HashMap<Integer, Integer> frequency = new HashMap<>();
        
    //     for (int element : nums) {
    //         frequency.put(element, frequency.getOrDefault(element, 0) + 1);
    //     }
        
    //     for (Map.Entry<Integer, Integer> map : frequency.entrySet()) {
    //         if (map.getValue() == 1) {
    //             return map.getKey();
    //         }
    //     }
    //     return -1;


        // Binary Search TC - O(logn)
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (mid % 2 == 1) {
                mid--;
            }

            if (nums[mid] == nums[mid + 1]) {
                left = mid + 2;
            } else {
                right = mid;
            }
        }

        return nums[left];
    
    }
}