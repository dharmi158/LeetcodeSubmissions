class Solution {
    public int[][] merge(int[][] intervals) {
        // Sort intervals
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> mergerdArray = new ArrayList<>();

        int[] prev = intervals[0];
        for(int i=1;i<intervals.length;i++){
            int[] interval = intervals[i];
            if(interval[0]<=prev[1]){
                prev[1] = Math.max(prev[1],interval[1]);
            }
            else{
                mergerdArray.add(prev);
                prev = interval;
            }
        }
        mergerdArray.add(prev);
        return mergerdArray.toArray(new int[mergerdArray.size()][]);
    }
}