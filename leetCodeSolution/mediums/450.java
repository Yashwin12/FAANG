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

 // HACK: https://www.youtube.com/watch?v=5_AZcOOc-kM
class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        
        // Base case
        if( root == null){
            return null;
        }

        if( root.val > key ){
            // Go left 
            root.left = deleteNode(root.left, key);
        }

        else if( root.val < key ){
            // Go right    
            root.right = deleteNode(root.right, key);                
        }
        else{
            // We found node which has to be deleted. 

            if( root.right != null && root.left != null ){
                // CASE 1: Both left and right child is present.

                // root.val = findMinFromCurrent( root.right );
                // root.right = deleteNode( root.right, root.val );
                            // OR
                root.val = findMaxFromCurrent( root.left );
                root.left = deleteNode( root.left, root.val );
                
                return root;
            }
            else if ( root.right != null ){                
                // CASE 2(a): Only right child is present. 
                return root.right;
            }
            
            else if ( root.left != null ){
                // CASE 2(a): Only left child is present.
                return root.left;
            }
            else{
                // CASE 3: Leaf node. Just delete this.     
                return null;
            }

        }            
        
        return root;
    }
    
    private int findMaxFromCurrent( TreeNode current ){
        int maxValue = current.val;
        
        while( current != null ){
            maxValue = current.val;
            current = current.right;    
        }    
        
        return maxValue;
    }
    
    private int findMinFromCurrent( TreeNode current ){
        int minValue = current.val;
        
        while( current != null ){
            minValue = current.val;
            current = current.left;    
        }    
        
        return minValue;
    }
    
}