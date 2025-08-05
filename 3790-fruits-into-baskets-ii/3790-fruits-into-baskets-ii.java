class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int l1 = fruits.length;
        int l2 = baskets.length;

        int placed = 0;

        for(int i=0;i<l1;i++){
            for(int j=0;j<l1;j++){
                if(baskets[j] >= fruits[i]){
                    placed++;
                    baskets[j] = -1;
                    break;
                }
            }
        }
        return l1-placed;
    }
}