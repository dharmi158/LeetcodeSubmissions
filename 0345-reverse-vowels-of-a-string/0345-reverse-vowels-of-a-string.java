class Solution {
    public String reverseVowels(String s) {
        char[] str = s.toCharArray();
        int start = 0,end = s.length()-1;
        while(start<end){
            while(start<end && !checkVowel(str[start])){
                start++;
            }
            while(start<end && !checkVowel(str[end])){
                end--;
            }

            //swap vowels
            char ch = str[start];
            str[start++] = str[end];
            str[end--] = ch; 
            
        }
        return new String(str);
    }
    public boolean checkVowel(char Char){
        return (Char == 'a' || Char == 'A') 
            || (Char == 'e' || Char == 'E')
            || (Char == 'i' || Char == 'I')
            || (Char == 'o' || Char == 'O')
            || (Char == 'u' || Char == 'U');
    }
}