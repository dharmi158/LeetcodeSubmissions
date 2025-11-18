class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        //Brute force - TC. - O(N logN) , SC - O(k)
        // List<int[]> list = new ArrayList<>();

        // // 1. Store diff + value
        // for (int num : arr) {
        //     list.add(new int[]{Math.abs(num - x), num});
        // }

        // // 2. Sort by diff first, then by number
        // Collections.sort(list, (a, b) -> {
        //     if (a[0] == b[0]) return a[1] - b[1]; // tie → smaller element first
        //     return a[0] - b[0];
        // });

        // // 3. Pick first k closest numbers
        // List<Integer> result = new ArrayList<>();
        // for (int i = 0; i < k; i++) {
        //     result.add(list.get(i)[1]);
        // }

        // // 4. Sort final answer
        // Collections.sort(result);
        // return result;

        //Two pointer approach -  TC - O(N)  , SC - O(k)
        // List<Integer> result = new ArrayList<>();
        // int left = 0;
        // int right = arr.length - 1;

        // while(right - left + 1 > k){
        //     if(Math.abs(arr[left] - x) > Math.abs(arr[right] - x)){
        //         left++;
        //     }
        //     else{
        //         right--;
        //     }
        // }

        // for(int i=left; i<=right; i++){
        //     result.add(arr[i]);
        // }
        // return result;

        //Binary Search Approach TC- O(logN) SC- O(k)
        List<Integer> result = new ArrayList<>();
        int left = 0;
        int right = arr.length - k;

        while(left < right){
            int mid = left + (right - left) / 2;
            if(x - arr[mid] > arr[mid+k] - x){
                left  = mid +1;
            }
            else{
                right = mid;
            }
        }

        for(int i=left; i<left+k; i++){
            result.add(arr[i]);
        }
        return result;
    }
}