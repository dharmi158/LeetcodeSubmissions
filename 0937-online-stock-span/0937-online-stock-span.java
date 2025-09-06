class StockSpanner {
    //Brute Force - TC- O(N) where N = number of days, SC- O(number of next calls)
    // ArrayList<Integer> list;

    // public StockSpanner() {
    //     list = new ArrayList<Integer>();
    // }
    
    // public int next(int price) {
    //     list.add(price);
    //     int count=1;
    //     for(int i=list.size()-2;i>=0;i--){
    //         if(list.get(i) <= price)
    //             count++;
    //         else
    //             break;
    //     }
    //     return count;
    // }

    //Optimal - TC O(N),SC- O(N)
    Stack<int[]> st; 
    int index;
    public StockSpanner() {
        index = -1;
        st = new Stack<>();
    }
    public int next(int price) {
        index += 1;
        while(!st.isEmpty() && st.peek()[0] <= price){
          st.pop();
        }
        int ans = index - (st.isEmpty() ? -1 : st.peek()[1]);
        st.push(new int[]{price, index}); 
        return ans;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */