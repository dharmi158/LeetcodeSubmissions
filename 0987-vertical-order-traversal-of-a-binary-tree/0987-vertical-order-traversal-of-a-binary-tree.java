/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<int[]> list = new ArrayList<>();

        dfs(root,0,0,list);

        Collections.sort(list, (a, b) -> {
            if (a[1] != b[1]) return a[1] - b[1]; //If columns differ, sort by x ascending.
            else if (a[2] != b[2]) return a[2] - b[2]; //If x are equal, compare y.
            else return a[0] - b[0]; //f both x and y are equal,smaller value goes first.
        });


        List<List<Integer>> result = new ArrayList<>();
        int prevX = Integer.MIN_VALUE;

        for (int[] entry : list) {
            int val = entry[0];
            int x = entry[1];

            //If the current x differs from prevX, we encountered a new column.
            if (x != prevX) {
                result.add(new ArrayList<>());
                prevX = x; //Update prevX to the current x.
            }

            result.get(result.size() - 1).add(val); //Add val into the most recent column list.
        }
        return result;
    }
    private void dfs(TreeNode root, int x, int y, List<int[]> list){
        if(root == null)
            return;

        list.add(new int[]{root.val,x,y});

        dfs(root.left, x-1, y+1, list);
        dfs(root.right, x+1, y+1, list);
    }
}