
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (int[] a, int[] b) -> {
            return a[0] - b[0];
        });

        List<int[]> list = new ArrayList<>();

        for (int[] currentPair : intervals) {

            if (list.isEmpty() || list.get(list.size() - 1)[1] < currentPair[0]) {
                list.add(currentPair);
            }

            else {
                // Eligible to merge

                int startInterval = Math.min(list.get(list.size() - 1)[0], currentPair[0]);
                int endInterval = Math.max(list.get(list.size() - 1)[1], currentPair[1]);

                list.remove(list.size() - 1);
                list.add(new int[] { startInterval, endInterval });
            }

        }

        return list.toArray(new int[list.size() - 1][]);
    }
}