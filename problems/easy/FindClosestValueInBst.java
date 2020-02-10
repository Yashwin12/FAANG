class FindClosestValueInBst {

    // O (log(n)) TS - best;
    // O (n) TS - worst;  
  public static int findClosestValueInBst(BST tree, int target) {	
		return anotherMethod(tree, target, Double.MAX_VALUE );
  }
	
	public static int anotherMethod(BST tree, int target,double min ){
		
		if( Math.abs(target - tree.value) < Math.abs(target - min) ){
			min = tree.value;
		}
		
		if(target > tree.value && tree.right != null ){
			// right 
			return anotherMethod(tree.right, target, min );
		}
		else if(target < tree.value && tree.left != null  ){
			// left
			return anotherMethod(tree.left, target, min );
		}
		else{
			return (int)min;	
		}
		
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
