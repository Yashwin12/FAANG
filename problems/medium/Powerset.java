// 1) INEFFICIENT Recursion T:O( 2^n * 2^n * n ) | S: O(2^n * n)
// checkArrayObjPresent gets called 2^n times and powerset arrayObj have at max 2^n, so 2^n * 2^n elements. 
// import java.util.*;

// class Program {
//   public static List<List<Integer>> powerset(List<Integer> array) {
// 		List<List<Integer>> powerset = new ArrayList<List<Integer>>();
// 		powerset.add( new ArrayList<>() );
// 		helperMethod ( array, powerset);
// 		return powerset;
//   }
	
// 	public static void helperMethod( List<Integer> array, List<List<Integer>> powerset ){
// 		if ( array.size() > 0 && !checkArrayObjPresent(array, powerset) ){
// 			powerset.add( array );
// 		}
// 		for ( int i = 0; i < array.size(); i++ ){
// 			List<Integer> newArray = new ArrayList<Integer>(array);
// 			newArray.remove(i);
// 			helperMethod ( newArray, powerset);
// 		}
// 	}
	
// 	public static Boolean checkArrayObjPresent ( List<Integer> array, List<List<Integer>> powerset  ){
// 		for (List<Integer> powerArrayObj : powerset ){
// 			if( powerArrayObj.equals( array ) ){
// 				return true;
// 			}
// 		}
// 		return false;
// 	}
// }


// 2) Recursion: T: O(2^n * n) | S: O(2^n * n)
// import java.util.*;

// class Program {
//   public static List<List<Integer>> powerset(List<Integer> array) {
//     return powerset (array, array.size() - 1) ;
//   }
	
// 	public static List<List<Integer>> powerset( List<Integer> array, int idx){
// 		if( idx < 0 ){
// 			List<List<Integer>> emptySet = new ArrayList<List<Integer>>();
// 			emptySet.add(new ArrayList<Integer>());
// 			return emptySet;
// 		}
// 		int ele = array.get(idx);
// 		List<List<Integer>> subsets = powerset( array, idx -1);
// 		int length = subsets.size();
// 		for (int i =0; i < length; i++){
// 				List<Integer> tempArray = new ArrayList<>(subsets.get(i));
// 				tempArray.add( ele );
// 				subsets.add( tempArray );		
// 		}
// 		return subsets;
//  	}
// }

//3) Iteration method: T: O(2^n * n) | S: O(2^n * n) 

import java.util.*;

class Program {
  public static List<List<Integer>> powerset(List<Integer> array) {
		List<List<Integer>> powerset = new ArrayList<List<Integer>>();
		powerset.add( new ArrayList<>() );
		
		for ( int i = 0; i < array.size(); i++ ){
				int j = 0;
				int powersetLength = powerset.size();
				
				while (j < powersetLength ){
					
				List<Integer> tempArray = new ArrayList<>(powerset.get(j));
				tempArray.add( array.get(i) );
				powerset.add( tempArray );					
				j++;
			}
		}
		
		return powerset;
  }
}
