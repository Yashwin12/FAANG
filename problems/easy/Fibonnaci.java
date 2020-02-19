import java.util.*;

class Program {

    // 1) T: O(n), S: O(1) 
    public static int getNthFib(int n) {
        // if( n == 1) return 0;
        // if( n == 2) return 1;

        // int a = 0;
        // int b = 1;
        // int c = 1;
        // int count = 2;
        // while (count != n){
        // c = a + b;
        // a = b;
        // b = c;
        // count ++;
        // }

      // return c;

      	// 2) T: O(2^n), S: O(n) 
		// if( n == 1) return 0;
		// if( n == 2) return 1;
		
		// if(n > 2 ){
		// 	return getNthFib(n - 1) + getNthFib(n-2);
		// }
		
		// return -1;

        // 3) Storing values in a hashMap ST: O (n)
    //     Map<Integer, Integer> map = new HashMap<Integer, Integer>();

    //     map.put(1, 0);
    //     map.put(2, 1);

    //     if (n == 1 || n == 2) {
    //         return map.get(n);
    //     }

    //     return helperMethod(n, map);
  
    // }

    // public static int helperMethod(int n, Map<Integer, Integer> map) {

    //     if (map.containsKey(n)) {
    //         // yes it contains the key
    //         return map.get(n);
    //     } else {
    //         // nope it doesnt contain the key, so add it for the next time
    //         map.put(n, helperMethod(n - 1, map) + helperMethod(n - 2, map));
    //         return map.get(n);
    //     }

    // }
}
