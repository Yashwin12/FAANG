import java.util.*;

// T: O(n) | S: O(n)
class Program {
    public static int[] largestRange(int[] array) {
        int[] returnArr = { -1, -1 };

        Set<Integer> set = new HashSet<>();

        int maxRange = Integer.MIN_VALUE;

        for (int ele : array) {
            set.add(ele);
        }

        for (int ele : set) {

            int currentValue = ele;
            int startingValue = ele;

            while (set.contains(currentValue - 1)) {
                currentValue -= 1;
                startingValue = currentValue;
            }

            currentValue = ele;
            int endingValue = ele;

            while (set.contains(currentValue + 1)) {
                currentValue += 1;
                endingValue = currentValue;
            }

            int currentRange = endingValue - startingValue;

            if (maxRange < currentRange) {
                maxRange = currentRange;
                returnArr[0] = startingValue;
                returnArr[1] = endingValue;
            }

        }

        return returnArr;
    }
}
