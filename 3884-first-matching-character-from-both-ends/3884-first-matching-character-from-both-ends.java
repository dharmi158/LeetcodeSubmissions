class Solution {
    public int firstMatchingIndex(String s) {
        int start = 0;
        int end = s.length()-1;

        while(start <= end){
            if(s.charAt(start) == s.charAt(end)){
                return start;
            }
            start++;
            end--;
        }
        return -1;
    }
}