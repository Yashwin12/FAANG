// 1) RECURSION Passed by value
// import java.util.*;

// class Program {

//     public static int nodeDepths(BinaryTree root) {
//         return helperMethod(root, 0, -1);
//     }

//     public static int helperMethod(BinaryTree root, int runningSum, int depth) {
//         if ( root == null)
//             return runningSum;

//         depth++;
//         runningSum += depth;

//         runningSum = helperMethod(root.left, runningSum, depth);
//         runningSum = helperMethod(root.right, runningSum, depth);

//         return runningSum;
//     }

//     static class BinaryTree {
//         int value;
//         BinaryTree left;
//         BinaryTree right;

//         public BinaryTree(int value) {
//             this.value = value;
//             left = null;
//             right = null;
//         }
//     }
// }


// 2) RECURSION Passed by reference
import java.util.*;

class Program {

    public static int nodeDepths(BinaryTree root) {
        int[] sum = { 0 };
        helper(root, 0, sum);
        return sum[0];
    }

    private static void helper(BinaryTree tree, int level, int[] sum) {
        if ( tree == null)
            return;

        sum[0] += level;
        level++;
        helper(tree.left, level, sum);
        helper(tree.right, level, sum);

    }

    static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }
}
