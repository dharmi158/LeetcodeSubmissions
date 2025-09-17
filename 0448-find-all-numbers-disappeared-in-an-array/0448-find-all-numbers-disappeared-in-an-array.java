//TC - O(n)
//SC - O(n)
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ans  = new ArrayList<Integer>();
        HashSet<Integer> hashSet = new HashSet<Integer>();
        int n = nums.length;
        
        for (int i = 0; i < n; i++) {
            hashSet.add(nums[i]);
        }
        
        for (int i = 1; i <= n; i++) {
            if (!hashSet.contains(i)) {
                ans.add(i);
            }
        }
        
        return ans;
    }
}