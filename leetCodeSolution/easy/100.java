/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
// class Solution {
// public boolean isSameTree(TreeNode p, TreeNode q) {
// return compareBT ( p, q );
// }

// public Boolean compareBT( TreeNode p, TreeNode q ) {
// if ( p == null && q == null )
// return true;

// if( p == null || q == null )
// return false;

// if ( p.val != q.val )
// return false;

// return compareBT ( p.left, q.left ) && compareBT ( p.right, q.right );
// }

// }

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {

        Queue<TreeNode> qP = new LinkedList<>();
        Queue<TreeNode> qQ = new LinkedList<>();

        qP.offer(p);
        qQ.offer(q);

        while (!qP.isEmpty() && !qQ.isEmpty()) {

            TreeNode currentP = qP.poll();
            TreeNode currentQ = qQ.poll();

            if (currentP == null && currentQ == null)
                continue;

            if (currentP == null || currentQ == null)
                return false;

            if (currentP.val != currentQ.val)
                return false;

            qP.offer(currentP.left);

            qQ.offer(currentQ.left);

            qP.offer(currentP.right);

            qQ.offer(currentQ.right);
        }
        return true;
    }
}