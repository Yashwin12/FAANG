import java.util.*;

class Program {
    public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {

        // // 1) T: O(m * n) | S: O(1)
        // int min = Integer.MAX_VALUE;
        // int[] returnArray = new int[2];
        // for (int i = 0; i < arrayOne.length; i++) {
        //     for (int j = 0; j < arrayTwo.length; j++) {
        //         int probableZero = Math.abs(arrayOne[i] - arrayTwo[j]);
        //         if (probableZero == 0) {
        //             returnArray[0] = arrayOne[i];
        //             returnArray[1] = arrayTwo[j];
        //             return returnArray;
        //         } else if (min > probableZero) {
        //             min = probableZero;
        //             returnArray[0] = arrayOne[i];
        //             returnArray[1] = arrayTwo[j];
        //         }

        //     }
        // }

        // return returnArray;

        // 2) T: O(n logn + m * m logm) | S: O(1)
        Arrays.sort(arrayOne);
        Arrays.sort(arrayTwo);

        int idx = 0;
        int idy = 0;
        int min = Integer.MAX_VALUE;
        int currentMin = Integer.MAX_VALUE;
        int[] returnArray = new int[2];

        while (idx < arrayOne.length && idy < arrayTwo.length) {
            int probableZero = Math.abs(arrayOne[idx] - arrayTwo[idy]);

            // Values are stored in these two variables bc we would be updating the idx and
            // idy value and current index values are needed in the last if condition. 
            int first = arrayOne[idx];
            int second = arrayTwo[idy];

            if (first > second) {
                currentMin = first - second;
                idy++;
            }

            else if (first < second) {
                currentMin = second - first;
                idx++;
            }

            else {
                returnArray[0] = first;
                returnArray[1] = second;
                return returnArray;
            }

            if (min > currentMin) {
                min = currentMin;
                returnArray[0] = first;
                returnArray[1] = second;
            }

        }
        return returnArray;
    }
}
