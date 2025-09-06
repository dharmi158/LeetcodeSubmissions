class Solution {
    public String clearDigits(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch) && !stack.isEmpty()) {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }

        //convert stack to string
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.peek());
            stack.pop();
        }
        
        return result.reverse().toString();
    }
}