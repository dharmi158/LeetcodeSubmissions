class Solution {
    public int countGoodSubstrings(String s) {
        if(s.length()<3){
            return 0;
        }
        int count = 0;
        for(int i=0;i<=s.length()-3;i++){
            Set<Character> set = new HashSet<>();
            String subStr = s.substring(i,i+3);

            for(char ch: subStr.toCharArray()){
                set.add(ch);
            }
            if(set.size() == 3){
                count++;
            }
        }
        return count;
    }
}