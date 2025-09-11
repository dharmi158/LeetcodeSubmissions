class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int windowSize = n-k;
        int total = 0;
        //calculate total sum
        for(int x : cardPoints){
            total += x;
        }

        //calculate sum of first k element
        int currSum = 0;
        for(int i=0; i<windowSize ; i++){
            currSum += cardPoints[i];
        }

        int minSum = currSum;

        //slide the window
        for(int i=windowSize;i<n;i++){
            currSum += cardPoints[i]; // add rightmost element
            currSum -= cardPoints[i - windowSize]; //remove leftmost element
            minSum = Math.min(minSum,currSum);
        }

        return total-minSum; //maximumSum(ans)= total - minimumSum
    }
}