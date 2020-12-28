// 1) Brute Force: T: O(n^2) | S: O(n)
// class Solution {
//     public int maxSubArray(int[] nums) {

//         int globalMax = Integer.MIN_VALUE;
//         for( int i = 0; i < nums.length; i++){
//             int currentSum = 0;
//             for( int j = i; j < nums.length; j++){
//                 currentSum += nums[j];
//                 globalMax = Math.max( globalMax, currentSum ); 
//             }
//         }

//         return globalMax;
//     }
// }

// 2) DP with Linear space: T: O(n) | S: O(n)
// class Solution {
//     public int maxSubArray(int[] nums) {

//         if( nums.length == 1)
//             return nums[0];

//         int globalMax = nums[0];
//         int[] dp = new int[nums.length];
//         dp[0] = nums[0];

//         for( int i = 1; i < nums.length; i++){
//             dp[i] = Math.max( nums[i], nums[i] + dp[i-1]);
//             globalMax = Math.max( globalMax, dp[i]);
//         }

//         return globalMax;
//     }
// }


// 3) DP with constant space: T: O(n) | S: O(1)
class Solution {
    public int maxSubArray(int[] nums) {

        if (nums.length == 1)
            return nums[0];

        int globalMax = nums[0];
        int dpMinusOne = nums[0];

        for (int i = 1; i < nums.length; i++) {
            dpMinusOne = Math.max(nums[i], nums[i] + dpMinusOne);
            globalMax = Math.max(globalMax, dpMinusOne);
        }

        return globalMax;
    }
}