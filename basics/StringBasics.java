
public class StringBasics {
    public static void main (String[] args){
        
        String str1 = "This is just a single sentence";
        String str2 = "This is a different sentence";

        // 1) Compares this string to the specified object. The result is true if and only if the argument is not null and is a String object that represents the same sequence of characters as this object.
        str1.equals(str2);

        //Compares this String to another String, ignoring case considerations. Two strings are considered equal ignoring case if they are of the same length and corresponding characters in the two strings are equal ignoring case.
        str1.equalsIgnoreCase(str2);

        //2) Splits this string around matches of the given regular expression.
        str1.split(" ");  // Splits the str1 with a space and returns array. 
        
        // limit > 0 : If this is the case then the pattern will be applied at most limit-1 times, the resulting array’s length will not be more than n, and the resulting array’s last entry will contain all input beyond the last matched pattern.
        str1.split(regex, limit);

        //3) Returns the char value at the specified index.
        str1.charAt(index);

        // 4)  Returns: A) value 0 if the argument string is equal to this string; exactly when the equals(Object) method would return true
        // B) a value less than 0 if this string is lexicographically less than the string argument; 
        // C) a value greater than 0 if this string is lexicographically greater than the string argument.
        str1.compareTo(str2);

        str1.compareToIgnoreCase(str2);

        // 5) Returns true if and only if this string contains the specified sequence of char values
        str1.contains(substring);

        // 6) 
        str1.concat(str2);

        // 7) Returns the index within this string of the FIRST occurrence of the specified substring.
        str1.indexOf(str)

        // Returns the index within this string of the first occurrence of the specified character, starting the search at the specified index.
        str1.indexOf(str, fromIndex)

        // 9) Tells whether or not this string matches the given regular expression.
        str1.matches(regex)

        // 10) Replaces each substring of this string that matches the literal target sequence with the specified literal replacement sequence. The replacement proceeds from the beginning of the string to the end, for example, replacing "aa" with "b" in the string "aaa" will result in "ba" rather than "ab".
        str1.replace(target, replacement)

        str1.replace(oldChar, newChar)

        // str1.replaceAll("\\s", ""); Removes all the spaces from the str1. 
        str1.replaceAll(regex, replacement)

        str1.replaceFirst(regex, replacement);

        // 11) Returns a string that is a substring of this string. The substring begins with the character at the specified index and extends to the end of this string.
        str1.substring(beginIndex);

        //Returns a string that is a substring of this string str1. The substring begins at the specified beginIndex and extends to the character at index endIndex - 1. Thus the length of the substring is endIndex-beginIndex.
        str1.substring(beginIndex, endIndex);  
    }
}