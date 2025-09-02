class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int[] count = new int[n + 1]; // counts from 1 to n
        int[] result = new int[2];

        for (int num : nums) {
            count[num]++;
        }

        for (int i = 1; i <= n; i++) {
            if (count[i] == 2) {
                result[0] = i; // duplicate
            } else if (count[i] == 0) {
                result[1] = i; // missing
            }
        }

        return result;
    }
}