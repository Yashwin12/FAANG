import java.util.*;

class Program {
  public static int[] selectionSort(int[] array) {

    for ( int i = 0; i < array.length; i++ ){
        int min = Integer.MAX_VALUE;
        int k = i;
        for( int j = i; j < array.length; j++){
            if( min > array[j]){
                min = array[j];
                k = j;
            }
        }
        swap(array, i, k);
    }
    return array;
  }

  public static void swap( int[] array, int left, int right ){
    int c = array[left];
    array[left] = array[right];
    array[right] = c;		
}	

}

// Same as above
import java.util.*;

class Program {
  public static int[] selectionSort(int[] array) {
 		
		for ( int i = 0; i < array.length; i++ ){
			int smallest = i;
			int j = i;
			
			while( j < array.length ){
				if( array[smallest] > array[j] )
					smallest = j;
				
				j++;
			}
			swap(array, i, smallest );
		}
		return array;
  }
	
	public static void swap( int[] array, int left, int right ){
		int c = array[left];
		array[left] = array[right];
		array[right] = c;		
	}	
}




