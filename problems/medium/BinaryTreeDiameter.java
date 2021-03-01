import java.util.*;

class Program {
  // This is an input class. Do not edit.
  static class BinaryTree {
    public int value;
    public BinaryTree left = null;
    public BinaryTree right = null;

    public BinaryTree(int value) {
      this.value = value;
    }
  }

  // HACK: https://www.youtube.com/watch?v=ey7DYc9OANo
  public int binaryTreeDiameter(BinaryTree tree) {
   	// -1 here because 5 nodes give a diameter of 4 (i.e edges)
    return diameterHelper( tree) - 1; // ans depicts number of nodes| we want to find edges so for n nodes in graph one need n-1 edges as connection. Hence we subtract 1
  }
	
	public int diameterHelper( BinaryTree tree ){
		if( tree == null )
			return 0;
		
		int leftBranchHeight = height( tree.left);
		int rightBranchHeight = height( tree.right);
		
		int leftDiameter = diameterHelper( tree.left);
		int rightDiameter = diameterHelper( tree.right);
		
		// leftBranchHeight + rightBranchHeight + 1 => Case where Root is considered in the count! 
		// Math.max(leftDiameter, rightDiameter); => Case where root of the recursion calls doesnt contribute to max diamater
		int max = Math.max( leftBranchHeight + rightBranchHeight + 1, Math.max(leftDiameter, rightDiameter) );
		
		return max;
	}
	
	public int height ( BinaryTree tree ){
		if( tree == null )
			return 0;		
		
		int left = height( tree.left);
		int right = height( tree.right);
		
		int height;
		if ( left > right ){
			height = left + 1; 
		}
		else{
			height = right + 1; 
		}
		return height;
		
	}	
}