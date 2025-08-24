class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        
        for (int a : asteroids) {
            if (a > 0) {
                stack.push(a);
            } else {
                while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < Math.abs(a)){
                    stack.pop();
                }
                
                // if the elements are equal and oposite direction
                if (!stack.isEmpty() && stack.peek() == Math.abs(a)) {
                    stack.pop();
                }

                // if tos and current ele are -ve
                else if (stack.isEmpty() || stack.peek() < 0)  {
                    stack.push(a);
                }
            }
        }

        int[] res = new int[stack.size()];
        int i = stack.size() - 1;

        while(!stack.isEmpty()) {
            res[i--] = stack.pop();
        }
        return res; 
    }
}