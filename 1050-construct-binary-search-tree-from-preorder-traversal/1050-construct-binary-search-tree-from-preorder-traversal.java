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
    TreeNode root = null;
    public TreeNode bstFromPreorder(int[] preorder) {
        // for(int val : preorder){
        //     root = insertIntoBST(root,val);
        // }
        // return root;

        //eficient code Tc - o(n)
        return build(preorder, Integer.MAX_VALUE);

    }
    // private TreeNode insertIntoBST(TreeNode root, int val){
    //     if (root == null)
    //         return new TreeNode(val);

    //     if (val < root.val)
    //         root.left = insertIntoBST(root.left, val);
    //     else if (val > root.val)
    //         root.right = insertIntoBST(root.right, val);

    //     return root;
    // }

    int index = 0;
    private TreeNode build(int[] preorder, int bound){
        if(index == preorder.length || preorder[index] > bound){
            return null;
        }
        TreeNode root = new TreeNode(preorder[index++]);
        root.left = build(preorder, root.val);
        root.right = build(preorder, bound);
        return root;
    }
}