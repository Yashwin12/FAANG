//1 ) Code with lil boilerplate
// import java.util.*;

// // //O(n) | S: O(n)
// class Program {
//     public static boolean balancedBrackets(String str) {
//         char[] openBrackets = { '(', '[', '{' };
//         char[] closeBrackets = { ')', ']', '}' };

//         Stack<Character> stack = new Stack<>();

//         int count = 0;
//         while (str.length() != count) {
//             if (insertable(str.charAt(count), openBrackets)) {
//                 stack.push(str.charAt(count));
//             } else if (insertableClose(str.charAt(count), closeBrackets)) {

//                 if (stack.isEmpty()) {
//                     return false;
//                 }
//                 char temp = stack.peek();

//                 if (str.charAt(count) == closeBrackets[0] && openBrackets[0] == temp) {
//                     stack.pop();
//                 } else if (str.charAt(count) == closeBrackets[1] && openBrackets[1] == temp) {
//                     stack.pop();
//                 } else if (str.charAt(count) == closeBrackets[2] && openBrackets[2] == temp) {
//                     stack.pop();
//                 } else {
//                     return false;
//                 }
//             }

//             count++;
//         }
//         return stack.size() == 0;
//     }

//     //O(1) | S: O(1)
//     public static Boolean insertable(char ch, char[] openBrackets) {
//         for (char openChar : openBrackets) {
//             if (openChar == ch) {
//                 return true;
//             }
//         }

//         return false;
//     }

//     //O(1) | S: O(1)
//     public static Boolean insertableClose(char ch, char[] closeBrackets) {
//         for (char closeChar : closeBrackets) {
//             if (closeChar == ch) {
//                 return true;
//             }
//         }

//         return false;
//     }

// }


import java.util.*;

// 2) O(n) | S: O(n)
class Program {
  public static boolean balancedBrackets(String str) {
    // Write your code here.
		String openingBrackets = "({[";
		String closingBrackets = ")}]";
		Map<Character, Character> matchingBrackets = new HashMap<>();
		
		matchingBrackets.put(')', '(');
		matchingBrackets.put('}', '{');
		matchingBrackets.put(']', '[');
		
		Stack<Character> stack = new Stack<Character>();
		
		for ( int i = 0; i < str.length(); i++){
			char letter = str.charAt(i);
			
			if( openingBrackets.indexOf(letter) != -1 ){
				stack.push( letter );
			}
			else if( closingBrackets.indexOf(letter) != -1 ) {
				
				if( stack.isEmpty() ){
					return false;
				}
				if( stack.peek() == matchingBrackets.get(letter) ){
					stack.pop();
				}
				else{
					return false;
				}
			}
		}
		
    return stack.size() == 0;
  }
}
