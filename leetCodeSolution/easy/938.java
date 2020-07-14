/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int rangeSumBST(TreeNode root, int L, int R) {

        return helperMethod(root, L, R, 0); 
        
    }
    
    public int helperMethod(TreeNode root, int L, int R, int sum){
        if ( root == null )
            return sum;
        
        sum = root.val >= L && root.val <= R ? sum + root.val : sum;
        
        // If the current value is greater than L range then we need to further explore LEFT node.
        if (root.val > L)
            sum = helperMethod (root.left, L, R, sum);
        
        if (root.val < R)
            sum = helperMethod (root.right, L, R, sum);
        
        return sum; 
    }
}