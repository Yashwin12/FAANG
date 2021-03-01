class Program {
    public static int[] bubbleSort(int[] array) {
        // Write your code here.

        // 1) All cases T: O(n^2), S: O(1)
        // Only catch for this algo is when the array is sorted it will still do O(n^2)
        // int count = 0;
        // int c;
        // for (int j = 0; j < array.length; j++){
        // for(int i = 0; i < array.length - 1 - count; i++){
        // if( array[i] > array[i+1]){
        // c = array[i];
        // array[i] = array[i+1];
        // array[i+1] = c;
        // }
        // }
        // count++;
        // }
        // return array;
        }
    }
// 2) Similar to #1 method implementation, but also covers check if the array is already sorted or not.
//  Best case (when array is sorted) T: O(n) | S: O(1);
//  Avg and worst case: T: O(n^2) | S: O(1)
import java.util.*; 
        class Program {
            public static int[] bubbleSort(int[] array) {
                int left = 0;
                int right = left + 1;
                boolean isSorted = false;

                for (int i = array.length - 1; i >= 0 && isSorted == false; i--) {
                    left = 0;
                    right = left + 1;

                    isSorted = true;
                    for (int j = 0; j < i; j++) {
                        if (array[left] > array[right]) {
                            swap(array, left, right);
                            isSorted = false;
                        }

                        left++;
                        right++;
                    }
                }
                return array;
            }

            public static void swap(int[] array, int left, int right) {
                int c = array[left];
                array[left] = array[right];
                array[right] = c;
            }
        }

    
        class Program {
            public static int[] bubbleSort(int[] array) {
        // 2) Best case (when array is sorted) T: O(n) | S: O(1);
        // Avg and worst case: T: O(n^2) | S: O(1)
        int count = 0;
        int c;
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < array.length - 1 - count; i++) {
                if (array[i] > array[i + 1]) {
                    c = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = c;
                    isSorted = false;
                }
            }
            count++;
        }
        return array;
    }
}
