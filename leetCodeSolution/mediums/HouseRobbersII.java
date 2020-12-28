
// HACK: https://leetcode.com/problems/house-robber-ii/discuss/442219/Simple-code-beating-100-JAVA-solution-by-DP-wit-explanation
class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        if (nums.length == 1)
            return nums[0];

        int[] dpArrWithFirstEle = new int[nums.length];
        int[] dpArrWithoutFirstEle = new int[nums.length];

        dpArrWithFirstEle[0] = nums[0];
        dpArrWithFirstEle[1] = Math.max(nums[0], nums[1]);

        dpArrWithoutFirstEle[0] = 0;
        dpArrWithoutFirstEle[1] = nums[1];

        for (int i = 2; i < nums.length; i++) {
            dpArrWithoutFirstEle[i] = Math.max(dpArrWithoutFirstEle[i - 2] + nums[i], dpArrWithoutFirstEle[i - 1]);

            dpArrWithFirstEle[i] = Math.max(dpArrWithFirstEle[i - 2] + nums[i], dpArrWithFirstEle[i - 1]);

        }

        return Math.max(dpArrWithFirstEle[nums.length - 2], dpArrWithoutFirstEle[nums.length - 1]);

    }
}