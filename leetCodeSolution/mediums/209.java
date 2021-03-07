// class Solution {
//     public int minSubArrayLen(int target, int[] nums) {

//         int globalMinCounter = Integer.MAX_VALUE;

//         for( int i = 0; i < nums.length - 1; i++){
//             int currentSum = nums[i];
//             for( int j = i+1; j < nums.length; j++){
//                 if( nums[i] >= target || nums[j] >= target )
//                     return 1; 

//                 currentSum += nums[j];

//                 if( currentSum >= target ){
//                     globalMinCounter = Math.min( (j - i) + 1, globalMinCounter );    
//                     break;
//                 }
//             }
//         }

//         return globalMinCounter == Integer.MAX_VALUE ? 0: globalMinCounter;
//     }
// }

class Solution {
    public int minSubArrayLen(int target, int[] nums) {

        int currentSum = 0;
        int left = 0;
        int minLength = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {

            currentSum += nums[i];

            while (currentSum >= target) {
                minLength = Math.min(minLength, i - left + 1);
                currentSum -= nums[left];
                left++;
            }
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}