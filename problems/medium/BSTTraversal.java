import java.util.List;

// S: O(d) where d = max depth of the branch ; T: O(n)
// class Program {

//   public static List<Integer> inOrderTraverse(BST tree, List<Integer> array) {

// 		if( tree.left != null ) {
// 			inOrderTraverse ( tree.left, array );  
// 		}

// 			array.add (tree.value);
// 		if( tree.right != null ) {
// 			inOrderTraverse ( tree.right, array );  
// 		}		
// 		return array;
//   }

//   public static List<Integer> preOrderTraverse(BST tree, List<Integer> array) {
//     // Write your code here.

//     return preOrderHelperMethod ( tree, array );
//   }

// 	public static List<Integer> preOrderHelperMethod ( BST tree, List<Integer> array ){

// 		array.add (tree.value);
// 		if( tree.left != null ) {
// 			preOrderHelperMethod ( tree.left, array );  
// 		}

// 		if( tree.right != null ) {
// 			preOrderHelperMethod ( tree.right, array );  
// 		}		
// 		return array;
// 	}

//   public static List<Integer> postOrderTraverse(BST tree, List<Integer> array) {

// 		if( tree.left != null ) {

// 			postOrderTraverse ( tree.left, array );  
// 		}

// 		if( tree.right != null ) {
// 			postOrderTraverse ( tree.right, array );  
// 		}		
// 		array.add (tree.value);
// 		return array;
//   }

//   static class BST {
//     public int value;
//     public BST left;
//     public BST right;

//     public BST(int value) {

//       this.value = value;
//     }
//   }
// }


// 2: Extremely similar method, but much more cleaner. 
import java.util.List;

// S: O(d) where d = max depth of the branch ; T: O(n)
class Program {

	// In-order => left -> node -> right
	public static List<Integer> inOrderTraverse(BST tree, List<Integer> array) {

		if (tree == null) {
			return array;
		}

		inOrderTraverse(tree.left, array);
		array.add(tree.value);
		inOrderTraverse(tree.right, array);

		return array;
	}

	// Pre-order =>  node -> left -> right
	public static List<Integer> preOrderTraverse(BST tree, List<Integer> array) {

		if (tree == null) {
			return array;
		}

		array.add(tree.value);
		preOrderTraverse(tree.left, array);
		preOrderTraverse(tree.right, array);

		return array;

	}

	// Post-order =>  left -> right -> node
	public static List<Integer> postOrderTraverse(BST tree, List<Integer> array) {

		if (tree == null) {
			return array;
		}

		postOrderTraverse(tree.left, array);
		postOrderTraverse(tree.right, array);
		array.add(tree.value);

		return array;

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
