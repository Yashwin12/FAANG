class Solution {
    // UNIQUE
    // HACK: https://www.youtube.com/watch?v=a_3XDW9P47E
    public int longestPalindrome(String s) {
        
        // ASCII range is from 0 - 127 
        int[] count = new int[128];
        for ( char c: s.toCharArray() )
            count[c]++;
        
        int result = 0;
        for ( int c: count ){
            result += ( c / 2 ) * 2; // This would add an ordered pair to the result
            
            // Below if condition would check if the result have already taken consideration of a middle odd chracter and the current count is odd or not. 
            if ( result % 2 == 0 && c % 2 == 1 )
                result++;        
        }        
        return result;        
    }
}