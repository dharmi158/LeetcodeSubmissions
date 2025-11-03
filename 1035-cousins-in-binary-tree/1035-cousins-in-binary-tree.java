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
 //TC- O(N)
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        
        //Initialize queue for level order traversal
        ArrayList<TreeNode> queue = new ArrayList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            boolean xFound = false, yFound = false;
            
            for(int i=0;i<size;i++){
                TreeNode peek = queue.get(0);
                queue.remove(0);

                // Check if this node has both children — and if they are x and y
                // If yes, they are siblings, not cousins → return false
                if(peek.left!=null && peek.right!= null && 
                ((peek.left.val == x && peek.right.val == y)|| 
                (peek.left.val == y && peek.right.val == x))){
                    return false;
                }
            
                
                // If this node is x, mark it
                if(peek.val == x) xFound = true;

                // If this node is y, mark it
                if(peek.val == y) yFound = true;


                // Add this node's children to the queue for the next level
                if (peek.left != null) queue.add(peek.left);
                if (peek.right != null) queue.add(peek.right);
            }
            // After checking the whole level:
            // If we found both x and y here, and they weren’t siblings → they’re cousins
            if (xFound && yFound) return true;

            // If we only found one of them at this level, they can’t be cousins
            if (xFound || yFound) return false;
        }
        return false;
    }
}