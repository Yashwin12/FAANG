// class Program {
//   public static boolean validateBst(BST tree) {
    
// 		return helperMethod(tree);
//     //return false;
//   }
	
//     // WRONG WAY: This wont satify below tree
//             //     10
//             //     /
//             //    5
//             //     \
//             //     11 

// 	public static boolean helperMethod( BST tree ){
// 		if(tree == null){
// 			return true;
// 		}
		
// 		if( tree.left != null && tree.left.value < tree.value){
// 			return helperMethod( tree.left );
// 		}		
// 		if( tree.right != null && tree.right.value >= tree.value){
// 			return helperMethod( tree.right );
// 		}
// 		return false;
// 	}

//   static class BST {
//     public int value;
//     public BST left;
//     public BST right;

//     public BST(int value) {
//       this.value = value;
//     }
//   }
// }


// RIGHT WAY: T : O(n) | S: O(d), where d = deepest depth of the branch. If tree is not balanced then d ~ N.
class Program {
    public static boolean validateBst(BST tree) {
      
          return helperMethod(tree, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }
      
      public static boolean helperMethod( BST tree, int maxValue, int minValue ){
          if(tree == null){
              return true;
          }
          
          if( tree.value < minValue || tree.value >= maxValue ){
              return false;
          }
          
          if( tree.left != null && !helperMethod( tree.left, tree.value, minValue ) ){
              return false;
          }
          
          if( tree.right != null && !helperMethod( tree.right, maxValue, tree.value ) ){
              return false;
          }
          
          return true;
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



// RIGHT WAY: T : O(n) | S: O(d), where d = deepest depth of the branch. If tree is not balanced then d ~ N.
class Program {
  public static boolean validateBst(BST tree) {
    return isValidatedBST(tree, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }
	
	public static boolean isValidatedBST( BST tree, int min , int max ){
		if( tree == null )
			return true;
		
		if ( tree.value < min || tree.value >= max ){
			return false;
		}
		
		return isValidatedBST(tree.left, min, tree.value) && isValidatedBST(tree.right, tree.value, max);
		
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


// Not RIGHT: The below method first converts inOrderList which is then checked if it sorted or not! This fails to check if 10 (leaf node) is present on the right side or the left side.... 
   // FAILED TEST CASE:  10
                    //  / \
                    // 5   15
                    //  \
                    //  10  
// import java.util.*;

// class Program {
//   public static boolean validateBst(BST tree) {
//     List<Integer> inOrderList = new ArrayList<>();
// 		inOrderTraverse(tree, inOrderList);
// 		System.out.println( inOrderList.toString());
//     return isSorted(inOrderList);
//   }
	
// 	public static Boolean isSorted( List<Integer> array ){
// 		List<Integer> tmp = new ArrayList<>(array);
// 		Collections.sort(tmp);
// 		return tmp.equals(array);
// 	}
	
// 	public static void inOrderTraverse( BST tree, List<Integer> array){
// 		if (tree == null) {
// 			return;
// 		}

// 		inOrderTraverse(tree.left, array);
// 		array.add(tree.value);
// 		inOrderTraverse(tree.right, array);
// 	}

//   static class BST {
//     public int value;
//     public BST left;
//     public BST right;

//     public BST(int value) {
//       this.value = value;
//     }
//   }
// }

