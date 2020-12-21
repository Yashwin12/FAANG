// import java.util.*;

// 1) Clean and Elegant: T: O(n^2) | S: O(n^2)
// class Program {
//     public static boolean sameBsts(List<Integer> arrayOne, List<Integer> arrayTwo) {

//         if (arrayOne.size() == 0 && arrayTwo.size() == 0)
//             return true;

//         if (arrayOne.size() != arrayTwo.size() || arrayOne.get(0) != arrayTwo.get(0))
//             return false;

//         List<Integer> leftOne = getSmall(arrayOne);
//         List<Integer> leftTwo = getSmall(arrayTwo);
//         List<Integer> rightOne = getBiggerOrEqualTo(arrayOne);
//         List<Integer> rightTwo = getBiggerOrEqualTo(arrayTwo);

//         return sameBsts(leftOne, leftTwo) && sameBsts(rightOne, rightTwo);
//     }

//     private static List<Integer> getSmall(List<Integer> array) {
//         List<Integer> returnArr = new ArrayList<>();

//         for (int i = 1; i < array.size(); i++) {
//             if (array.get(0) > array.get(i)) {
//                 returnArr.add(array.get(i));
//             }
//         }
//         return returnArr;
//     }

//     private static List<Integer> getBiggerOrEqualTo(List<Integer> array) {
//         List<Integer> returnArr = new ArrayList<>();

//         for (int i = 1; i < array.size(); i++) {
//             if (array.get(0) <= array.get(i)) {
//                 returnArr.add(array.get(i));
//             }
//         }
//         return returnArr;
//     }

// }

import java.util.*;

// 1) Complex and more optimal: T: O(n^2) | S: O(d); where d = depth 
class Program {
    public static boolean sameBsts(List<Integer> arrayOne, List<Integer> arrayTwo) {

        return helperMethod(arrayOne, arrayTwo, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean helperMethod(List<Integer> arrayOne, List<Integer> arrayTwo, int rootIdxOne, int rootIdxTwo,
            int minValue, int maxValue) {
        if (rootIdxOne == -1 || rootIdxTwo == -1)
            return rootIdxOne == rootIdxTwo;

        if (arrayOne.get(rootIdxOne) != arrayTwo.get(rootIdxTwo))
            return false;

        int leftOne = getIdxOfFirstSmallerValue(arrayOne, rootIdxOne, minValue);
        int leftTwo = getIdxOfFirstSmallerValue(arrayTwo, rootIdxTwo, minValue);

        int rightOne = getIdxOfFirstBiggerOrEqualValue(arrayOne, rootIdxOne, maxValue);
        int rightTwo = getIdxOfFirstBiggerOrEqualValue(arrayTwo, rootIdxTwo, maxValue);

        int currentValue = arrayOne.get(rootIdxOne);
        return helperMethod(arrayOne, arrayTwo, leftOne, leftTwo, minValue, currentValue)
                && helperMethod(arrayOne, arrayTwo, rightOne, rightTwo, currentValue, maxValue);
    }

    private static int getIdxOfFirstSmallerValue(List<Integer> array, int startingIdx, int minValue) {

        for (int i = startingIdx + 1; i < array.size(); i++) {
            if (minValue <= array.get(i) && array.get(startingIdx) > array.get(i)) {
                return i;
            }
        }
        return -1;
    }

    private static int getIdxOfFirstBiggerOrEqualValue(List<Integer> array, int startingIdx, int maxValue) {

        for (int i = startingIdx + 1; i < array.size(); i++) {
            if (maxValue > array.get(i) && array.get(startingIdx) <= array.get(i)) {
                return i;
            }
        }
        return -1;
    }
}
