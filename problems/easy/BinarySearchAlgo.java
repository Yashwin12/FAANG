class Program {
    public static int binarySearch(int[] array, int target) {
        // Write your code here.
        int left = 0;
        int right = array.length;

        return binarySearchHelper(array, target, left, right);
    }

    // 1. T: O( log n), S: (log n)
    public static int binarySearchHelper(int[] array, int target, int left, int right) {
        if (left > right) {
            return -1;
        }
        int middle = (left + right) / 2; // Preferred: int middle = left + (right - left)/2;
        int middleValue = array[middle];
        if (middleValue == target) {
            return middle;
        } else if (middleValue > target) {
            // go left
            return binarySearchHelper(array, target, left, middle - 1);
        } else {
            // go right
            return binarySearchHelper(array, target, middle + 1, right);
        }

    }

    // 2. T: O(log n), S: O(1)
    // public static int binarySearchHelper(int[] array, int target, int left, int right) {

    //     while (left <= right) {
    //      int middle = (left + right) / 2; // Preferred: int middle = left + (right - left)/2;    
    //         int middleValue = array[middle];
    //         if (middleValue == target) {
    //             return middle;
    //         } else if (middleValue > target) {
    //             right = middle - 1;
    //         } else {
    //             left = middle + 1;
    //         }
    //     }

    //     return -1;
    // }

}
