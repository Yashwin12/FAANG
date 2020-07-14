import java.util.*;


// HACK: 1) https://www.geeksforgeeks.org/find-number-of-islands/
// HACK: 2) https://leetcode.com/discuss/interview-question/411357/
// The below solution is done using DFS. Moreover, it can also be done using BFS. 

// T: O(now of rows *  now of cols) T: O(now of rows *  now of cols) 
class Program {
    public static List<Integer> riverSizes(int[][] matrix) {

        List<Integer> list = new ArrayList<>();
        int[][] visited = new int[matrix.length + 1][matrix[0].length + 1];

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {

                if (visited[row][col] != 1 && matrix[row][col] == 1) {
                    int count = 1;
                    visited[row][col] = 1;
                    count = helperFunc(row, col, matrix, visited, count);
                    list.add(count);
                }
            }
        }
        System.out.println("LIST" + list);
        return list;
    }

    public static int helperFunc(int row, int col, int[][] matrix, int[][] visited, int count) {
        // Up, Down, Right, Left
        int[][] DIRECTIONS = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };

        for (int[] d : DIRECTIONS) {

            int x = row + d[0];
            int y = col + d[1];

            if (x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length && matrix[x][y] == 1
                    && visited[x][y] == 0) {
                visited[x][y] = 1;
                count++;
                count = helperFunc(x, y, matrix, visited, count);
            }

        }
        return count;
    }
}
