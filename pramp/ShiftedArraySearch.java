
import java.io.*;
import java.util.*;

// HACK: https://leetcode.com/problems/search-in-rotated-sorted-array/discuss/14472/Java-AC-Solution-using-once-binary-search
class Solution {

    static int shiftedArrSearch(int[] shiftArr, int num) {

        int left = 0;
        int right = shiftArr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (shiftArr[mid] == num) {
                return mid;
            } else if (shiftArr[mid] > num) {
                // Check left subarray if they are sorted
                if (num >= shiftArr[left] && num < shiftArr[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }

            } else {
                if (num > shiftArr[mid] && num <= shiftArr[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }

            }
        }

        return -1;

    }

    public static void main(String[] args) {

    }

}
