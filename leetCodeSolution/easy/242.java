// class Solution {
//     public boolean isAnagram(String s, String t) {
//         Map<Character, Integer> mapS = new HashMap<>();
//         Map<Character, Integer> mapT = new HashMap<>();
        
//         for( char ch : s.toCharArray() )
//             mapS.put( ch, mapS.getOrDefault(ch, 0) + 1 );
        
//         for( char ch : t.toCharArray() )
//             mapT.put( ch, mapT.getOrDefault(ch, 0) + 1 );
            
//         return mapS.equals(mapT);
//     }
// }


class Solution {
    public boolean isAnagram(String s, String t) {
       
        if ( s.length() != t.length() )
            return false;
        
        int[] tracker = new int[26];
        
        for( int i =0; i < s.length(); i++ ){
            tracker[ s.charAt(i) - 'a' ]++;
            tracker[ t.charAt(i) - 'a' ]--;            
        }
        
        for ( int i = 0; i < tracker.length; i++ ){
            if( tracker[i] != 0 )
                return false;
        }
        return true;
    }
}