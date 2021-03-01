// 1) Brute Force: T:O(n) | S:O(n)
// class NumArray {

//     private int[] arr;

//     public NumArray(int[] nums) {
//         this.arr = nums;    
//     }

// This method is T: O(n)
//     public int sumRange(int i, int j) {
//         int sum = 0;
//         for( int idx = i; idx <= j; idx++){
//             sum += arr[idx];    
//         }

//         return sum;
//     }
// }

// 2) Pre-Cached: T:O(n) | S:O(n)
// HACK: https://www.youtube.com/watch?v=CjPMfq3ULZg
class NumArray {

    private int[] sum;

    public NumArray(int[] nums) {
        sum = new int[nums.length + 1];
        sum[0] = 0;

        for (int i = 0; i < nums.length; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
    }

    // This method is T: O(1)
    public int sumRange(int i, int j) {
        return sum[j + 1] - sum[i];
    }
}

/**
 * Your NumArray object will be instantiated and called as such: NumArray obj =
 * new NumArray(nums); int param_1 = obj.sumRange(i,j);
 */