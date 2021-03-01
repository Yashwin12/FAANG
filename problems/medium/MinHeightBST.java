import java.util.*;

class Program {
    public static BST minHeightBst(List<Integer> array) {

        return helperMethod(array, null, 0, array.size() - 1);
    }


    // 1): T: O( n * log(n)) | S: O(n)
    // log(n) = because to insert a node in BST, it takes log*n time.
    public static BST helperMethod(List<Integer> array, BST tree, int startIdx, int endIdx) {
        if (startIdx > endIdx)
            return null;

        int mid = startIdx + (endIdx - startIdx) / 2;

        if (tree == null) {
            tree = new BST(array.get(mid));
        } else {
            tree.insert(array.get(mid));
        }

        helperMethod(array, tree, startIdx, mid - 1);
        helperMethod(array, tree, mid + 1, endIdx);

        return tree;
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
            left = null;
            right = null;
        }

        public void insert(int value) {
            if (value < this.value) {
                if (left == null) {
                    left = new BST(value);
                } else {
                    left.insert(value);
                }
            } else {
                if (right == null) {
                    right = new BST(value);
                } else {
                    right.insert(value);
                }
            }
        }
    }
}



public static BST minHeightBst(List<Integer> array) {
		
    return helperMethod( array, 0, array.size() - 1);
  }
	// 2): T: O(n) | S: O(n)
	public static BST helperMethod(List<Integer> array, int startIdx, int endIdx){
		if( startIdx > endIdx )
			return null;
		
		int mid = startIdx + (endIdx - startIdx)/2;
		
		BST tree = new BST( array.get(mid) );
		
		tree.left = helperMethod( array, startIdx, mid - 1 );
		tree.right = helperMethod( array, mid + 1, endIdx );
		
		return tree;
    }
