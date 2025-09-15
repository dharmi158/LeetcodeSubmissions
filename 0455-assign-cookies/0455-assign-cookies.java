class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int childrenNums = g.length;
        int cookieNums = s.length;

        if(cookieNums == 0)
            return 0;
        
        int maxNums = 0;
        int cookieIndex = cookieNums - 1;
        int childIndex = childrenNums - 1;

        while(cookieIndex>= 0 && childIndex>=0){
            if(s[cookieIndex] >= g[childIndex]){
                maxNums++;
                cookieIndex--;
                childIndex--;
            }
            else{
                childIndex--;
            }
        }
        return maxNums;
    }
}