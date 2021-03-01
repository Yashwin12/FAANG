// 1) Brute Force
// class Solution {
//     public int maxProfit(int[] prices) {

//         int globalMax = Integer.MIN_VALUE;

//         for( int i = 0; i < prices.length; i++ ){
//             int currentMax = 0;
//             for( int j = i + 1; j < prices.length; j++ ){
//                 currentMax = Math.max( currentMax, prices[j] - prices[i]);
//                 globalMax = Math.max(globalMax, currentMax);
//             }
//         }

//         return globalMax == Integer.MIN_VALUE ? 0: globalMax;
//     }
// }

// 2) One pass solution
class Solution {
    public int maxProfit(int[] prices) {
        int peak = Integer.MIN_VALUE;
        int valley = Integer.MAX_VALUE;
        int globalMax = 0;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < valley) {
                valley = prices[i];
                peak = -1;
            } else if (prices[i] > peak) {
                peak = prices[i];
                globalMax = Math.max(globalMax, peak - valley);
            }

        }

        return globalMax;

    }
}