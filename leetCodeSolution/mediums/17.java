class Solution {
    
    private Map<Character, String> map = new HashMap<>();
    private int len = 0;
    
    public List<String> letterCombinations(String digits) {
        map.put( '2', "abc");
        map.put( '3', "def");
        map.put( '4', "ghi");
        map.put( '5', "jkl");
        map.put( '6', "mno");
        map.put( '7', "pqrs");
        map.put( '8', "tuv");
        map.put( '9', "wxyz");
        
        len = digits.length();
        List<String> list = new ArrayList<>();
        
        if( len == 0 )
            return list;
              
        helperMethod( digits, list, new StringBuilder() );
        return list;
    }
    
    private void helperMethod( String digits, List<String> list, StringBuilder sb ){
        if( sb.length() == len ){
            list.add( sb.toString() );
            return;
        }
        
        for( int i = 0; i < digits.length(); i++ ){
            Character ch = digits.charAt(i); // "2"
            String mapping = map.get(ch); // "abc"
            
            for( int j = 0; j < mapping.length(); j++ ){
                sb.append( mapping.charAt(j) + "" );    
                
                helperMethod( digits.substring( i+1, digits.length() ) , list, sb );
                sb.deleteCharAt(sb.length() - 1);
            }
            
        }
        
    }
}