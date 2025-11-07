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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Deque<TreeNode> q = new LinkedList<>();
        boolean reverse = false;
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        if(root==null){
            return result;
        }
        q.add(root);
        while(!q.isEmpty()){
            int levels = q.size();
            List<Integer> current = new ArrayList<>();
            for(int i=0;i<levels;i++){
                if(!reverse){
                    TreeNode curr = q.pollFirst();
                    current.add(curr.val);
                    if(curr.left!=null){
                        q.addLast(curr.left);
                    }
                    if(curr.right!=null){
                        q.addLast(curr.right);
                    }
                }
                else{
                    TreeNode curr = q.pollLast();
                    current.add(curr.val);
                    if(curr.right!=null){
                        q.addFirst(curr.right);
                    }
                    if(curr.left!=null){
                        q.addFirst(curr.left);
                    }
                }
            }
            result.add(current);
            reverse = !reverse;
        }
        return result;
    }
}