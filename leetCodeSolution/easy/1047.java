// class Solution {
//     public String removeDuplicates(String S) {
          
//         int count = 0;

//         while (count >= 0 && count < S.length() - 1) {
//             if ( S.charAt( count ) == S.charAt(count + 1) ){
//             StringBuilder sb = new StringBuilder();

//                 sb.append(S);
//                 sb.deleteCharAt(count + 1);
//                 sb.deleteCharAt(count);
//                 S = sb.toString();
//                 count = 0;
//             }
//             else{
//                 count++;
//             }
//         }
   
//         return S;
//     }
// }

import java.util.*;
class Solution {
    public String removeDuplicates(String S) {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        
        for ( int i = 0; i < S.length(); i++ ){

            if( !stack.isEmpty() && stack.peek() == S.charAt(i) )
                stack.pop();            
            else
                stack.add( S.charAt(i) );      
        } 
        while(!stack.isEmpty())
            sb.append(stack.pop());
    
    // need to reverse it because we'd be popping last element first. Stack's LIFO property
    return sb.reverse().toString();
    }
}