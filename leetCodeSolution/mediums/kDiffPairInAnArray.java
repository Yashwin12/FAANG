// 1) Optimal: T:O(n)| S: O(n)
// class Solution {
//     public int findPairs(int[] nums, int k) {
//         Map<Integer, Integer> map = new HashMap<>();
        
//         for( int num: nums ){
//             map.put( num, map.getOrDefault(num, 0) + 1 );
//         }
        
//         int counter = 0;
//         for( int num: nums ){
//             if( k == 0 && map.get(num) >= 2 ){
//                 map.replace(num,0);
//                 counter++;
//             }
//             else if( k > 0 && map.containsKey( num + k) && map.get( num + k) > 0 ){               
//                 map.replace(num + k, 0);
//                  counter++;
//             }
            
//         }
        
//         return counter;
//     }
// }

// 2) Less Optimal: T:O(n * logn)| S: O(1)
class Solution {
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        
        int counter = 0;
        
        for( int left = 0; left < nums.length; left++){
            if( left > 0 && nums[left] == nums[left-1])
                continue;
             
            int right = nums.length - 1;           
            
            while( right > left ){
                 int currentDiff = Math.abs(nums[left] - nums[right]);
                if( currentDiff == k ){                    
                    counter++;
                    break;
                }
                    
                else if( currentDiff > k )
                    right--;
                else
                    break;
                
            }
        }
    
        return counter;
    }
}