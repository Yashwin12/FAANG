class Solution {
//     public boolean isPalindrome(String s) {
        // 1) Using Regex
//         // HACK: regex Tutorial: https://www.youtube.com/watch?v=rhzKDrUiJVk&list=PLWcl4ShBdNqLnxXFc1YKq45C9wJTRyzzu&index=7&t=771s
//         String actual = s.replaceAll( "[^a-zA-Z0-9]", "" ).toLowerCase();
//         String reverse = new StringBuilder(actual).reverse().toString();
//         return actual.equals(reverse);        
//     }
    
    // 2) Using Regex
//         public boolean isPalindrome(String s) {
        
//         // The below regex checks for the not-word !
//         s = s.replaceAll( "\\W+", "" ).toLowerCase();
//         return s.equals(new StringBuilder(s).reverse().toString());        
//     }
    
    // 3) Using Regex & pointers
//     public boolean isPalindrome(String s) {
        
//         if( s.length() == 0 )
//             return true;
        
//         s = s.replaceAll( "\\W+", "" ).toLowerCase();
        
//         int left = 0;
//         int right = s.length() -1;
    
//         while( left <= right ){
//             char chL = s.charAt(left);
//             char chR = s.charAt(right);
            
//             if( chL != chR )
//                 return false;
            
//             left++;
//             right--;                
//         }
//         return true;
//     }
// }
    
    // // Using two pointers
    public boolean isPalindrome(String s) {
        
        if( s.length() == 0 )
            return true;
                
        int left = 0;
        int right = s.length() -1;
        char chL;
        char chR;
    
        while( left <= right ){
            chL = s.charAt(left);
            chR = s.charAt(right);
            
            if( !Character.isLetterOrDigit(chL) )
                left++;
            
            else if( !Character.isLetterOrDigit(chR) )
                right--;
            
            else {
                if( Character.toLowerCase(chL) != Character.toLowerCase(chR) )
                    return false;
                
                left++;
                right--;
            }                   
        }
        return true;
    }
}