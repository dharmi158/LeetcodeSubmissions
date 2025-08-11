class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> nums = new HashSet<>();
        Set<Integer> res = new HashSet<>();

        for(int i : nums1)
            nums.add(i);
        for(int i : nums2)
        {
            if(nums.contains(i)){
                res.add(i);
            }
        }
        int[] arr = new int[res.size()];
        int i=0;
        for(int num: res){
            arr[i++] = num;
        }
        return arr;
    }
}