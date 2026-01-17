class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        for (int i=0; i<nums.length; i++) {
            minHeap.offer(new int[]{nums[i],i});

            if (minHeap.size() > k) {
                minHeap.poll(); 
            }
        }

        // Store remaining elements
        List<int[]> temp = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            temp.add(minHeap.poll());
        }

        temp.sort((a, b) -> a[1] - b[1]);

        // Extract values
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = temp.get(i)[0];
        }

        return ans;
    }
}