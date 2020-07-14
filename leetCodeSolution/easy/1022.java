/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// UNIQUE
class Solution {
    public int sumRootToLeaf(TreeNode root) {
        return helperMethod( root, 0);
        
    }
    
    public int helperMethod( TreeNode root, int x){
        if(root == null)
            return 0;
        
        // Signed Bitwise Left shift by 1 and then Bitwise      
        x = x << 1 | root.val;
        if ( root.left == null && root.right == null)
            return x;
        
        return ( helperMethod(root.left, x) + helperMethod(root.right, x) );
    }
    
}