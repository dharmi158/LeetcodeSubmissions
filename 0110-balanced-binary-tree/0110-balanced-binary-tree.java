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
    public boolean ans = true;

    public int height(TreeNode root){
        if(root==null) 
            return 0;
        int maxLeft = height(root.left);
        int maxRight = height(root.right);

        if(Math.abs(maxLeft-maxRight)>1)
            ans = false;
        return Math.max(maxLeft,maxRight)+1;
    }
    public boolean isBalanced(TreeNode root) {
        if(root==null) 
            return true;
        height(root);
        return ans;
    }
}