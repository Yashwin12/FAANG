// class Solution {
//     public boolean wordPattern(String pattern, String s) {

//         if( pattern.length() != s.split( " ").length )
//             return false;

//         String[] words = s.split(" ");
//         Map<Character, String> map = new HashMap<>();
//         Map<String, Character> word = new HashMap<>();

//         int count = 0;
//         for( char ch : pattern.toCharArray() ){
//             String currentWord = words[count];

//             if( !map.containsKey(ch) ){
//                 if( word.containsKey( currentWord ) ){
//                     return false;
//                 }

//                 map.put( ch, currentWord );
//                 word.put( currentWord, ch );

//             }            
//             else if( !currentWord.equals( map.get(ch)) ) {
//                 return false;
//             }

//             count++;
//         }

//         return true;
//     }
// }

/** 
One thing about autoboxing. 
int i = 10;
Integer a = i;
Integer b = i;
System.out.println(a == b); //guess what is the output?
The output was supposed to be false. However, you can test this and you will find it is true.
Why?

Because "The JVM is caching Integer values. == only works for numbers between -128 and 127 "
Then you can try another code:

int i = 1000; //greater than 127
Integer a = i;
Integer b = i;
System.out.println(a == b); //this time we got false
Look, now you get false. And now it explains why we can pass the small cases (because the indices are in the range of -128 and 127).
*/
class Solution {
    public boolean wordPattern(String pattern, String s) {

        if (pattern.length() != s.split(" ").length)
            return false;

        String[] words = s.split(" ");
        Map<Object, Integer> map = new HashMap<>();

        Integer count = 0; // If we used 'int' instead of Integer then larger test cases fails.
        for (char ch : pattern.toCharArray()) {
            String currentWord = words[count];

            if (!map.containsKey(ch)) {
                map.put(ch, count);
            }

            if (!map.containsKey(currentWord)) {
                map.put(currentWord, count);
            }

            if (map.get(ch) != map.get(currentWord)) {
                return false;
            }

            count++;
        }

        return true;
    }
}