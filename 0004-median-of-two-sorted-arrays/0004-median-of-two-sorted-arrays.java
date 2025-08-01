class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Brute force - merge two array and then sort it to find median
        int n1 = nums1.length;
        int n2 = nums2.length;
        int[] mergedArray = new int[n1+n2];
        int j = 0;
        for(int i=0;i<n1;i++){
            mergedArray[j++] = nums1[i];
        }
        for(int i=0;i<n2;i++){
            mergedArray[j++] = nums2[i];
        }
        Arrays.sort(mergedArray);
        int n_mergerd = mergedArray.length;
        if(n_mergerd % 2 == 0){
            int mid1 = mergedArray[n_mergerd / 2];
            int mid2 = mergedArray[(n_mergerd / 2)-1];
            return ((double)mid1 + (double)mid2) / 2.0;
        }
        else{
            return (double) mergedArray[n_mergerd / 2];
        }
    }
}