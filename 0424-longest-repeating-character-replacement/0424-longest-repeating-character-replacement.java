class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length(), l=0, maxF = Integer.MIN_VALUE, ans = 0;
        int[] freq = new int[26];
        for(int r=0;r<n;r++){
            freq[s.charAt(r) - 'A']++;
            maxF = Math.max(maxF, freq[s.charAt(r) - 'A']);
            int numC = (r-l+1) - maxF;
            if(numC > k){
                freq[s.charAt(l) - 'A']--;
                l++;
            }
            if(numC <= k){
                ans = Math.max(r-l+1, ans);
            }
        }
        return ans;
    }
}