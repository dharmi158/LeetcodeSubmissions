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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        // Recursive approach
        //inorder(root, result);

        //Iterative approach
        Stack<TreeNode> st = new Stack<TreeNode>();
        TreeNode node = root;

        while(true){
            if(node!=null){
                st.push(node);
                node = node.left;
            }
            else{
                if(st.isEmpty()){
                    break;
                }
                node = st.pop();
                result.add(node.val);
                node = node.right;
            }
        }
        return result;
    }
    // private void inorder(TreeNode node, List<Integer> res) {
    //     if (node == null) {
    //         return;
    //     }
    //     inorder(node.left, res);
    //     res.add(node.val);
    //     inorder(node.right, res);
    // }
}