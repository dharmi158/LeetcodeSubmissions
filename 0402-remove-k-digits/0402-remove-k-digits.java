class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> st = new Stack<>();

        for(char digit : num.toCharArray()){
            while(!st.isEmpty() && k>0 && st.peek()>digit){
                st.pop();
                k--;
            }
            st.push(digit);
        }
        
        // Remove remaining k digits from the end of the stack
        while(k>0 && !st.isEmpty()){
            st.pop();
            k--;
        }

        // Construct the resulting string from the stack
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        sb.reverse();

        // Remove leading zeros
        while(sb.length()>0 && sb.charAt(0) == '0'){
            sb.deleteCharAt(0);
        }

        // Handle edge case where result might be empty
        return sb.length() > 0 ? sb.toString() : "0";
    }
}