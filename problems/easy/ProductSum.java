import java.util.*;

class Program {
  public static int productSum(List<Object> array) {
		int multiplier = 1;
		return recursiveProductSum(multiplier, array);
  }
	
	public static int recursiveProductSum(int multiplier,  List<Object> array){
		int sum = 0;
		for(Object obj: array){
				if( obj instanceof ArrayList ){
				sum = sum + recursiveProductSum( (multiplier + 1), (ArrayList) obj );
			}
			else{
				sum = sum + (int)obj ;
			}
		}
		return sum* multiplier;	
	}
	
}
