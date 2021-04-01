// class Solution {
//     public int lengthOfLongestSubstring(String s) {
//         int globalMax = Integer.MIN_VALUE;
        
//         if( s.length() == 1 )
//             return 1;
        
//         if( s.length() == 2) {
//             if( s.charAt(0) == s.charAt(1) )
//                 return 1;
//             return 2;        
//         }
        
//         for( int i = 1; i < s.length() - 1; i++ ){
//             int left = i - 1;
//             int right = i + 1;
            
//             Set<Character> set = new HashSet<>();
//             set.add( s.charAt(i) );
//             set.add( s.charAt(left) );
//             set.add( s.charAt(right) );
            
//             int currentMin = set.size();
            
//             if( currentMin == 3 ){
                
//                 while( left > 0 && !set.contains( s.charAt(left - 1) ) ){
//                     left -= 1;     
//                     set.add( s.charAt(left) );
//                     currentMin++;
//                 }
                
//                 while( right < s.length() - 1 && !set.contains( s.charAt(right + 1) ) ){
//                     right += 1;    
//                     set.add( s.charAt(right) );
//                     currentMin++;
//                 }                                
//             }
            
//             globalMax = Math.max( globalMax, currentMin );
            
//         }
//         return globalMax == Integer.MIN_VALUE ? 0: globalMax ;
//     }
// }

// HACK: https://www.youtube.com/watch?v=3IETreEybaA
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0; 
        int right = 0;
        int globalMax = 0;
        
        Set<Character> set = new HashSet<>();
        
        while( right < s.length() ){
            if( !set.contains( s.charAt(right) ) ){
                set.add(s.charAt(right));
                right++;
                globalMax = Math.max( globalMax, set.size() );
            }
            else{
                set.remove(s.charAt(left));
                left++;
            }
        }
        return globalMax;
    }
}