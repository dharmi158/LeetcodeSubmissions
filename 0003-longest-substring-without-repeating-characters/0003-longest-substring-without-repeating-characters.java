class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> charactersOfString = new HashSet<>();
        int left = 0, right = 0, maxLen = 0;

        while (right < s.length()) {
            if (!charactersOfString.contains(s.charAt(right))) {
                charactersOfString.add(s.charAt(right));
                maxLen = Math.max(maxLen, right - left + 1);
                right++;
            } else {
                charactersOfString.remove(s.charAt(left));
                left++;
            }
        }

        return maxLen;
    }
}