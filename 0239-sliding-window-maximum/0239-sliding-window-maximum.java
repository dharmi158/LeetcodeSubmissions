class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        //Brute Force approach
        // assume nums is not null
        // int n = nums.length;
        // if (n == 0 || k == 0) {
        //     return new int[0];
        // }
  
        // int numOfWindow = n - k + 1;
        // int[] result = new int[numOfWindow]; // number of windows
    
        // for (int i = 0; i < numOfWindow; i++) 
        // {
        //     int end = i + k - 1;
        //     int maxVal = nums[i];
        //     for (int j = i + 1; j <= end; j++) 
        //     {
        //         if (nums[j] > maxVal) 
        //         { 
        //             maxVal = nums[j];
        //         }
        //     }
        //     result[i] = maxVal;
        // }
        // return result;

        //sliding window using monotonic deque 
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> dq = new LinkedList<>();
        
        for (int i = 0; i < nums.length; i++) {
            // Remove indices out of current window if windowSize exeeds 
            while (!dq.isEmpty() && dq.peekFirst() <= i - k)
                dq.removeFirst();
            
            // Remove smaller values
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i])
                dq.removeLast();
            
            dq.addLast(i);
            
            if (i >= k - 1)
                res[i - k + 1] = nums[dq.peekFirst()];
        }
        
        return res;
    }
}