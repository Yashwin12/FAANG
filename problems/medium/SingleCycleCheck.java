import java.util.Arrays; 

class Program {
	
	// T: O (n) | S: O(1)
	public static boolean hasSingleCycle(int[] array) {
    
		int numberOfVisitedElement = 0;
		int currentIndx = 0;
		while ( numberOfVisitedElement != array.length )	{
			if(numberOfVisitedElement > 0 && currentIndx == 0){
				return false;
			}
			numberOfVisitedElement++;
			currentIndx = someFunc( array, currentIndx);
		}		
		return ( currentIndx == 0 );
  }
	
	public static int someFunc(int[] array, int currentIndx){
		int jump = array[currentIndx];
		int nextIndx = ( currentIndx + jump) % array.length;		
		return nextIndx >=0 ? nextIndx : nextIndx + array.length;
	}
}
