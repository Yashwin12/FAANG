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

 // 1) 
// class Solution {
//     public boolean isCousins(TreeNode root, int x, int y) {

//         return depthFinder( root, x, 0 ) == depthFinder( root, y, 0 ) && !isSibling(root, x, y) ;
//     }
    
//     public Boolean isSibling ( TreeNode root, int x, int y ){
//         if( root == null )
//             return false;
        
//         boolean check = false;
//         if(root.left != null && root.right != null){
//             check = (root.left.val == x && root.right.val == y) || (root.left.val == y && root.right.val == x);
//         }
    
//         return check || isSibling(root.left, x, y) || isSibling(root.right, x, y);
//     }
    
//     public int depthFinder ( TreeNode root, int element, int depth ){
//         if( root == null )
//             return 0;
                           
//         if( root.val == element )
//             return depth;
//         depth++;
        
//         // UNIQUE
//         // '|' is Bitwise OR. In this case, we can get the exact height in only one return value, others are all zero, so ...0 | 0 | x | 0 | .... = x that is the height we want.        
//         return depthFinder( root.left, element, depth ) | depthFinder ( root.right, element, depth );
//     }
        
// }

// 2) Using BFS
class Solution {
    public static boolean isCousins(TreeNode root, int x, int y) {
    if(root == null) 
        return false;
    
    Queue<TreeNode> queue = new LinkedList<>();
    TreeNode xParent = null, yParent = null;
    queue.offer(root);
    // System.out.println("ROOT: " + queue.peek().left );
    // System.out.println("ROOT SIZE: " + queue.size() );
        
    while(!queue.isEmpty()){
        int size = queue.size();
        
        while(size > 0){
            TreeNode node = queue.poll();
            if(node.left != null){
                queue.offer(node.left);
                if(node.left.val == x) xParent = node;
                if(node.left.val == y) yParent = node;
            }
            if(node.right != null){
                queue.offer(node.right);
                if(node.right.val == x) xParent = node;
                if(node.right.val == y) yParent = node;
            }
            --size;
            if(xParent != null && yParent != null) 
                break;
        }
        if(xParent != null && yParent != null) 
            return xParent != yParent;
        
        if((xParent != null && yParent == null) || (xParent == null && yParent != null)) 
            return false;
        
    }
    return false;
}
}