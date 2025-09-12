class Solution {
    // Merge the adjacent pair with minimum sum and return new size (n-1)
    private int operation(int[] nums, int n) {
        if (n < 2) return n;
        int minIndex = 0;
        int minSum = nums[0] + nums[1];

        for (int i = 1; i < n - 1; i++) {
            int s = nums[i] + nums[i + 1];
            if (s < minSum) {
                minSum = s;
                minIndex = i;
            }
        }

        // replace first element of pair by sum and shift left
        nums[minIndex] = minSum;
        for (int i = minIndex + 1; i < n - 1; i++) {
            nums[i] = nums[i + 1];
        }
        // optional: clear last slot (not required logically, but helps debugging)
        nums[n - 1] = 0;

        return n - 1;
    }

    // check if first n elements are non-decreasing
    private boolean isNonDecreasing(int[] nums, int n) {
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] > nums[i + 1]) return false;
        }
        return true;
    }

    public int minimumPairRemoval(int[] nums) {
        int n = nums.length;
        if (n < 2) return 0;

        int count = 0;
        // repeat merging the globally minimum-sum adjacent pair
        // until the array (first n elements) becomes non-decreasing
        while (!isNonDecreasing(nums, n)) {
            n = operation(nums, n);
            count++;
        }
        return count;
    }
}
