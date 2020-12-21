import java.util.*;

// IMPORTANT, TRICKY AND HARD
// T: O(n) | 
// Avg => S: O( log(n)); Worst (When the tree is skewed) => O(d)
class Program {

    public static int maxPathSum(BinaryTree tree) {
        List<Integer> maxSumArray = helperMethod(tree);
        return maxSumArray.get(1);
    }

    private static List<Integer> helperMethod(BinaryTree tree) {
        if (tree == null)
            return new ArrayList<Integer>(Arrays.asList(0, Integer.MIN_VALUE));

        List<Integer> leftsideMax = helperMethod(tree.left);
        int leftMaxSumAsBranch = leftsideMax.get(0);
        int leftMaxPathSum = leftsideMax.get(1);

        List<Integer> rightsideMax = helperMethod(tree.right);
        int rightMaxSumAsBranch = rightsideMax.get(0);
        int rightMaxPathSum = rightsideMax.get(1);

        int maxSideAsBranch = Math.max(leftMaxSumAsBranch, rightMaxSumAsBranch);

        int maxSumWithBranch = Math.max(maxSideAsBranch + tree.value, tree.value);

        int maxSumAsTriangle = Math.max(maxSumWithBranch, leftMaxSumAsBranch + tree.value + rightMaxSumAsBranch);

        int maxPathSum = Math.max(leftMaxPathSum, Math.max(rightMaxPathSum, maxSumAsTriangle));

        return new ArrayList<Integer>(Arrays.asList(maxSumWithBranch, maxPathSum));
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
