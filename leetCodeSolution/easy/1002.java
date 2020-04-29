
// HACK: Solution https://www.youtube.com/watch?v=k1iowWJimbg
// HACK : What is ASCII ? youtube.com/watch?v=5aJKKgSEUnY
// HACK : How to play around with ASCII ? https://www.youtube.com/watch?v=f5NhecIlTSQ

// IMPORTANT AND UNIQUE
import java.util.*;
class Solution {
    public List<String> commonChars(String[] A) {
        
        List<String> outputList = new ArrayList<>();
        
        // Below array will keep track of the min number of common character in words of array A. 
        int[] minFrequency = new int[26];
        
        // Initialize to max infinity as we want to make the first word in array A as the base.
        Arrays.fill(minFrequency, Integer.MAX_VALUE);
        
        for (int i = 0; i < A.length; i++ ){
            
             //characters present in a single word will increment 1, rest of them would be 0.
            int[] charPresent = new int[26];
            
            for( char ch : A[i].toCharArray()){
                charPresent[ ch - 'a']++;
            } 
            
            for (int j = 0; j <26; j++){
                minFrequency[j] = Math.min( minFrequency[j], charPresent[j] );
            }

        }
        
        // At this point we have an array with all the common characters in the array of String  A.
        for (int i = 0; i <26; i++){
            
            // In the minFrequency of common char there can be more than 1 repition of a single character. minFrequency[i] would  be 2 for character 'l' in bella string.
            while( minFrequency[i] >0 ){
                outputList.add(  String.valueOf( (char) (i + 'a') ) );
                minFrequency[i]--;
            }
        }
        return outputList;
    }
    
}