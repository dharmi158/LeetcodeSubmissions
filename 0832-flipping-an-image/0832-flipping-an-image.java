class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        int r=image.length,c=image[0].length;
        int[][] a=new int[r][c];
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                a[i][j]=image[i][c-j-1];
            }
        }
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
               if(a[i][j]==1){
                a[i][j]=0;
               } 
               else{
                a[i][j]=1;
               }
            }
        }
        return a;
    }
}