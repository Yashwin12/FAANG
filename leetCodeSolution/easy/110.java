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
    
    boolean globalFlag = true;
    
    public boolean isBalanced(TreeNode root) {
        helperMethod( root );
        return globalFlag;
    }
    
    private int helperMethod( TreeNode tree ){
        if( !globalFlag)
            return 0;
        if( tree == null )
            return 0;
        
        int leftH = helperMethod( tree.left ) + 1;
        int rightH = helperMethod( tree.right ) + 1;
        
        if( Math.abs( leftH - rightH ) > 1 ){
            globalFlag = false;
        }
        
        return Math.max(leftH, rightH);
    }
    
    
}