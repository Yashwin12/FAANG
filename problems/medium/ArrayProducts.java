import java.util.*;

// 1) Brute Force: T: O(n^2) | S: O(n)
class Program {
  public int[] arrayOfProducts(int[] array) {
		int[] products = new int[array.length];
		for( int i = 0; i < array.length; i++ ){
			int product = 1;
			for( int j = 0; j < array.length; j++ ){
				if( i == j){
					continue;
				}
					product = product * array[j];
			}
			products[i] = product;
		}
    return products;
  }
}


import java.util.*;

// 2) T: O(n) | S: O(n)
class Program {
  public int[] arrayOfProducts(int[] array) {
    int[] left = new int[array.length];
		int[] right = new int[array.length];
		
		// Base case
		left[0] = 1;
		right[array.length - 1] = 1;
		for( int i = 1; i < array.length; i++ ){
			left[i] = array[i-1] * left[i-1];				
		}	
		
		for( int i = array.length - 2; i >= 0 ; i-- ){
			right[i] = array[i+1] * right[i+1];
		}
		
		for( int i = 0; i < array.length; i++){
			array[i] = left[i] * right[i];
		}
		return array;
  }
}

// import java.util.*;
// 3) T: O(n) | S: O(n)
class Program {
  public int[] arrayOfProducts(int[] array) {
		
		int leftProductSum = 1;
		int rightProductSum = 1;
		
		int[] products = new int[array.length];
			
		for( int i = 0; i < products.length; i++ ){
			products[i] = 1;
		}
		
		for( int i = 1; i < array.length; i++ ){
			leftProductSum = leftProductSum * array[i-1];
			products[i] = leftProductSum;
		}	
		
		for( int i = array.length - 2; i >= 0 ; i-- ){
			rightProductSum = rightProductSum * array[i+1];
			products[i] = products[i] * rightProductSum;
		}
		
		return products;
  }
}
