// class Program {
//   public static boolean isPalindrome(String str) {
		
// 		// 1) T: O(n): S: O(1)
// 		int left = 0;
// 		int right = str.length() - 1;
// 		boolean flag = false;
		
// 		while(left <= right){
// 			if(str.charAt(left) == str.charAt(right)){
// 				left++;
// 				right--;
// 				flag = true;
// 			}
// 			else{
// 				flag = false;
// 				break;
// 			}
// 		}
// 		return flag;
//   }
// }

// 2) T: O(n^2) | S: O(n)
// Time complexity is O(n^2) bc Strings are immutable in java, so each time adding a new char makes a new String. 
// class Program {
//   public static boolean isPalindrome(String str) {		
// 		String reverseStr = "";
// 		for ( int i = str.length() - 1; i >= 0; i-- ){
// 			reverseStr += str.charAt(i);
// 		}
		
// 		return str.equals(reverseStr);
//   }
// }

// 3) T: O(n) |S: O(n)
// class Program {
//   public static boolean isPalindrome(String str) {
// 		String reverseStr = new StringBuilder(str).reverse().toString();
// 		//String reverseStr = new StringBuilder(str).reverse().toString();
// 		boolean flag = false;
// 		if(str.equals(reverseStr)){
// 			flag = true;
// 		}
// 		return flag;
//   }
// }

// Recursive function. T: O(n) | S: O(n)
// class Program {
//   public static boolean isPalindrome(String str) {
// 		return isPalindromeHelper(str, 0);  
// 	}
	
// 	public static boolean isPalindromeHelper(String str, int i ){
// 		int j = str.length() - i - 1;
// 		return i >= j ? true: str.charAt(i) == str.charAt(j) && isPalindromeHelper( str, i + 1);
// 	}
// }