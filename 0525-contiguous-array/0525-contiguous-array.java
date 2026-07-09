class Solution {
    public int findMaxLength(int[] nums) {
        int maxLen = 0;
        int n = nums.length;

        // Brute force O(N^2), SC- O(1)
        // for(int i=0;i<n;i++){
        //     int zeroes=0, ones=0;
        //     for(int j=i;j<n;j++){
        //         if(nums[j]==0){
        //             zeroes++;
        //         }
        //         else{
        //             ones++;
        //         }
        //         if(zeroes == ones){
        //             maxLen = Math.max(maxLen,j-i+1);
        //         }
        //     }
        // }
        // return maxLen;

        //prefix sum TC - O(N), SC O(1)
        Map<Integer, Integer> mp = new HashMap<>();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i] == 0 ? -1 : 1;
            if (sum == 0) {
                maxLen = i + 1;
            } else if (mp.containsKey(sum)) {
                maxLen = Math.max(maxLen, i - mp.get(sum));
            } else {
                mp.put(sum, i);
            }
        }
        return maxLen;
    }
}