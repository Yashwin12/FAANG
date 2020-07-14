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