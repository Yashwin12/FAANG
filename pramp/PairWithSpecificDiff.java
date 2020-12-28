import java.io.*;
import java.util.*;

// T:O(N) | S: O(N)
class Solution {

    static int[][] findPairsWithGivenDifference(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int ele : arr) {
            map.put(ele - k, ele);
        }

        List<int[]> lists = new ArrayList<>();

        for (Integer ele : arr) {
            if (map.containsKey(ele)) {
                int[] tempList = { map.get(ele), ele };
                lists.add(tempList);
            }
        }

        return lists.toArray(new int[lists.size()][]);
    }

    public static void main(String[] args) {

    }

}