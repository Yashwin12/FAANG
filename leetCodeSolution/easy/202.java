// HACK: https://www.youtube.com/watch?v=gW4hSbRoQoY
// class Solution {     
//     public boolean isHappy(int n) {
//         Set<Integer> seen = new HashSet<>();
            
//         while ( n != 1 ){
//             int sum = 0;
            
//             // Below while loop is to calculate sum 
//             while ( n != 0 ) {
//                 sum +=  Math.pow(n % 10, 2);
//                 n = n /10;                
//             }
            
//             if ( seen.contains(sum) )
//                 return false;
            
//             seen.add( sum );
//             n = sum;                
//         }
//         return true;
//     }
   
// }

// 2) Very IMPORTANT way and algo 
// NAME OF THE ALGORITHM: tortoise and the hare algorithm OR Floyd's algorithm 
// ALGORITHM WORKING HACK: https://www.youtube.com/results?search_query=tortoise+and+the+hare+algorithm 

// FINDING CYCLE IN LINKED LIST: https://www.youtube.com/watch?v=MFOAbpfrJ8g

// SOLUTION HACK: https://leetcode.com/problems/happy-number/discuss/451908/JAVA-SOLUTION-%2B-EXPLANATION
class Solution {
     
    public boolean isHappy(int n) {
        int slow = n;
        int fast = getSum( n );
                
        while ( fast != 1 && slow != fast ){
            slow = getSum( slow );
            fast = getSum( fast );
            fast = getSum( fast );
            if( slow == fast )
                return false;            
        }        
        return true;
    }
   
    public int getSum( int n ){
        int sum = 0;
        while ( n != 0 ) {
            sum +=  Math.pow(n % 10, 2);
            n = n /10;                
        }        
        return sum;
    }
}