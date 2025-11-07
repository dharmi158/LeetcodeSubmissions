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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        // Recursive approach
        //postorder(root, result);

        //Iterative approach
        if(root == null){
            return result;
        }
        Stack<TreeNode> st1 = new Stack<TreeNode>();
        Stack<TreeNode> st2 = new Stack<TreeNode>();
        st1.push(root);
        while(!st1.isEmpty()){
            root = st1.pop();
            st2.add(root);
            
            // then push left because it can traverse last
            if(root.left != null){
                st1.push(root.left);
            }
            // first push right because it can traverse first
            if(root.right != null){
                st1.push(root.right);
            }
        }
        while(!st2.isEmpty()){
                result.add(st2.pop().val);
        }
        return result;
    }
    // private void postorder(TreeNode node, List<Integer> res) {
    //     if (node == null) {
    //         return;
    //     }
    //     postorder(node.left, res);
    //     postorder(node.right, res);
    //     res.add(node.val);
    // }
}