public class StringBuilderBasics {

    // The StringBuilder represents a MUTABLE sequence of characters. String Class in Java creates an IMMUTABLE sequence of characters, the StringBuilder class provides an alternative to String Class, as it creates a mutable sequence of characters.

    // StringBuffer - mutable and synchronized as well. (Slower)
    // StringBuilder  - mutable but not synchronized by default. ( Faster )
    public static void main(String[] args) {

        StringBuilder str = new StringBuilder();

        // 1) Appends the specified string to this character sequence. If str is null, then the four characters "null" are appended.        
        str.append("GFG"); // Need to convert toString in order to use it as a string.
        
        // print string 
        System.out.println( "String = " + str.toString() ); 

        // 2) Initialize stringbuilder 
        StringBuilder str1 = new StringBuilder("AAAABBBCCCC");

        // 3) Returns the char value in this sequence at the specified index. The first char value is at index 0, the next at index 1, and so on, as in array indexing.
        str1.charAt(index);

        // 4) Returns 0 if this StringBuilder contains the same character sequence as that of the argument StringBuilder; a negative integer if this StringBuilder is lexicographically less than the StringBuilder argument; or a positive integer if this StringBuilder is lexicographically greater than the StringBuilder argument. 
        str1.compareTo(str);

        // 5) Removes the characters in a substring of this sequence. The substring begins at the specified start and extends to the character at index end - 1 or to the end of the sequence if no such character exists. If start is equal to end, no changes are made.
        str1.delete(start, end);

        // Removes the char at the specified position in this sequence. This sequence is shortened by one char.
        str1.deleteCharAt(index);

        // 6) Returns the length of this character sequence
        str1.length();
        str1.reverse();
        str1.substring(start, end);
        
    }
}