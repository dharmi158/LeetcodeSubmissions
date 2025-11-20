class Solution {
    //TC - O(n · log(max bloomDay)) , SC - O(1)
    public int minDays(int[] bloomDay, int m, int k) {
        int low = 1;
        int high = 0;

        if ((long)m * k > bloomDay.length) 
            return -1;

        for(int day : bloomDay){
            high = Math.max(day,high);
        }

        while(low < high){
            int mid = low + (high - low)/2;

            if(canMake(bloomDay,m,k,mid)){
                high = mid;
            }
            else{
                low = mid + 1;
            }
        }
        return low;
    }
    private boolean canMake(int[] arr,int m,int k,int mid){
        int bouquets = 0;
        int consecutive = 0;
        for(int a: arr){
            if(a<=mid){
                consecutive++;
                if(consecutive == k){
                    bouquets++;
                    consecutive = 0;
                }
            }
            else{
                consecutive = 0;
            }
        }
        return bouquets >= m;
    }
}