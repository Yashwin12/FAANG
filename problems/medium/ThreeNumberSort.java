// import java.util.*;

// // 1) Brute force: T: O(n) (Order for loop will always be constant!) | S: O(1)
// class Program {
//   public int[] threeNumberSort(int[] array, int[] order) {

// 		int currentSorted = 0;
// 		for( int i = 0; i < order.length; i++){
// 			for( int j = currentSorted; j < array.length; j++){
// 				if( array[j] == order[i]){					
// 					swap( j, currentSorted, array);
// 					currentSorted++;
// 				}
// 			}
// 		}
//     return array;
//   }

// 	public static void swap( int i, int j, int[] array ){
// 		int temp = array[i];
// 		array[i] = array[j];
// 		array[j] = temp;
// 	}
// }

// 2) Very naive way: T: O(n) | S: O(1)
// import java.util.*;

// class Program {
//   public int[] threeNumberSort(int[] array, int[] order) {   
// 		int firstIdx = 0;
// 		int secondIdx = 0;
// 		int thirdIdx = 0;

// 		for( int i = 0; i< array.length; i++ ){
// 			if( order[0] == array[i] )
// 				firstIdx++;
// 			else if( order[1] == array[i] )
// 				secondIdx++;
// 			else
// 				thirdIdx++;
// 		}

// 		for( int i = 0; i< array.length; i++ ){
// 			if( firstIdx > 0 ){
// 				array[i] = order[0];
// 				firstIdx--;
// 			}
// 			else if( secondIdx > 0 ){
// 				array[i] = order[1];
// 				secondIdx--;
// 			}
// 			else if(thirdIdx > 0){
// 				array[i] = order[2];
// 				thirdIdx--;
// 			}				

// 		}

//     return array;
//   }
// }

// 3) T: O(n) | S: O(1). Similar to method #2, but more cleaner!

// import java.util.*;

// class Program {
//   public int[] threeNumberSort(int[] array, int[] order) {  
// 		int[] valueCounter = new int[] {0,0,0};

// 		for( int i = 0; i< array.length; i++ ){
// 			int orderIdx = getOrderIdx( array[i], order );
// 			valueCounter[orderIdx]++;			
// 		}

// 		int currentIdx = 0;
// 		for( int i = 0; i < order.length; i++ ){
// 			int currentCounter = valueCounter[i];
// 			int orderValue = order[i];

// 			while( currentCounter > 0 ){
// 				array[currentIdx] = orderValue;
// 				currentIdx++;
// 				currentCounter--;
// 			}

// 		}

//     return array;
//   }

// 	public static int getOrderIdx( int value, int[] order ){
// 		for( int i = 0; i < order.length; i++ ){
// 			if( value == order[i] )
// 				return i;
// 		}		
// 		return -1;		
// 	}
// }

// 4) T: O(n) | S: O(1). Smarter way! 
import java.util.*;

class Program {
    public int[] threeNumberSort(int[] array, int[] order) {

        int firstIdx = 0;

        for (int j = 0; j < array.length; j++) {
            if (array[j] == order[0]) {
                swap(j, firstIdx, array);
                firstIdx++;
            }
        }

        int lastIdx = array.length - 1;
        for (int j = array.length - 1; j >= 0; j--) {
            if (array[j] == order[2]) {
                swap(j, lastIdx, array);
                lastIdx--;
            }
        }

        return array;
    }

    public static void swap(int i, int j, int[] array) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}


