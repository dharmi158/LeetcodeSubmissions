class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int ans = 0;

        //TC - o(N) , SC - o(N)
        // int[] leftMax = new int[n];
        // int[] rightMax = new int[n];
        // leftMax[0] = height[0];
        // rightMax[n-1] = height[n-1];

        // for(int i=1;i<n;i++){
        //     leftMax[i] = Math.max(leftMax[i-1],height[i]);
        // }
        // for(int i=n-2;i>=0;i--){
        //     rightMax[i] = Math.max(rightMax[i+1],height[i]);
        // }
        // for(int i=0;i<n;i++){
        //     ans+= Math.min(leftMax[i],rightMax[i]) - height[i];
        // }
        // return ans;

        //Two pointer approach  TC - o(N) , SC - o(1)
        int leftMax = 0,rightMax = 0;
        int l = 0,r= n-1;
        while(l<r){
            leftMax = Math.max(leftMax,height[l]);
            rightMax = Math.max(rightMax,height[r]);

            if(leftMax < rightMax){
                ans += leftMax - height[l];
                l++;
            }
            else{
                ans += rightMax - height[r];
                r--;
            }
        }
        return ans;
    }
}