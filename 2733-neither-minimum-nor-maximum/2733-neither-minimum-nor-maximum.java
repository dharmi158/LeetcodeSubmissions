class Solution {
    public int findNonMinOrMax(int[] nums) {
        if(nums.length<=2) return -1;
        
        // TC - O(N) , SC - O(1) - using min max scan 
        int max=Integer.MIN_VALUE,min= Integer.MAX_VALUE;

        for(int i=0; i<nums.length; ++i){
            if(nums[i]> max) max= nums[i];
            if(nums[i]<min) min= nums[i];
        }

        for(int i=0; i<nums.length; ++i){
            if(nums[i]!= max && nums[i] != min) return nums[i];
        }
        return -1;


        // TC - O(N logN) , SC - O(N) - using priority queue
        // else {
        //     PriorityQueue<Integer> pq = new PriorityQueue<>();
        //     for(int x : nums) {
        //         pq.add(x);
        //     }
        //     pq.poll();
        //     return pq.peek();
        // }
    }
}