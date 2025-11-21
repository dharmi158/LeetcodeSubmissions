class Solution {
    public int splitArray(int[] nums, int k) {
        int max = 0;
        int sum = 0;
        for (int num : nums) {
            max = Math.max(max, num);
            sum += num;
        }

        int low = max;
        int high = sum;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (canSplit(nums, mid, k)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private boolean canSplit(int[] nums, int maxAllowed, int m) {
        int currentSum = 0;
        int subarraysFormed = 1;

        for (int num : nums) {
            if (currentSum + num > maxAllowed) {
                subarraysFormed++;
                currentSum = num;
            } else {
                currentSum += num;
            }
        }

        return subarraysFormed <= m;
    }
}