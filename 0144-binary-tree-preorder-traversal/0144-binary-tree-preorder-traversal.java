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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        //preorder(root, result);

        if(root == null){
            return result;
        }
        Stack<TreeNode> st = new Stack<TreeNode>();
        st.push(root);
        while(!st.isEmpty()){
            root = st.pop();
            result.add(root.val);
            
            // first push right because it can traverse first
            if(root.right != null){
                st.push(root.right);
            }
            // then push left because it can traverse last
            if(root.left != null){
                st.push(root.left);
            }
        }
        // Iterative approach
        return result;
    }
    // private void preorder(TreeNode node, List<Integer> res) {
    //     if (node == null) {
    //         return;
    //     }
    //     res.add(node.val);
    //     preorder(node.left, res);
    //     preorder(node.right, res);
    // }
}