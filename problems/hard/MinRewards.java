// IMPORTANT && TRICKY!

// import java.util.*;

// // 1) Naive solution T: O(n ^2) | S: O(1)
// class Program {
//     public static int minRewards(int[] scores) {
//         int[] rewards = new int[scores.length];
//         Arrays.fill(rewards, 1);

//         for (int i = 1; i < scores.length; i++) {
//             int j = i - 1;
//             if (scores[i] > scores[j]) {
//                 rewards[i] = rewards[j] + 1;
//             } else {
//                 while (j >= 0 && scores[j + 1] < scores[j]) {
//                     rewards[j] = Math.max(rewards[j], rewards[j + 1] + 1);
//                     j--;
//                 }
//             }

//         }

//         int finalSum = 0;
//         for (int ele : rewards) {
//             finalSum += ele;
//         }

//         return finalSum;
//     }
// }



// 2) T: O(n) | S: O(n)
// import java.util.*;

// class Program {
//   public static int minRewards(int[] scores) {
//    	int[] rewards = new int[scores.length];
// 		Arrays.fill(rewards, 1);
		
// 		List<Integer> valleys = getAllValleys(scores);
		
// 		for( int valleyIdx: valleys ){
// 			// Expand left and right to a valley point
			
// 			int leftIdx = valleyIdx - 1;
// 			int rightIdx = valleyIdx + 1;
			
// 			while( leftIdx >= 0 && scores[leftIdx + 1] < scores[leftIdx]  ){
// 				rewards[leftIdx] = Math.max( rewards[leftIdx], rewards[leftIdx + 1] + 1 );
// 				leftIdx -= 1;	
// 			}
			
// 			while( rightIdx < scores.length && scores[rightIdx - 1] < scores[rightIdx] ){
// 				rewards[rightIdx] = Math.max( rewards[rightIdx], rewards[rightIdx - 1] + 1 );
// 				rightIdx += 1;	
// 			}
			
// 		}
		
//    int finalSum = 0;
// 		for( int ele: rewards ){
// 			finalSum += ele;
// 		}
		
//     return finalSum;
//   }
	
	
// 	private static List<Integer> getAllValleys( int[] scores){
// 		List<Integer> valleys = new ArrayList<>();
		
// 		if( scores.length == 1){
// 			valleys.add(0);
// 			return valleys;
// 		}
		
// 		for( int i = 0; i < scores.length; i++){
			
// 			if( i == 0 && scores[i] < scores[i+1]){
// 				valleys.add(i);
// 			}				
			
// 			if( i == scores.length - 1 && scores[i -1] > scores[i] ){
// 				valleys.add(i);
// 			}
			
// 			if( i == 0 || i == scores.length - 1 )
// 				continue;
			
// 			if( scores[i-1] > scores[i] && scores[i] < scores[i+1] ){
// 				valleys.add(i);
// 			}							
// 		}
		
// 		return valleys;		
// 	} 
	
// }


// 3) T: O(n) | S: O(n)

import java.util.*;

// Efficient and clever: T: O(n) | S:O(n)
class Program {
  public static int minRewards(int[] scores) {
		int[] rewards = new int[scores.length];
		Arrays.fill(rewards,1);
		
		for( int i = 1; i < scores.length; i++){
			
			if( scores[i] > scores[i-1] ){
				rewards[i] = rewards[i-1] + 1;
			}			
		}
		
		for( int i = scores.length - 1; i > 0; i--){
			
			if( scores[i] < scores[i-1] ){
				rewards[i-1] = Math.max(rewards[i-1], rewards[i] + 1);
			}			
		}
		
    int finalSum = 0;
		for( int ele: rewards ){
			finalSum += ele;
		}
		
    return finalSum;
  }
}
