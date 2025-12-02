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
    int postIndex;
    HashMap<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postIndex = postorder.length - 1;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return build(postorder, inorder, 0, inorder.length - 1);
    }

    TreeNode build(int[] postorder, int[] inorder, int inStart, int inEnd) {
        if (inStart > inEnd)
            return null;

        int rootVal = postorder[postIndex--];
        TreeNode root = new TreeNode(rootVal);

        int inIndex = map.get(rootVal);

        //In postorder: left → right → root
        //postIndex is at the root (last element)
        //After picking root, we move backwards
        //That means the next element we encounter is actually part of the right subtree, not left.
        root.right = build(postorder, inorder, inIndex + 1, inEnd);
        root.left = build(postorder, inorder, inStart, inIndex - 1);

        return root;
    }
}