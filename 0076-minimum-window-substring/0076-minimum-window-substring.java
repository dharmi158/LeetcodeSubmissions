class Solution {
    public String minWindow(String s, String t) {
        int minLen = Integer.MAX_VALUE;
        int left = 0, start = -1;
        int count = 0;
        int n = s.length(), m = t.length();
        if (s == null || t == null || n < m) {
            return "";
        }
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : t.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for(int right=0;right<n;right++){
            char ch = s.charAt(right);
            if(map.containsKey(ch)){
                if(map.get(ch)>0){
                    count++;
                }
                map.put(ch, map.get(ch) - 1);
            }

            while (count == m) {
                // Update result
                if (minLen > right - left + 1) {
                    minLen = right - left + 1;
                    start = left;
                }
                
                char leftChar = s.charAt(left);
                if (map.containsKey(leftChar)) {
                    map.put(leftChar, map.get(leftChar) + 1);
                    // Check if this character is now missing
                    if (map.get(leftChar) > 0) {
                        count--;
                    }
                }
                left++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}