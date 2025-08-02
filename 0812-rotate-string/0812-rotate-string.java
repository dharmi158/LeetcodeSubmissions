class Solution {
    public boolean rotateString(String s, String goal) {
        String s1 = s+s;
        if(s1.contains(goal) && s.length()==goal.length()){
            return true ;
        }
        else{
            return false;
        }
    }
}