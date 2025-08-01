class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Two pointer approach - merge with two pointer and find median
        List<Integer> mergedArray = new ArrayList<>();
        int i=0,j=0;
        while(i<nums1.length && j<nums2.length){
            if(nums1[i]<nums2[j]){
                mergedArray.add(nums1[i]);
                i++;
            }
            else{
                mergedArray.add(nums2[j]);
                j++;
            }
        }
        while(i<nums1.length){
            mergedArray.add(nums1[i]);
            i++;
        }
        while(j<nums2.length){
            mergedArray.add(nums2[j]);
            j++;
        }
        int mid = mergedArray.size()/2;
        if(mergedArray.size() % 2 == 0){
            return (mergedArray.get(mid-1) + mergedArray.get(mid)) / 2.0;
        }
        else{
            return mergedArray.get(mid);
        }
    }
}