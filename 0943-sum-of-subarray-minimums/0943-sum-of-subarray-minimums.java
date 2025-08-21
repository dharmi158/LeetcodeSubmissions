class Solution {
    public int sumSubarrayMins(int[] arr) {
        final long MOD = 1_000_000_007L;
        int n = arr.length;

        int[] prev = new int[n];   // index of previous strictly smaller
        int[] next = new int[n];   // index of next smaller-or-equal

        Deque<Integer> st = new ArrayDeque<>();

        // prev: strictly smaller  -> pop >=
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) st.pop();
            prev[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        st.clear();

        // next: smaller-or-equal  -> pop >
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) st.pop();
            next[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        long ans = 0;
        for (int i = 0; i < n; i++) {
            long left = i - prev[i];
            long right = next[i] - i;
            ans = (ans + ((left * right) % MOD) * arr[i]) % MOD;
        }
        return (int) ans;
    }
}