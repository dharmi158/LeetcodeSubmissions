class Solution {
    public int pivotInteger(int n) {
        int totalsum = n * (n+1) / 2;
        double sqtotalsum = Math.sqrt(totalsum);
        if(sqtotalsum - Math.ceil(sqtotalsum) == 0)
            return (int)sqtotalsum;
        else
            return -1;
    }
}