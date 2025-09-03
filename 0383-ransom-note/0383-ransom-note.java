class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] count = new int[26]; 
        for (char ch : magazine.toCharArray()) {
            count[ch - 'a']++;
        }
        for(char ch2 : ransomNote.toCharArray()){
            if(count[ch2 - 'a'] == 0){
                return false;
            }
            else{
                count[ch2 - 'a']--;
            }
        }
        return true;
    }
}