import java.util.*;

class Program {
  public static String caesarCypherEncryptor(String str, int key) {
		
		// T: O(n) | S: O(n)
		String alphabets = "abcdefghijklmnopqrstuvwxyz";	
		int newKey = key % 26;
		char[] newChar = new char[str.length()];
		for (int i = 0; i < str.length(); i++){
		
			newChar[i] += alphabets.charAt( ( alphabets.indexOf( str.charAt(i) ) + 
																		 newKey) % 26 );
		}
    return new String (newChar);
  }
}


import java.util.*;
// 2) Using ASCII 		
// T: O(n) | S: O(n)
class Program {
	public static String caesarCypherEncryptor(String str, int key) {

		int[] alphabets = new int[26];

		for (char ch : str.toCharArray()) {
			alphabets[ch - 'a'] = 1;
		}

		StringBuilder returnStr = new StringBuilder(); // Using StringBuilder as we would append letter and is efficient than String.

		for (int i = 0; i < alphabets.length; i++) {
			if (alphabets[i] == 1) {
				int idx = (i + key) % 26;
				returnStr.append((char) ('a' + idx));
			}
		}

		return returnStr.toString();
	}
}
