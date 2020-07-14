// import java.util.*;

// class Solution {
//     public int[] sortedSquares(int[] A) {
        
//               PriorityQueue<Integer> pq = new PriorityQueue<>();
//         for(int ele: A){
//             pq.offer(ele*ele);
//         }
        
//         int[] res = new int[A.length];
//         int index = 0;
//         while(pq.size()!=0){
//             res[index++] = pq.poll();
//         }
        
//         return res;
//     }
// }

import java.util.*;

// HACK: https://www.youtube.com/watch?v=4eWKHLSRHPY
class Solution {
    public int[] sortedSquares(int[] A) {
        
        int left = 0; 
        int right = A.length - 1;
        
        int[] result = new int[A.length];
        
        int tempPointer = A.length - 1;
        
        while ( left <= right ){
            
            if( Math.abs(A[left]) > Math.abs( A[right] ) ){
                result[tempPointer] = A[left] * A[left];
                left++;
            }
            else{
                result[tempPointer] = A[right] * A[right];
                right--;
            }
            tempPointer--;
        }
        return result;
    }
}