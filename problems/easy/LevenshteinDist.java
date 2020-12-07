class Program {
	
// 	// T: O(str1 * str2) | S: O(str1 * str2)
// HACK: https://www.youtube.com/watch?v=b6AGUjqIPsA
// This is used in "auto-suggestions" and "spell-checking" while typing a word! 
  public static int levenshteinDistance(String str1, String str2) {
    
		int[][] matrix = new int[str1.length() + 1][str2.length() + 1];
		
		for ( int row =0; row <= str1.length() ; row++){
			matrix[row][0] = row;
		}
		for ( int col =0; col <= str2.length() ; col++){
			matrix[0][col] = col;
		}
		
		for ( int row =1; row <= str1.length() ; row++){
			for ( int col =1; col <= str2.length() ; col++){
				
				if(str1.charAt(row - 1) == str2.charAt(col - 1)){
					matrix[row][col] = matrix[row-1][col -1];
				}
				else{
					System.out.println("BEFORE" + matrix[row][col]);
					matrix[row][col] = 1 + Math.min( matrix[row-1][col -1], Math.min( matrix[row][col -1], matrix[row-1][col]) );
					System.out.println("AFTER" + matrix[row][col]);
				}
				
			}
		}
		
    return matrix[str1.length()][str2.length()];
  }
 
// TODO: Implement second method with better space complexity 

}
