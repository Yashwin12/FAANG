class Program {
    public static int[] bubbleSort(int[] array) {
      // Write your code here.
          
          // 1) All cases T: O(n^2), S: O(1)
          // Only catch for this algo is when the array is sorted it will still do O(n^2)
          // int count = 0;
          // int c;
          // for (int j = 0; j < array.length; j++){ 
          // 	for(int i = 0; i < array.length - 1 - count; i++){
          // 		if( array[i] > array[i+1]){
          // 			c = array[i];
          // 			array[i] = array[i+1];
          // 			array[i+1] = c;
          // 		}
          // 	}
          // 	count++;			
          // }			
          // return array;
          
          // 2) Best case (when array is sorted) T: O(n) | S: O(1);
          //		Avg and worst case: T: O(n^2) | S: O(1)
          int count = 0;
          int c;
          boolean isSorted = false;
          while(!isSorted){
              isSorted = true;
              for(int i = 0; i < array.length - 1 - count; i++){
                  if( array[i] > array[i+1]){
                      c = array[i];
                      array[i] = array[i+1];
                      array[i+1] = c;
                      isSorted = false;
                  }
              }
              count++;			
          }			
      return array;
    }
  }
  