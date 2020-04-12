import java.util.*;

class Program {
	// T: O(w * n  * log(n))  | S: O(w *n); where n = length of longest word and w = total number of words
  public static List<List<String>> groupAnagrams(List<String> words) {
    List<List<String>> groupedAnangrams = new ArrayList<>();
		Map< String, List<String> > map = new HashMap<>(); 
		
		for (String word : words){
			char[] ch = word.toCharArray();
			Arrays.sort(ch); // n * log(n)
			
			String sortedWord = new String(ch);
			if ( map.get(sortedWord) != null){
					// this sortedWord is found in the map then add it to its value "List"
				map.get(sortedWord).add(word);
			
			}
			else{
						// no key is available, add a new KV in the map
				map.put(sortedWord, new ArrayList<String>(Arrays.asList(word))  );
		
			}
		}
		
		for (String key: map.keySet()) {
			groupedAnangrams.add( map.get(key) );
		}
		
    return groupedAnangrams;
  }
}
