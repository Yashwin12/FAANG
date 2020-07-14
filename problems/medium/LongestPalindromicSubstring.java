// class Program {
//     //1) T: O(n^3) | S: O(1)
//     public static String longestPalindromicSubstring(String str) {

//         String returnString = "";
//         for (int i = 0; i < str.length(); i++) {
//             for (int j = str.length() - 1; j >= i; j--) {

//                 if (isPalindrome(str, i, j)) {
//                     String tempStr = str.substring(i, j + 1);

//                     if (returnString.length() < tempStr.length()) {
//                         returnString = tempStr;
//                     }

//                 }
//             }

//         }
//         return returnString;
//     }

//     public static Boolean isPalindrome(String str, int left, int right) {
//         while (left <= right) {
//             if (str.charAt(left) != str.charAt(right)) {
//                 return false;
//             }
//             left++;
//             right--;
//         }
//         return true;
//     }

// }

// 2)  T: O(n^2) | S: O(1);
class Program {
    public static String longestPalindromicSubstring(String str) {
        int[] currentLongest = { 0, 1 };
        for (int i = 1; i < str.length(); i++) {
            int[] odd = getLongestPalindrome(str, i - 1, i + 1);
            int[] even = getLongestPalindrome(str, i - 1, i);
            int[] longestBwOddAndEven = odd[1] - odd[0] > even[1] - even[0] ? odd : even;
            currentLongest = currentLongest[1] - currentLongest[0] > longestBwOddAndEven[1] - longestBwOddAndEven[0]
                    ? currentLongest
                    : longestBwOddAndEven;
        }
        return str.substring(currentLongest[0], currentLongest[1]);
    }

    public static int[] getLongestPalindrome(String str, int left, int right) {
        while (left >= 0 && right < str.length()) {
            if (str.charAt(left) != str.charAt(right)) {
                break;
            }
            left--;
            right++;
        }
        // +1 is added to the left bc the "while" or "if" condition might not satisfy.
        // So we want to make
        // sure it comes back to the correct position. For example 'highnoon' string and
        // on i = 6,
        // odd = getLongestPalindrome( 5, 7); -> If condition would be false and +1
        // would return the [6,7]; The reason there is no change in the right becasue
        // substring method on it would be exclusive.
        return new int[] { left + 1, right };
    }

}
