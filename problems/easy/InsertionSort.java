class Program {
//   public static int[] insertionSort(int[] array) {
// 		1) Best case (Already sorted array): T: O(n)| S: O(1)
			// Avg and worst case: T: O(n^2) | S: O(1)
// 		int c, j;
// 		for(int i = 1; i < array.length; i++){
// 			int temp = array[i];
// 			for(j = i - 1; j >= 0 && array[j] > temp; j--){
// 					array[j + 1] = array[j];
// 			}
// 			array[j + 1] = temp;
// 		}

//     return array;
//   }
	
	  public static int[] insertionSort(int[] array) {
   // 		2) Best case (Already sorted array): T: O(n)| S: O(1)
			// Avg and worst case: T: O(n^2) | S: O(1)
		int c, j;
		for(int i = 1; i < array.length; i++){
			
			j = i;
			while( j > 0 && array[j - 1] > array[j] ){
				// swap
				c = array[j-1];
				array[ j - 1 ] = array[j];
				array[j] = c;
				j--;
			}
			
		}

    return array;
  }
	
	
}	

