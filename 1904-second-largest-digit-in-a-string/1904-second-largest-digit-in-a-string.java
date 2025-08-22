class Solution {
    public int secondHighest(String s) {
        HashSet<Integer> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                set.add(c - '0');
            }
        }

        if (set.size() < 2) return -1;
        
        ArrayList<Integer> list = new ArrayList<>();
        for (int i : set) list.add(i);

        Collections.sort(list);
        return list.get(list.size() - 2);
    }
}