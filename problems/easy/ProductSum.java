import java.util.*;
// RIGHT APPROACH: 
class Program {
  public static int productSum(List<Object> array) {
		int multiplier = 1;
		return recursiveProductSum(multiplier, array);
  }
	
	public static int recursiveProductSum(int multiplier,  List<Object> array){
		int sum = 0;
		for(Object obj: array){
				if( obj instanceof List ){
				sum = sum + recursiveProductSum( (multiplier + 1), (List<Object>) obj );
			}
			else{
				sum = sum + (int)obj ;
			}
		}
		return sum* multiplier;	
	}
	
}


// WRONG APPRAOCH: 
import java.util.*;

class Program {
  public static int productSum(List<Object> array) {
    return helperMethod( array, 1, 0);
  }
	  
  	// This would be correct for two depth special array. But [ 4, [ 1,2 ], 5 ] is wrong, as the inner array just multiplies 3 and NOT 6. 
	public static int helperMethod(List<Object> array, int depth, int sum){
		
		for ( int i = 0; i < array.size(); i++ ){
			System.out.println("depth: " + depth + " Ele: " + array.get(i)+ " Sum: " + sum );
			if( array.get(i) instanceof List ){
				sum = helperMethod( (List<Object>) array.get(i), depth + 1, sum );	
				System.out.println("sum" + sum);
			}
			else{
				sum += depth*(int)array.get(i);
			}			
		}
		// System.out.println("OUTSIDE sum" + sum);
		return sum;
		
	}
}
