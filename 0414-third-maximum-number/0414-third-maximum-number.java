class Solution {
    public int thirdMax(int[] nums) {
        Set<Integer> set=new HashSet<>();
        for(int n:nums){
            set.add(n);
        }
        if (set.size() < 3) {
            return Collections.max(set);
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : set) {
            minHeap.offer(num);

            if (minHeap.size() > 3) {
                minHeap.poll(); // remove smallest
            }
        }

        return minHeap.peek(); // k-th largest
    }
}