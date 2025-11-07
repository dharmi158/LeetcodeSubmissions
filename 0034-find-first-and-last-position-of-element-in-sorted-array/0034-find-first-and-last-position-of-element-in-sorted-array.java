class Solution {
    private int searchPos(int[] arr, int target, boolean findLastPos) {
        int left = 0;
        int right = arr.length-1;
        int pos = -1;
        while(left<=right) {
            int m = left + (right-left)/2;
            if(arr[m] > target) {
                right = m-1;
            } else if(arr[m] < target) {
                left = m+1;
            } else {
                pos = m;
                if(findLastPos == true) {
                    left = m+1;
                } else {
                    right = m-1;
                }
            }
        }
        return pos;
    }
    public int[] searchRange(int[] nums, int target) {
        int firstPos = searchPos(nums, target, false);
        int lastPos = searchPos(nums, target, true);
        // int count = 0;
        // if(firstPos!= -1 && lastPos!= -1){
        //     count = (lastPos - firstPos) + 1;
        // }
        //System.out.println(count);
        return new int[] {firstPos, lastPos};
    }
}