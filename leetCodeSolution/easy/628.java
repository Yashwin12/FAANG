// 1) S: O(n^2) | T: O(1)
// class Solution {
//     public int maximumProduct(int[] nums) {
//         Arrays.sort(nums);        
//         int maxProduct = Integer.MIN_VALUE;
        
//         for( int i =0; i < nums.length; i++ ){
//             int left = i + 1;
//             int right = nums.length - 1;
           
//             while ( left < right ){
//                 int currentProduct = nums[i] * nums[left] * nums[right];
                                 
//                 if( currentProduct > maxProduct ){
//                     maxProduct = currentProduct;
//                     left++;
//                 }                                        
//                 else if( nums[left] == 0 || currentProduct < 0 )
//                     left++;
//                 else
//                     right--;
//             }
//         }
//         return maxProduct;
//     }
// }

// 2) T: O(n*logn) | S:O(1)
// class Solution {
//     public int maximumProduct(int[] nums) {
//         Arrays.sort(nums);        

//         return Math.max( nums[0]*nums[1]*nums[nums.length - 1], nums[nums.length - 3]*nums[nums.length - 2]*nums[nums.length - 1] );
//     }
// }


// 3) T: O(n) | S:O(1)
class Solution {
    public int maximumProduct(int[] nums) {
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;
        
        int min1 =Integer.MAX_VALUE;
        int min2 =Integer.MAX_VALUE;
        
        for( int ele: nums ){
            
            if( max1 < ele ){
                max3 = max2;
                max2= max1;
                max1 = ele;                
            }                            
            else if( max2 < ele ){
                max3 = max2;
                max2 =ele;
            }
                        
            else if( max3 < ele )
                max3 = ele;
            
            if( min1 > ele ){
                min2 = min1;
                min1 = ele;
            }
            
            else if( min2 > ele )
                min2 = ele;            
        } 
        
        return Math.max( min1 * min2 * max1, max1 * max2 * max3 );
    }
}
