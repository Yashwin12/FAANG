import java.util.*;

// WRONG WAY: Keeping track of the chars in a map would be wrong as it would not be able to handle string = "aAaAaaaaaAaaaAAAABbbbBBBB" => This would treat all 'a's & 'A's as a single unit and  output would be wrong.

// RIGHT WAY:
class Program {

    // S: O(n) | T: O(n), where n is length of the string.
    public String runLengthEncoding(String string) {
        int idx = 1;
        char prevChar;
        int count = 1;
        StringBuilder sb = new StringBuilder();
        while (idx < string.length()) {

            prevChar = string.charAt(idx - 1);

            if (prevChar != string.charAt(idx) || count == 9) {
                sb.append(count);
                sb.append(prevChar);
                count = 0;
            }
            count++;
            idx++;
        }

        sb.append(count);
        sb.append(string.charAt(string.length() - 1));

        return sb.toString();
    }
}
