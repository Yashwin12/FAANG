// 1) T: O(N) | S: O(N)
// class Solution {
//     public boolean isPalindrome(int x) {
//         if( x < 0)
//             return false;
        
//         String str = x + "";
//         int left = 0;
//         int right = str.length() - 1;
    
//         while( left < right )
//             if( str.charAt( left++ ) != str.charAt( right-- )  )
//                 return false;
                        
//         return true;
//     }
// }


// T: O(N) | S: O(1). This solution MIGHT run into integer OVERFLOW.
// class Solution {
//     public boolean isPalindrome(int x) {
//         if( x < 0)
//             return false;
        
//         int sum = 0;
//         int target = x;
//         while ( x > 0 ){
            
//             int temp = x % 10;
//             x /= 10;            
//             sum = sum * 10 + temp;
//         }
//         return sum == target;
//     }
// }

// T: O(N) | S: O(1). This solution would never run into integer OVERFLOW as we would revert only half of the int number.
class Solution {
    public boolean isPalindrome(int x) {
        // All negative numbers are not Palindrome 
        //Also if the last digit of the number is 0, in order to be a palindrome, the first digit of the number also needs to be 0. Only 0 satisfy this property.
        if( x < 0 || ( x % 10 == 0 && x != 0 ) )
            return false;
        
        int revertedNum = 0;
        
        while ( x > revertedNum ){            
            revertedNum = x % 10 + revertedNum * 10;
            x /= 10;                        
        }
        // When the length is an odd number, we can get rid of the middle digit by revertedNumber/10
        return x == revertedNum || x == revertedNum /10 ;
    }
}