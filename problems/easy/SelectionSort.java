class Program {
  public static int[] selectionSort(int[] array) {
		
		// T: O(n^2) | S: O(1)
		int counter = 0;
		for ( int i =0; i < array.length; i++){
			int largest = 0;
			for(int j = 0; j < array.length - counter; j++){
				if(array[j] > array[largest]){
					largest = j;
				}
			} // inner for loop 
			int c = array[array.length - counter - 1];
			array[array.length - counter - 1] = array[largest];
			array[largest] = c;
			counter++;
		}
    return array;
  }
}



