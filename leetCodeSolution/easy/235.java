/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// 1) T: O(n) | S: O(n) 
// class Solution {
//     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
//         if( root.val > p.val && root.val > q.val )
//             return lowestCommonAncestor( root.left, p, q );
//         else if( root.val < p.val && root.val < q.val )
//             return lowestCommonAncestor( root.right, p, q );
//         else
//             return root;
//     }
    
// }

// 2) T: O(N) | S: O(N)
// class Solution {
//     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
//         Stack<TreeNode> stack = new Stack<>();
//         stack.push(root);
        
//         while ( !stack.isEmpty() ) {
//             TreeNode current = stack.pop();
            
//             if( current.val > p.val && current.val > q.val )
//                 stack.push(current.left);
//             else if( current.val < p.val && current.val < q.val )
//                 stack.push(current.right);
//             else 
//                 return current;            
//         }
        
//         return null;
//     }
    
// }

// 3)  T: O(N) | S: O(1)
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
                    
        while ( true ) {            
            if( root.val > p.val && root.val > q.val )
                root = root.left;
            
            else if( root.val < p.val && root.val < q.val )
                root=root.right;
            
            else 
                return root;            
        }    
    }    
}