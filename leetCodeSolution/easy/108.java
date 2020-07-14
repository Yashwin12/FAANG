class Solution {
    // HACK : https://www.youtube.com/watch?v=12omz-VAyRk
    public TreeNode sortedArrayToBST(int[] nums) {
        if( nums == null || nums.length == 0)    
            return null;
                    
        return helperMethod( nums, 0 , (nums.length - 1) );
    }
    
    // IMPORTANT 
    public TreeNode helperMethod( int[] nums, int left, int right ){
        if( left > right)
            return null;
        
        int midPoint = left + ( right - left) / 2;
        TreeNode currentNode = new TreeNode( nums[midPoint] );
        
        currentNode.left = helperMethod( nums, left, (midPoint - 1) );
        currentNode.right = helperMethod( nums, (midPoint + 1) , right );
        
        return currentNode;
        
    }
}