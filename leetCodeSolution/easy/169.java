// 1) With using Collection. T: O(n) | S: O(n)
// class Solution {
//     public int majorityElement(int[] nums) {

//         int stoppingLimit = nums.length/2;

//         Map<Integer, Integer> map = new HashMap<>();                        

//         for( int num: nums ){

//             map.put( num, map.getOrDefault(num, 0) + 1 );

//             if( map.containsKey(num) && map.get(num) > stoppingLimit )
//                 return num;            
//         }

//         return -1;

//     }
// }

// HACK & IMPORTANT: https://www.youtube.com/watch?v=p9Re2IZh4ug 
// 2) Boyer-Moore Voting Algorithm. T: O(n) | S: O(1)
class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int currentMax = -1;

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            if (count <= 0) {
                count++;
                currentMax = num;
            } else if (currentMax == num) {
                count++;
            } else {
                count--;
            }

        }

        return currentMax;

    }
}