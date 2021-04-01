/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
// class BSTIterator {
// List<Integer> inOrderList = new ArrayList<>();
// int currentIdx = 0;

// public BSTIterator(TreeNode root) {
// inOrderTraversal( root );
// }

// private void inOrderTraversal( TreeNode root ){
// if( root == null )
// return;
// inOrderTraversal( root.left );
// inOrderList.add( root.val );
// inOrderTraversal( root.right );
// }

// public int next() {
// int returnVal = inOrderList.get( currentIdx );
// currentIdx++;
// return returnVal;
// }

// public boolean hasNext() {
// return inOrderList.size() > currentIdx;
// }
// }


// 2) T: O(1) | S: O(h); where h = avg height of the tree. 
class BSTIterator {
    private Stack<TreeNode> stack = new Stack<>();

    public BSTIterator(TreeNode root) {

        partialInorder(root);
    }

    private void partialInorder(TreeNode root) {

        while (root != null) {
            stack.add(root);
            root = root.left;
        }

    }

    public int next() {
        TreeNode top = stack.pop();
        partialInorder(top.right);
        return top.val;
    }

    public boolean hasNext() {
        return stack.size() > 0;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such: BSTIterator
 * obj = new BSTIterator(root); int param_1 = obj.next(); boolean param_2 =
 * obj.hasNext();
 */