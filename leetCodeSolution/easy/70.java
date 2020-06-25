// 1) T: O(N) | S: O(N)
// class Solution {
//     public int climbStairs(int n) {
//         int[] ways = new int[ n + 1];
//         ways[0] = 1;
//         ways[1] = 1;
        
//         for ( int i = 2; i <= n; i++ )
//             ways[i] = ways[i-1] + ways[i-2];     
         
//         return ways[n];
//     }
// }

// 2) T: O(N) | S: O(1)
// class Solution {
//     public int climbStairs(int n) {
        
//         if( n == 0 || n == 1 )
//             return 1;
            
//         int oneStepBefore = 1;
//         int twoStepBefore = 1;
//         int currentStep = 0;
                
//         for ( int i = 2; i <= n; i++ ){
//             currentStep = oneStepBefore + twoStepBefore; 
//             twoStepBefore = oneStepBefore;
//             oneStepBefore = currentStep;
//         }
                     
//         return currentStep;
//     }
// }


// 3) T: O (N) | S: O(N)
class Solution {
    Map<Integer, Integer> map = new HashMap<>();
    public int climbStairs(int n) {
       if ( n == 1 || n == 0 )
           return 1;
        
        if( map.containsKey(n) )
            return (int) map.get(n);
        
        int steps = climbStairs( n -1 ) + climbStairs( n -2 );
        map.put( n, steps );
        
        return steps;         
    }
}