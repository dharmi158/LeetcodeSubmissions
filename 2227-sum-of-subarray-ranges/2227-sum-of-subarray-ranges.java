class Solution {
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

    //Next Greater Element
    public static int[] nextGreaterElement(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Stack<Integer> st = new Stack<>();

        for(int i = n - 1; i >= 0; i--) {
            while(!st.isEmpty() && nums[st.peek()] <= nums[i]) {
                st.pop();
            }
            res[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        return res;
    }

    //Previous Greater Element
    public static int[] prevGreaterElement(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Stack<Integer> st = new Stack<>();

        for(int i = 0; i < n; i++) {
            while(!st.isEmpty() && nums[st.peek()] < nums[i]) {
                st.pop();
            }
            res[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return res;
    }

    //sum of subarray minimums
    public static long sumOfSubarrayMins(int[] nums) {
        int[] pse = prevSmallerElement(nums);
        int[] nse = nextSmallerElement(nums);
        long total = 0;
        int n = nums.length;

        for(int i = 0; i < n; i++) {
            long l = i - pse[i];
            long r = nse[i] - i;
            total += (l * r * (long) nums[i]);
        }
        return total;
    }

    //sum of subarray maximums
    public static long sumOfSubarrayMaxs(int[] nums) {
        int[] pge = prevGreaterElement(nums);
        int[] nge = nextGreaterElement(nums);
        long total = 0;
        int n = nums.length;

        for(int i = 0; i < n; i++) {
            long l = i - pge[i];
            long r = nge[i] - i;
            total += (l * r * (long) nums[i]);
        }
        return total;
    }

    public long subArrayRanges(int[] nums) {
        long min = sumOfSubarrayMins(nums);
        long max = sumOfSubarrayMaxs(nums);
        return max - min;
    }
}