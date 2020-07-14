import java.util.*;

// 1) With recursion AVG S:O(log*n) | T: O(log*n) 
// With recursion WORST S:O(n) | T: O(n) -> When the tree is skewed
class Program {
  public static int findClosestValueInBst(BST tree, int target) {
    
    return helperMethod( tree, target, tree.value );
  }
	
	public static int helperMethod( BST tree, int target, int closest ){
		if( Math.abs( tree.value - target ) < Math.abs( closest - target ) )
			closest = tree.value; 
		
		if( tree.value < target && tree.right != null )
			return helperMethod( tree.right, target, closest );		
		else if( tree.value > target && tree.left != null )
			return helperMethod( tree.left, target, closest );
		else 
			return closest;			
	}

  static class BST {
    public int value;
    public BST left;
    public BST right;

    public BST(int value) {
      this.value = value;
    }
  }
}


import java.util.*;

// 2) Without recursion AVG S:O(1) | T: O(log*n) 
// With recursion WORST S:O(1) | T: O(n) -> When the tree is skewed
class Program {
  public static int findClosestValueInBst(BST tree, int target) {
    
    return helperMethod( tree, target, tree.value );
  }
	
	public static int helperMethod( BST tree, int target, int closest ){
				
		while( tree != null ){
			if( Math.abs( tree.value - target ) < Math.abs( closest - target ) )
				closest = tree.value; 
			
			if( tree.value < target )
				tree = tree.right;				
					
			else if( tree.value > target )
				
				tree = tree.left;			
				
			else 				
				break;				
		}
		
		return closest;
	}

  static class BST {
    public int value;
    public BST left;
    public BST right;

    public BST(int value) {
      this.value = value;
    }
  }
}
