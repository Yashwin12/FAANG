import java.util.*;

class TwoNumberSum {

    public static void main(String[] args) {

        int[] arr = { -21, 301, 12, 4, 65, 56, 210, 356, 9, -47 };
        int target = 163;
        int[] finalArray = new int[2];

        // // 1) O(n^2)
        // for (int i = 0; i < arr.length - 1; i++){
        // for(int j = i+1; j< arr.length; j++){
        // if(arr[i] + arr[j] == target){
        // finalArray[0] = arr[i];
        // finalArray[1] = arr[j];
        // break;
        // }
        // }
        // }
        // System.out.println(finalArray[0] + " "+ finalArray[1]);

        // 2) O(n logn)
        // Arrays.sort(arr);
        // int i = 0;
        // int j = arr.length - 1;

        // while ( j > i){
        // if(arr[i] + arr[j] == target){
        // finalArray[0] = arr[i];
        // finalArray[1] = arr[j];
        // break;
        // }
        // else if (arr[i] + arr[j] > 0){
        // j--;
        // }
        // else{
        // i++;
        // }
        // }
        // System.out.println(finalArray[0] + " "+ finalArray[1]);

        // 3) O(n)
        Map<Integer, Boolean> map = new HashMap<>();

        for (int num : array) {
            int potentialMatch = targetSum - num;
            if (map.containsKey(potentialMatch)) {
                return new int[] { potentialMatch, num };
            } else {
                map.put(num, true);
            }
        }

        return new int[0];

    }
}
