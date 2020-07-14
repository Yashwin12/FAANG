import java.util.*;
// T: O(2^n) | S: O(n)
class Program {
  public static int getNthFib(int n) {
  	if( n == 1 )
			return 0;
		
		if( n == 2 )
			return 1;
		
    return getNthFib( n - 1 ) + getNthFib( n - 2 );
  }
}


import java.util.*;
//2) S: O(n) | T: O(n)
class Program {
	
public static Map<Integer, Integer> map = new HashMap<>();
	
  public static int getNthFib(int n) {
			
    return helperMethod(n);
  }
	
	public static int helperMethod( int n ){
		
		if( n == 1 )
			return 0;
		
		if( n == 2 )
			return 1;
		
		if( map.containsKey(n) )
			return map.get(n);
		
    return getNthFib( n - 1 ) + getNthFib( n - 2 );
		
	}	
}

import java.util.*;

// 3) S: O(1) | T: O(n)
class Program {
  public static int getNthFib(int n) {
    
		int[] lastTwo = {0, 1};
		int counter = 3;
		
		while ( counter <= n ){
			int c = lastTwo[1] + lastTwo[0];
			lastTwo[0] = lastTwo[1];
			lastTwo[1] = c;
			
			counter++;
		}
		
    return n > 1 ? lastTwo[1] : lastTwo[0];
  }
}

