class Solution {
    public int strStr(String haystack, String needle) {
        int H = haystack.length();
        int N = needle.length();

        if (N == 0) return 0; 

        for (int i = 0; i <= H - N; i++) {
            int j = 0;
            while (j < N && haystack.charAt(i + j) == needle.charAt(j)) {
                j++;
            }
            if (j == N) 
                return i; 
        }

        return -1; 
    }
}