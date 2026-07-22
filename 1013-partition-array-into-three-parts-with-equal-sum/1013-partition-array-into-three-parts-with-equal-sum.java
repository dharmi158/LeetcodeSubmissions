class Solution {
    public boolean canThreePartsEqualSum(int[] arr) {
        int n = arr.length;
        int totalSum = 0;
        int partitionSum = 0;
        int count = 0;
        int sum = 0;
        for(int i: arr){
            totalSum += i;
        }
        partitionSum = totalSum / 3;
        if(totalSum % 3 != 0){
            return false;
        }
        else{
            for(int i=0;i<n;i++){
                sum += arr[i];
                if(sum == partitionSum){
                    count++;
                    sum = 0;
                }
            }
            if(count >= 3){
                return true;
            }
            else{
                return false;
            }
        }
        
    }
}