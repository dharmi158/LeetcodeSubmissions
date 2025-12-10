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
    int prevVal;
    int count;
    int maxCount;
    List<Integer> result = new ArrayList<>();

    public int[] findMode(TreeNode root) {
        result.clear();
        count = 0;
        maxCount = 0;

        inorder(root);

        int[] res = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            res[i] = result.get(i);
        }
        return res;
    }

    private void inorder(TreeNode root) {
        if (root == null)
            return;

        inorder(root.left);

        // Handle current node
        if (count == 0 || root.val != prevVal) {
            count = 1;
            prevVal = root.val;
        } else {
            count++;
        }

        // Update result list
        if (count > maxCount) {
            maxCount = count;
            result.clear();
            result.add(root.val);
        } else if (count == maxCount) {
            result.add(root.val);
        }

        inorder(root.right);
    }
}