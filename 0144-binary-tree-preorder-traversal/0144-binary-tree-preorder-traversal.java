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

        // Recursive approach
        //preorder(root, result);

        // Iterative approach
        if(root == null){
            return result;
        }
        Stack<TreeNode> st = new Stack<TreeNode>();
        st.push(root);
        while(!st.isEmpty()){
            root = st.pop();
            result.add(root.val);
            
            // push right first so that left is processed first (stack: LIFO)
            if(root.right != null){
                st.push(root.right);
            }
           // push left last so that it gets popped first (preorder: root, left, right)
            if(root.left != null){
                st.push(root.left);
            }
        }
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