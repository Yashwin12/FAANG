// 1) Brute Force
// class Solution {
//     public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        
//         int[] result = new int[nums1.length];
//         for ( int left = 0; left < nums1.length; left++){
//             int right = 0;
//             int tempPtr = Integer.MAX_VALUE;
//             while ( right < nums2.length ){
                
//                 if( nums1[left] == nums2[right] )
//                     tempPtr = right;
                                                            
//                 if ( right != nums2.length - 1 && tempPtr <= right && nums1[left] < nums2[right + 1] ){
//                     result[left] = nums2[right+1];
//                     break;
//                 }                
//                 else
//                     result[left] = -1;
//                 right++;
//             }            
//         }
        
//         return result;
//     }
// }

// 2) Smart and UNIQUE solution
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        
        Map<Integer, Integer> map = new HashMap<>();     
        Stack<Integer> stack = new Stack<>();
        
        for( int num: nums2){
            while( stack.size() > 0 && stack.peek() < num )
                map.put( stack.pop() , num );   
          
            stack.push( num );
        }
          
        for ( int i =0; i < nums1.length; i++ )
            nums1[i] = map.getOrDefault( nums1[i], -1 );
                    
        return nums1;
    }
}