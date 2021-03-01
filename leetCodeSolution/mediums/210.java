// IMPORTANT CONCEPT: Topological Sort.
// HACK: https://www.youtube.com/watch?v=cIBFEhD77b4

// T: O(V+E) | S: O(V+E); where V = vertices and E = edges in the graph
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        Map<Integer, List<Integer>> adjacencyList = new HashMap<>();
        int[] inOrder = new int[numCourses];
        int[] traversal = new int[numCourses];

        // Created adjacencyList with the prequisites.....
        for (int[] pair : prerequisites) {
            int start = pair[1];
            int end = pair[0];

            List<Integer> list = adjacencyList.getOrDefault(start, new ArrayList<>());

            list.add(end);

            inOrder[end]++;
            adjacencyList.put(start, list);
        }

        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < inOrder.length; i++) {
            if (inOrder[i] == 0)
                queue.offer(i);
        }

        int count = 0;
        while (!queue.isEmpty()) {
            int currentVal = queue.poll();

            traversal[count] = currentVal;
            count++;

            if (adjacencyList.containsKey(currentVal)) {
                removeConnections(adjacencyList.get(currentVal), queue, inOrder);
            }

            if (count == numCourses) {
                return traversal;
            }
        }

        return new int[0];
    }

    private void removeConnections(List<Integer> list, Queue<Integer> queue, int[] inOrder) {

        for (Integer i : list) {
            inOrder[i]--;
            if (inOrder[i] == 0)
                queue.offer(i);

        }

    }

}