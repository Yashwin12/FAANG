class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {

        // There are 1000 buckets, one and only one of them is poisonous, while the rest
        // are filled with water. They all look identical. If a pig drinks the poison it
        // will die within 15 minutes. What is the minimum amount of pigs you need to
        // figure out which bucket is poisonous within one hour?

        // Considerig above scenario, pig can die in 0-15, 15-30, 30-45, 45-60 and 60-75
        // mins. So 6 state (round) might be done to check out the poisonous bucket
        int n = (minutesToTest / minutesToDie) + 1;

        // HACK 1:
        // https://leetcode.com/problems/poor-pigs/discuss/270377/VERY-EASY-arithmetics%3A-the-right-way-to-ENCODE-the-buckets-(LESS-than-10-lines-beats-100)
        // HACK 2: https://www.rapidtables.com/calc/math/Log_Calculator.html
        // HACK 3: https://youtu.be/B8347eCbC7o
        return (int) Math.ceil(Math.log(buckets) / Math.log(n));
    }
}