import java.util.*;

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
