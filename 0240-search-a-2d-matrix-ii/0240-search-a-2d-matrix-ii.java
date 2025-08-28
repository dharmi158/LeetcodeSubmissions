class Solution {
    //public static boolean binarySearch(int[] matrix, int target){

        // Naive Solution  - TC - O(N * M), SC- O(1)
        // int n = matrix.length;
        // int m = matrix[0].length;
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<m;j++){
        //         if(matrix[i][j]== target){
        //             return true;
        //         }
        //     }
        // }
        // return false;

        //Optimal Solution TC - O(N * logM), SC - O(1)
        // int n = matrix.length;
        // int left =0, right = n-1;
        // while(left<=right){
        //     int mid = (left + right)/2;
        //     if(matrix[mid] == target){
        //         return true;
        //     }
        //     if(matrix[mid]<target){
        //         left = mid+1;
        //     }
        //     else{
        //         right = mid-1;
        //     }
        // }
        // return false;
    //}
    public boolean searchMatrix(int[][] matrix, int target) {
        // int n = matrix.length;
        // int m = matrix[0].length;
        // for(int i=0;i<n;i++){
        //     boolean ans =  binarySearch(matrix[i],target);
        //     if (ans == true)
        //         return true;
        // }
        // return false;


        //2nd Optimal Solution  TC - O(N + M), SC - O(1) - efficient code
        // int row = 0;
        // int col = matrix[0].length - 1;

        // while (row < matrix.length && col >= 0) {
        //     if (matrix[row][col] == target) {
        //         return true;
        //     } else if (matrix[row][col] > target) {
        //         col--; // Move left
        //     } else {
        //         row++; // Move down
        //     }
        // }
        // return false;

        //                       OR
        int n = matrix.length;
        int m = matrix[0].length;
        int row = n - 1;
        int col = 0;
        while(row >= 0 && col<m)
        {
            if (matrix[row][col] == target) 
            {
                return true;
            } 
            else if (matrix[row][col] > target) {
                row--; // Move up
            } 
            else 
            {
                col++; // Move right
            }
        }
        return false;
    }
}