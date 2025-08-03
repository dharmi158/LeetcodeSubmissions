class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> range = new ArrayList<>();
        int l = nums.length;

        for(int i=0;i<l;i++){
            int start = nums[i];
            while(i+1<l && (nums[i]+1 == nums[i+1])){
                i++;
            }
            if(start!=nums[i]){
                range.add(start + "->" + nums[i]);
            }
            else{
                range.add(start + "");
            }
        }
        return range;
    }
}