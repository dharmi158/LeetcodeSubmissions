class Solution {
    //Previous Smaller Element
    public static int[] prevSmallerElement(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Stack<Integer> st = new Stack<>();

        for(int i = 0; i < n; i++) {
            while(!st.isEmpty() && nums[st.peek()] > nums[i]) {
                st.pop();
            }
            res[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return res;
    }

    //Next Smaller Element
    public static int[] nextSmallerElement(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Stack<Integer> st = new Stack<>();

        for(int i = n - 1; i >= 0; i--) {
            while(!st.isEmpty() && nums[st.peek()] >= nums[i]) {
                st.pop();
            }
            res[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        return res;
    }
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] prevSmaller = prevSmallerElement(heights);
        int[] nextSmaller = nextSmallerElement(heights);
        Stack<Integer> stack = new Stack<>();

        // Nearest Smaller to Left
        // for (int i = 0; i < n; i++) {
        //     while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) stack.pop();
        //     left[i] = stack.isEmpty() ? -1 : stack.peek();
        //     stack.push(i);
        // }

        //stack.clear(); // Reuse stack

        // Nearest Smaller to Right
        // for (int i = n - 1; i >= 0; i--) {
        //     while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) stack.pop();
        //     right[i] = stack.isEmpty() ? n : stack.peek();
        //     stack.push(i);
        // }

        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            int width = nextSmaller[i] - prevSmaller[i] - 1;
            maxArea = Math.max(maxArea, heights[i] * width);
        }
        return maxArea;
    }
}