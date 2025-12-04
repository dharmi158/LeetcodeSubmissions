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
    private int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxSum;
    }
    //gives maximum gain (best upward path from this node)
    private int dfs(TreeNode node) {
        if (node == null) return 0;

        // compute gains from left & right — ignore negatives using Math.max
        int leftGain = Math.max(0, dfs(node.left));
        int rightGain = Math.max(0, dfs(node.right));

        // path that passes through current node (left + node + right)
        int pathThroughNode = node.val + leftGain + rightGain;

        // update global max
        maxSum = Math.max(maxSum, pathThroughNode);

        // return the best gain *upward*: node + max(one side)
        return node.val + Math.max(leftGain, rightGain);
    }
}