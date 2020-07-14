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
// class Solution {
//     public boolean isSymmetric(TreeNode root) {
        
//         return helperMethod( root, root );
//     }
    
//     public boolean helperMethod ( TreeNode left, TreeNode right ){
//         if ( left == null && right == null )
//             return true;
//         if ( left == null || right == null )
//             return false;

//         return left.val == right.val && helperMethod( left.left, right.right ) && helperMethod( right.right, left.left ) ;
//     }
// }

// class Solution {
//     public boolean isSymmetric(TreeNode root) {
//         Stack<TreeNode> s1 = new Stack<>();
//         Stack<TreeNode> s2 = new Stack<>();
        
//         s1.push( root );
//         s2.push( root );
        
//         while( !s1.isEmpty() && !s2.isEmpty() ){
//             TreeNode c1 = s1.pop();
//             TreeNode c2 = s2.pop();
            
//             if ( c1 == null && c2 == null )
//                 continue;
            
//             if ( c1 == null || c2 == null )
//                 return false;
            
//             if( c1.val != c2.val )
//                 return false;
            
//             s1.push( c1.left );
//             s1.push( c1.right );
            
//             s2.push( c2.right );
//             s2.push( c2.left );
                        
//         }
   
//         return true;
//     }
// }

// class Solution {
//     public boolean isSymmetric(TreeNode root) {
//         Stack<TreeNode> s1 = new Stack<>();

//         if( root == null )
//             return true;
        
//         s1.push( root.left );
//         s1.push( root.right );
        
//         while( !s1.isEmpty() ){
//             TreeNode c1 = s1.pop();
//             TreeNode c2 = s1.pop();
            
//             if ( c1 == null && c2 == null )
//                 continue;
            
//             if ( c1 == null || c2 == null )
//                 return false;
            
//             if( c1.val != c2.val )
//                 return false;
            
//             // Attention to the sequence of push operation on stack.
//             s1.push( c2.left );            
//             s1.push( c1.right );
//             s1.push( c2.right );
//             s1.push( c1.left );                        
//         }
   
//         return true;
//     }
// }

class Solution {
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> s1 = new LinkedList<>();

        if( root == null )
            return true;
        
        s1.offer( root );
        s1.offer( root );
        
        while( !s1.isEmpty() ){
            TreeNode c1 = s1.poll();
            TreeNode c2 = s1.poll();
            
            if ( c1 == null && c2 == null )
                continue;
            
            if ( c1 == null || c2 == null )
                return false;
            
            if( c1.val != c2.val )
                return false;
            
            // Attention to the sequence of push operation on queue.
            s1.add( c1.left );                        
            s1.add( c2.right );
            s1.add( c1.right );
            s1.add( c2.left );            
            
        }
   
        return true;
    }
}