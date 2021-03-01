/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null)
            return new ArrayList<>();

        List<List<Integer>> finalList = new ArrayList<>();

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        List<Integer> list = new ArrayList<>();
        int currentQueueSize = queue.size();
        while (!queue.isEmpty()) {

            TreeNode current = queue.poll();

            if (current != null) {
                if (current.left != null) {
                    queue.offer(current.left);
                }

                if (current.right != null) {
                    queue.offer(current.right);
                }

                list.add(current.val);
            }

            if (list.size() > 0 && list.size() == currentQueueSize) {
                finalList.add(list);
                list = new ArrayList<>();
                currentQueueSize = queue.size();
            }
        }

        return finalList;

    }
}