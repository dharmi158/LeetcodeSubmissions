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
    int count = 0;
    int result = -1;
    Stack<TreeNode> stack = new Stack<>();

    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return result;
    }

    private void inorder(TreeNode root, int k) {
        //Recursive approach
        // if (root == null) return;

        // inorder(root.left, k);

        // count++;
        // if (count == k) {
        //     result = root.val;
        //     return;
        // }

        // inorder(root.right, k);

        //Iterative approach
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            count++;

            if (count == k){
                result = root.val;
                return;
            }

            root = root.right;
        }

    }
}