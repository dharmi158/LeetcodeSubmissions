class Solution {
    public boolean isNiceString(String str){
        // create set to store unique characters in the substring
        Set<Character> strSet = new HashSet<>();

        for(char ch : str.toCharArray()){
            strSet.add(ch);
        }

        // check if every character has both uppercase and lowercase present
        for(char ch : strSet){
            if(!strSet.contains(Character.toUpperCase(ch)) || !strSet.contains(Character.toLowerCase(ch))){
                return false;
            }
        }
        return true;
    }
    public String longestNiceSubstring(String s) {
        int maxLen = 0;
        String res = "";

        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String subStr = s.substring(i, j);

                if (isNiceString(subStr) && subStr.length() > maxLen) {
                    maxLen = subStr.length();
                    res = subStr;
                }
            }
        }
        return res;
    }
}