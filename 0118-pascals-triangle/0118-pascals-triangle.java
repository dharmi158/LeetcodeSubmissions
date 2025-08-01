class Solution {
    public static int nCr(int n, int r){
        int ans = 1;
        for(int i=0;i<r;i++){
            ans  = ans * (n-i);
            ans  = ans / (i+1);
        }
        return ans;
    }
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();

        for(int row=1;row<=numRows; row++){
            List<Integer> tmp =  new ArrayList<>();
            for(int col=1; col<=row;col++){
                tmp.add(nCr(row-1,col-1));
            }
            result.add(tmp);
        }
        return result;
    }
}