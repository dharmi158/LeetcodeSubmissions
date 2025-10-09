class Solution {
    public int minimumCost(int[] cost) {
        int n = cost.length;
        int sum = 0;
        Arrays.sort(cost);
        if(n == 1) 
            return cost[0];
        for(int i= n-1;i>=0 ; i-=3){
            if(i == 0) 
                sum += cost[0];
            else 
                sum += cost[i] + cost[i - 1];
        }
        return sum;
    }
}