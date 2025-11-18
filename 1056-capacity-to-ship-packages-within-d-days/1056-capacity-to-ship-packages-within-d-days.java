class Solution {
    // Binary Search - TC-o(N log(sum(weight))) , SC - O(1)
    public int shipWithinDays(int[] weights, int days) {
        int low  = 0;
        int high = 0;

        for(int w:weights){
            low = Math.max(low,w); // max package weight
            high +=w; // sum of all weights
        }

        //Brute force - TC- O(N^2) , SC- O(1)
        // for (int i = low; i <= high; i++) {
        //     if (daysNeeded(weights, i) <= days) {
        //         return i;
        //     }
        // }
        // return -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int needed = daysNeeded(weights, mid);

            if (needed <= days) { //If a capacity mid requires less days than allowed
                high = mid - 1;
            } else { //If a capacity mid requires more days than allowed
                low = mid + 1; 
            }
        }
        return low; // smallest valid capacity
    }

    private int daysNeeded(int[] weights, int cap) {
        int currentWeight = 0;
        int totalDays = 1; // at least one day needed

        for (int w : weights) {
            if (currentWeight + w > cap) {
                totalDays++;
                currentWeight = w; 
            } else {
                currentWeight += w;
            }
        }
        return totalDays;
    }
}