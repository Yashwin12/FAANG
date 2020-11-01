class Program {
	// T: O (n) | S: O(1)
  public static boolean isMonotonic(int[] array) {
   if ( array.length <= 2 ){
		 return true;
	 }
		int direction = array[1] - array[0];
		
		for( int i = 1; i < array.length - 1; i++ ){
			if ( direction == 0  ){
				direction = array[i+1] - array[i];
				continue;
			}	
			
			// direction > 0 means incrasing 
			if( direction > 0 ){
				if( array[i] > array[i+1] ){
					return false;
				}				
			}
			// direction < 0 means decreasing
			else if( direction < 0 ){
				if( array[i] < array[i+1] ){
					return false;
				}		
			}
		}
		
    return true;
  }
}

// 2) T: O(n) | S: O(1)
class Program {
    public static boolean isMonotonic(int[] array) {
        Boolean isNonIncreasing = true;
        Boolean isNonDecreasing = true;

        for (int i = 0; i < array.length - 1; i++) {

            if (array[i] < array[i + 1]) {
                isNonDecreasing = false;
            }
            if (array[i] > array[i + 1]) {
                isNonIncreasing = false;
            }
        }

        return isNonIncreasing || isNonDecreasing;
    }
}

import java.util.*;

class Program {
  public static boolean isMonotonic(int[] array) {
    
		if( array.length <= 2 ){
			return true;
		}
		
		int i = 0;
		boolean nonDecreasing = false;
		// The below loop is to determine directions; this would also work for having array with same elements at the start i.e [1,1,1,1,2,3]. 
		for( i = 0; i < array.length - 1; i ++){
			if( array[i] != array[i+1]){
				nonDecreasing = array[i] > array[i+1] ? true: false;					
				break;
			}			
		}

		while ( i < array.length - 1){
			
			// Simply ignoring same elemets
			if( array[i] == array[i+1] ){
				i++;
				continue;
			}
			
			if( nonDecreasing && array[i] > array[i+1] ){
				i++;
			}
			else if( !nonDecreasing && array[i] < array[i+1] ){
				i++;
			}
			else{
				return false;
			}
		}
		
    return true;
  }
}
