// HACK: https://www.youtube.com/watch?v=DJ4a7cmjZY0&t=192s

// For folks who still don't understand the intuition behind "table[row][col - coins[row-1]" and "table[row-1][col]"

// Amount 5, with coins [1,2].
// There are 3 ways:

// [1+1+1+1+1] 
// [1+1+1+2]
// [2+2+1] 

// Can be broken down as: 

// With 2:
// Deduct 2 from amount 5, then you have. sub problem which is:
// Amount 3, with coins [1,2]
// [1+1+1] = 3. Now just add 2 to it ==> [1+1+1+2] = 5
// [2+1] = 3. Now just add 2 to it ==> [2+1+2] = 5

// Without 2:
// [1+1+1+1+1]

// 1) T: O (denoms * n); S: O(denoms * n)
// class Program {
//     public static int numberOfWaysToMakeChange(int n, int[] denoms) {

//         int[][] mat = new int[denoms.length + 1][n + 1];

//         for (int i = 0; i <= denoms.length; i++) {
//             mat[i][0] = 1;
//         }

//         for (int row = 1; row <= denoms.length; row++) {
//             for (int col = 1; col <= n; col++) {

//                 if (col >= denoms[row - 1]) {
//                     mat[row][col] = mat[row - 1][col] + mat[row][col - denoms[row - 1]];
//                 } else {
//                     mat[row][col] = mat[row - 1][col];
//                 }
//             }
//         }
//         return mat[denoms.length][n];
//     }
// }

// The below method is similar to algoexperts'
// 2) T: O(denoms * n) | S: O(n); where n = target value.
class Program {
    public static int numberOfWaysToMakeChange(int n, int[] denoms) {
        int[] ways = new int[n + 1];
        ways[0] = 1;

        for (int i = 0; i < denoms.length; i++) {
            for (int amount = 0; amount < ways.length; amount++) {

                if (amount >= denoms[i]) {
                    ways[amount] += ways[amount - denoms[i]];
                }
            }
        } 
        return ways[n];
    }
}
