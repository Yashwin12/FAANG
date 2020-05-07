//1)
//class Solution {
//     public int findMaxConsecutiveOnes(int[] nums) {

//         int maxOne = 0;        
//         int currentCount = 0;
        
//         for ( int i =0; i < nums.length; i++){
//             if( nums[i] == 1){
//                 currentCount++;
//                 maxOne = Math.max(maxOne, currentCount);
//             }
//             else
//                 currentCount = 0;
//         }

//         return maxOne;
//     }
// }

//2)
// class Solution {
//     public int findMaxConsecutiveOnes(int[] nums) {

//         int[] dp = new int[nums.length];
        
//         dp[0] = nums[0] == 1 ? 1: 0; 
        
//         int max = dp[0];
            
//         for ( int i =1; i < nums.length; i++){
//             if( nums[i] == 1){
//                 dp[i] = dp[i -1] + 1;
//                 max = Math.max ( max, dp[i] );
//             }                
//             else
//                 dp[i] = 0;                
//         }                        
//         return max; 
//     }
// }

// 3)
// class Solution {
//     public int findMaxConsecutiveOnes(int[] nums) {
//         // declare a counter to keep highest number of 1s till the current position
//         int count = 0;
//         int[] dp = new int [nums.length];
//         dp[0] = 0;
        
// 	// if first element is 1 adjust your dp array accordingly
//         if (nums[0] == 1){
//             dp[0] = 1;
//             count = 1;
//         }
//         // if array element is 1 increament the count by 1 and propogate max to dp[next]
//         for (int i=1;i<nums.length;i++) {
//             if (nums[i] == 1) {
//                 count+= 1;
//                 dp[i] = Math.max(count, dp[i-1]);
//             } else {
//                 dp[i] = dp[i-1];
//                 count = 0;
//             }
//         }
// 				// return answer
//         return dp[nums.length - 1];
        
//     }
// }

// 4)
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        // We dont need an array. We'd be referring to the previousElement in our imaginary DP array. Thus the space comlexity drops to O(1) from O(n).
        int previousEle = nums[0] == 1 ? 1 : 0;
        int count = previousEle;
                
        for (int i=1;i<nums.length;i++) {
            
            if (nums[i] == 1) {
                count+= 1;
                previousEle = Math.max(count, previousEle);
            } 
            else 
                count = 0;            
        }
        return previousEle;        
    }
}