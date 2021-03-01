import java.util.*;
class Program {
	// 1) S: O(d) | T: O(n)
//   public static void invertBinaryTree(BinaryTree tree) {
//     // Write your code here.

// 		if (tree == null){
// 			return;
// 		}
// 		swapLeftAndRight( tree );		
// 		invertBinaryTree (tree.left);
// 		invertBinaryTree (tree.right);
//   }
	
// 	public static void swapLeftAndRight ( BinaryTree tree ){
		
// 		BinaryTree left = tree.left;
// 		tree.left = tree.right;
// 		tree.right = left;
	
// 	} 
	
	// 2)  S: O(n) | T: O(n)
	 public static void invertBinaryTree(BinaryTree tree) {

		ArrayDeque<BinaryTree> queue = new ArrayDeque<>();
		  //System.out.println("tree!" + tree.left.value );
		queue.offer( tree );
		 
		 while ( queue.size() > 0 ){
			 BinaryTree current = queue.poll();
			 System.out.println("cur!" + current.value);
			 if (current == null){
				 continue;
			 }
			 swapLeftAndRight ( current );
			 //We can insert the null value into the LinkedList but couldn't insert it into the Queue , despite implementing Queue by LinkedList 
			 if( current.left != null){
					 queue.offer(current.left);				 
			 }
			if( current.right != null){
			 		queue.offer(current.right);
			}
			 
		 }
		
  }
	
	public static void swapLeftAndRight ( BinaryTree tree ){
		
		BinaryTree left = tree.left;
		tree.left = tree.right;
		tree.right = left;
	
	} 

  static class BinaryTree {
    public int value;
    public BinaryTree left;
    public BinaryTree right;

    public BinaryTree(int value) {
      this.value = value;
    }
  }
}


import java.util.*;
// 3)  S: O(n) | T: O(n)

class Program {
  public static void invertBinaryTree(BinaryTree tree) {
		Stack<BinaryTree> stack = new Stack<>();
		stack.push(tree);
		while( !stack.isEmpty() ){
			BinaryTree currentNode = stack.pop();
			swapChildren(currentNode);
			if( currentNode.left != null ){
				stack.add(currentNode.left);
			}
			if( currentNode.right != null ){
				stack.add(currentNode.right);
			}
		}
	}
	
	public static void swapChildren ( BinaryTree tree){
		BinaryTree temp = tree.left;
		tree.left = tree.right;
		tree.right = temp;
	}


  static class BinaryTree {
    public int value;
    public BinaryTree left;
    public BinaryTree right;

    public BinaryTree(int value) {
      this.value = value;
    }
  }
}
