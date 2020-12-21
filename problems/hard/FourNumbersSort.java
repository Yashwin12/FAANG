import java.util.*;

// HACK: https://www.youtube.com/watch?v=ozC7E-f4aNY
// 1) T: O( n^3) | S: O(n)
class Program {
    public static List<Integer[]> fourNumberSum(int[] array, int targetSum) {

        // n * log(n)
        Arrays.sort(array);

        List<Integer[]> returnList = new ArrayList<>();

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {

                int left = j + 1;
                int right = array.length - 1;

                while (left < right) {
                    int currentSum = array[i] + array[j] + array[left] + array[right];

                    if (currentSum == targetSum) {
                        Integer[] tempArray = { array[i], array[j], array[left], array[right] };
                        returnList.add(tempArray);
                        left++;
                        right--;
                    } else if (currentSum > targetSum) {
                        right--;
                    } else {
                        left++;
                    }
                }

            }
        }

        return returnList;
    }
}
