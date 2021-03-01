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
    public boolean hasPathSum(TreeNode root, int sum) {

        return helperFunc(root, 0, sum);
    }

    private boolean helperFunc(TreeNode root, int currentSum, int target) {
        if (root == null)
            return false;

        currentSum += root.val;

        if (root.left == null && root.right == null && currentSum - target == 0)
            return true;

        return helperFunc(root.left, currentSum, target) || helperFunc(root.right, currentSum, target);

    }
}