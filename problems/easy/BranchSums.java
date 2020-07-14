import java.util.*;

//1) S: O(n) | T: O(n)
class Program {
  // This is the class of the input root. Do not edit it.
  public static class BinaryTree {
    int value;
    BinaryTree left;
    BinaryTree right;

    BinaryTree(int value) {
      this.value = value;
      this.left = null;
      this.right = null;
    }
  }

  public static List<Integer> branchSums(BinaryTree root) {
		

		// helperMethod
		List<Integer> sumsList= new ArrayList<>();
		return helperMethodBST (root, 0, sumsList);
    //return null;
  }
	
	public static List<Integer> helperMethodBST(BinaryTree tree, int sum, List<Integer> sumsList){
		sum = sum + tree.value;
		if(tree.left == null && tree.right == null){
			sumsList.add(sum);
			return sumsList;
		}

		
		if(tree.left != null){
			helperMethodBST(tree.left, sum, sumsList);
		}
		
		if(tree.right != null){
			helperMethodBST(tree.right, sum, sumsList);
		}
		return sumsList;
	}
	
}



import java.util.*;
// 2) A little different S: O(n) | T: O(n)
class Program {
  // This is the class of the input root. Do not edit it.
  public static class BinaryTree {
    int value;
    BinaryTree left;
    BinaryTree right;

    BinaryTree(int value) {
      this.value = value;
      this.left = null;
      this.right = null;
    }
  }

  public static List<Integer> branchSums(BinaryTree root) {
    
		List<Integer> list = new ArrayList<>();
		helperMethod(root, 0, list);
		System.out.println(list);
    return list;
  }
	
	public static void helperMethod( BinaryTree root, int runningSum, List<Integer> list){
		if( root == null )
			return;		
						
		runningSum += root.value;
		
		helperMethod(root.left, runningSum, list );		
		helperMethod(root.right, runningSum, list );
		
		if( root.left == null && root.right == null )
			list.add( runningSum ); 
		
	}	
}
