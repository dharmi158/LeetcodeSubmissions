class StockSpanner {
    //Brute Force - TC- O(N) where N = number of days, SC- O(number of next calls)
    ArrayList<Integer> list;

    public StockSpanner() {
        list = new ArrayList<Integer>();
    }
    
    public int next(int price) {
        list.add(price);
        int count=1;
        for(int i=list.size()-2;i>=0;i--){
            if(list.get(i) <= price)
                count++;
            else
                break;
        }
        return count;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */