import java.util.*;
class Program {
  public static int[] findThreeLargestNumbers(int[] array) {
		
		// T: O(n * m log m ) - as one needs to traverse through every element and sorting is m*logm time bc it is of three elements always
    // S: O(1) - not storing anything other than max array
    //1)
		int[] max = {Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};
		
		for (int i=0; i< array.length; i++){

			if(array[i] > max[0]){
				max[0] = array[i];
			}
			Arrays.sort(max);
		}
		
   return 	max;
        
	// T: O(n) - as one needs to traverse through every element and updateAndShift is a constant time bc it is of three elements always
        // S: O(1) - not storing anything other than max array
        //2)
// 		int[] max = {Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};
		
// 		for (int i=0; i< array.length; i++){

// 			if(array[i] > max[2]){
// 				updateAndShift(max, array[i], 2 );
// 			}
// 			else if(array[i] > max[1]){
// 				updateAndShift(max, array[i], 1 );
// 			}
// 			else if(array[i] > max[0]){
// 				updateAndShift(max, array[i], 0 );
				
// 			}
// 		}
		
//     return 	max;
//   }
	
// 	public static void updateAndShift(int[] max, int arrayElement, int idx ){
// 		for (int i =0; i <= idx ; i++){
// 			if(i == idx){
// 				max[i] = arrayElement;
// 			}
// 			else{
// 				max[i] = max[i+1];
// 			}
			
// 		}
	}
}
