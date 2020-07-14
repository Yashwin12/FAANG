// import java.util.*;

// class Program {
// 	// NON INTUITIVE: T:O(n! * n^2) | S: O(n! * n) 
//   public static List<List<Integer>> getPermutations(List<Integer> array) {
//     // Write your code here.
// 		List<List<Integer>> permutations = new ArrayList<List<Integer>>();
// 		helperMethod(array, new ArrayList<Integer>(), permutations);
//     return permutations;
//   }
// 		public static void helperMethod(List<Integer> array, List<Integer> currentPermutation, List<List<Integer>> permutations){
// 			if( array.size() == 0 && currentPermutation.size() > 0){
// 				permutations.add(currentPermutation); // This statement would get executed n! times, as there are n! permutations of a number n.
// 			}
// 			else{
// 				for (int i = 0; i <array.size(); i++ ){
// 					List<Integer> newArray = new ArrayList<Integer>(array);
// 					newArray.remove(i); // O(n)
// 					List<Integer> newPermutation = new ArrayList<Integer>(currentPermutation);
//                     newPermutation.add( array.get(i)); // O(n) 
//                     //As these operations (add   and remove) would be stored in a stack call because of recursion, so in total it would be O(n^2).
                     
// 					helperMethod(newArray, newPermutation, permutations); // The else condition's time complexity would depend upon the number times helper function is called and the storing of newArray and newPermutation in the recursion stack. This statement would get executed roughly n^2 times. For example, [1,2,3] array and i = 0, 3 times (1 = for newArray = [2,3], 2 = for newArray[2], newArray[3]) this helper function is called. So it would be n^2 (1st n:  as explained in the above example| 2nd n: total elements in array).  
//  				}	
// 			}			
// 		}
// }

import java.util.*;

class Program {
  public static List<List<Integer>> getPermutations(List<Integer> array) {
		List<List<Integer>> permutations = new ArrayList<List<Integer>>();
		helperMethod (0, array, permutations);
    return permutations;
  }
	public static void helperMethod (int i, List<Integer> array, List<List<Integer>>  permutations){
		if( i == array.size() - 1 ){
			permutations.add( new ArrayList<Integer>(array) );
		}
		
		for ( int j = i; j < array.size(); j++ ){
			swap(i, j, array);
			helperMethod (i+1, array, permutations);
			swap(i, j, array);
		} 
		
	
	}
	public static void swap(int i, int j, List<Integer> array){			
		int temp = array.get(i);
		array.set(i, array.get(j) );	
		array.set(j, temp );	
	}
}


