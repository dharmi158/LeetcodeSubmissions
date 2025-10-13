class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int len = arr.length;
        int minDiff = Integer.MAX_VALUE;
        List<List<Integer>> result = new ArrayList<>(len);

        for (int i = 1; i < len; i++) {
            int prev = arr[i - 1];
            int curr = arr[i];
            int diff = curr - prev;

            if (minDiff > diff) {
                minDiff = diff;
                result.clear();
                result.add(List.of(prev, curr));
            } else if (diff == minDiff){
                result.add(List.of(prev, curr));
            }
        }

        return result;
    }
}