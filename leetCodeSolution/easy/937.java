import java.util.Arrays;

// HACK: https://leetcode.com/problems/reorder-data-in-log-files/discuss/382006/Two-solutions-or-Easy-to-understand-or-Java-or-100
class Solution {
    public String[] reorderLogFiles(String[] logs) {
        
        List<String> letterLogs = new ArrayList<>();
        List<String> digitLogs = new ArrayList<>();        
        
        for ( String sentence : logs){
            
            int firstSpace = sentence.indexOf(" ");  
            char ch = sentence.charAt(firstSpace + 1);            
                            
            if( Character.isDigit(ch) )
                digitLogs.add( sentence );
            else
                letterLogs.add( sentence );                                   
        }
  
        Collections.sort( letterLogs,  new Comparator<String>(){            
            public int compare( String str1, String str2){                
                // dig1 8 1 5 1 -> ["dig1", "8 1 5 1"]
                String[] split1 = str1.split(" ", 2);                
                String[] split2 = str2.split(" ", 2);
                
                if( split1[1].compareTo(split2[1]) == 0  )
                    return split1[0].compareTo(split2[0]);
                
                return split1[1].compareTo(split2[1]);
            }
        });
        
        letterLogs.addAll(digitLogs);        
        for ( int i = 0; i < letterLogs.size(); i++ )
            logs[i] = letterLogs.get(i);                        
        
         return logs;
    }
   
}