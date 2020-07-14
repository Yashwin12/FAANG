// 1) Inefficient solution, doesnt pass the test cases. 
// Brute Force. T: O(n^2) | S: O(1)
// class Solution {
//     public int numPairsDivisibleBy60(int[] time) {
        
//         int output =0;
        
//         for ( int i =0; i < time.length; i++ ){
//             int ptr = i+1;
            
//             while( ptr < time.length ){
//                 if ( ( time[ptr++] + time[i] ) % 60 == 0 )
//                     output++;
//                 // ptr++;
//             }
//         }
        
//         return output;
//     }
// }

// 2) S: O(N) | T: O(N). Smart technique.
// class Solution {
//     public int numPairsDivisibleBy60(int[] time) {
        
//         int ans = 0;
//         // ( remainder, count )
//         // 100 and 40 => would be stored as one key bc 100 % 60 == 40 % 60;
//         Map<Integer, Integer> map = new HashMap<>();
        
//         for( int i =0; i < time.length; i++ ){
//             int remainder = time[i] % 60;
//             ans += map.getOrDefault( ( 60 - remainder ) % 60, 0 );
            
//             map.put( remainder, map.getOrDefault( remainder, 0 ) + 1 );
//         }
//         return ans;
//     }
// }

// 3) S: O(N) | T: O(N)
class Solution {
public int numPairsDivisibleBy60(int[] time) {
        int c[]  = new int[60], 
        int res = 0;
        for (int t : time) {
            res += c[ (600 - t) % 60];
            c[t % 60] += 1;
        }
        return res;
    }
}