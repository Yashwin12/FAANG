import java.util.*;
public class CharacterBasics {
    public static void main(String[] args) {
        Character ch = new Character();
        ch = 'a';

        // 1) the value 0 if x == y; a value less than 0 if x < y; and a value greater than 0 if x > y
        ch.compareTo(anotherCharacter);

        ch.compare(x, y);

        // 2) Compares this object against the specified object. The result is true if and only if the argument is not null and is a Character object that represents the same char value as this object.
        ch.equals(obj);

        // 3) Returns a String object representing this Character's value.
        ch.toString();

        // 4) Converts the character argument to uppercase 
        Character.toUpperCase(ch);

        // Converts the character argument to lowercase 
        Character.toLowerCase(ch);

        // 5) A character is considered to be a letter or digit if either Character.isLetter(char ch) or Character.isDigit(char ch) returns true for the character.
        Character.isLetterOrDigit(ch);

        Character.isLetter(ch);

        Character.isDigit(ch);

        Character.isWhitespace(ch);

        Character.isUpperCase(ch);

        // (int) '1'  would bring the '1' in ASCII. 
        // the numeric value of the character, as a nonnegative int value;
        Character.getNumericValue('1');         
    }
}