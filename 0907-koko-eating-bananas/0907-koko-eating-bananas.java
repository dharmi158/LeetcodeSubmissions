class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;

        for(int p : piles){
            max = Math.max(p,max);
        }

        int low = 1, high = max;

        while(low < high){
            int mid = low + (high - low) / 2;
            if(canEat(piles, mid, h)){
                high = mid;
            }
            else{
                low = mid + 1;
            }
        }
        return low;
    }
    private boolean canEat(int[] piles, int speed, int h){
        int hours  = 0;
        for(int p:piles){
            hours += (int) Math.ceil( p * 1.0 / speed);
        }
        return hours <= h;
    }
}