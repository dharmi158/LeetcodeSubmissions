class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Brute force - merge two array and then sort it to find median
        // int n1 = nums1.length;
        // int n2 = nums2.length;
        // int[] mergedArray = new int[n1+n2];
        // int j = 0;
        // for(int i=0;i<n1;i++){
        //     mergedArray[j++] = nums1[i];
        // }
        // for(int i=0;i<n2;i++){
        //     mergedArray[j++] = nums2[i];
        // }
        // Arrays.sort(mergedArray);
        // int n_mergerd = mergedArray.length;
        // if(n_mergerd % 2 == 0){
        //     int mid1 = mergedArray[n_mergerd / 2];
        //     int mid2 = mergedArray[(n_mergerd / 2)-1];
        //     return ((double)mid1 + (double)mid2) / 2.0;
        // }
        // else{
        //     return (double) mergedArray[n_mergerd / 2];
        // }



        // Two pointer approach - merge with two pointer and find median
        // List<Integer> mergedArray = new ArrayList<>();
        // int i=0,j=0;
        // while(i<nums1.length && j<nums2.length){
        //     if(nums1[i]<nums2[j]){
        //         mergedArray.add(nums1[i]);
        //         i++;
        //     }
        //     else{
        //         mergedArray.add(nums2[j]);
        //         j++;
        //     }
        // }
        // while(i<nums1.length){
        //     mergedArray.add(nums1[i]);
        //     i++;
        // }
        // while(j<nums2.length){
        //     mergedArray.add(nums2[j]);
        //     j++;
        // }
        // int mid = mergedArray.size()/2;
        // if(mergedArray.size() % 2 == 0){
        //     return (mergedArray.get(mid-1) + mergedArray.get(mid)) / 2.0;
        // }
        // else{
        //     return mergedArray.get(mid);
        // }


        // Binary search approach - make partition
        int l1 = nums1.length;
        int l2 = nums2.length;
        if(l1>l2){
            return findMedianSortedArrays(nums2, nums1);
        }
        int left = 0, right = l1;
        while(left <= right){
            int part1 = (left + right) / 2;
            int part2 = (l1+l2+1)/2 - part1;

            int maxLeft1=0,minRight1=0,maxLeft2=0,minRight2=0;
            if(part1 == 0){
                maxLeft1 = Integer.MIN_VALUE;
            }
            else{
                maxLeft1 = nums1[part1-1];
            }
            if(part1 == l1){
                minRight1 =  Integer.MAX_VALUE;
            }
            else{
                minRight1 = nums1[part1];
            }

            if(part2 == 0){
                maxLeft2 = Integer.MIN_VALUE;
            }
            else{
                maxLeft2 = nums2[part2-1];
            }
            if(part2 == l2){
                minRight2 =  Integer.MAX_VALUE;
            }
            else{
                minRight2 = nums2[part2];
            }

            if(maxLeft1<= minRight2 && maxLeft2<=minRight1){
                //even
                if((l1+l2)%2 ==0){
                    return (Math.max(maxLeft1, maxLeft2) + Math.min(minRight1, minRight2)) / 2.0;
                }
                //odc
                else{
                    return (double) Math.max(maxLeft1, maxLeft2);
                }
            }
            else if(maxLeft1 > minRight2){
                right = part1-1;
            }
            else{
                left = part1+1;
            }
        }
        return 0.0;
    }
}