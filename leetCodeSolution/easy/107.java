/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        if (root == null)
            return new ArrayList<>();

        List<List<Integer>> finalList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();

        queue.offer(root);

        while (!queue.isEmpty()) {

            int currentLevelSize = queue.size();
            List<Integer> list = new ArrayList<>();

            for (int i = 0; i < currentLevelSize; i++) {
                TreeNode current = queue.poll();

                if (current.left != null)
                    queue.offer(current.left);

                if (current.right != null)
                    queue.offer(current.right);

                list.add(current.val);
            }

            if (list.size() > 0)
                finalList.add(0, list);

        }

        return finalList;
    }
}