// class Solution {
//     private int M = 0;
//     private int N = 0;

//     // Up, Down, Left, Right
//     private int[][] DIRECTIONS = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

//     public boolean exist(char[][] board, String word) {
//         M = board.length;
//         N = board[0].length;
//         int[][] visited = new int[M][N];

//         for (int i = 0; i < M; i++) {
//             for (int j = 0; j < N; j++) {
//                 if (word.charAt(0) == board[i][j]) {
//                     // Try saerching in all directions with this position
//                     visited[i][j] = 1;
//                     if (search(board, word, i, j, 1, visited)) {
//                         return true;
//                     }
//                     visited[i][j] = 0;
//                 }
//             }
//         }

//         return false;
//     }

//     private boolean search(char[][] board, String word, int row, int col, int counter, int[][] visited) {

//         if (counter == word.length())
//             return true;

//         for (int[] dir : DIRECTIONS) {
//             int dr = row + dir[0];
//             int dc = col + dir[1];

//             if (isSafe(dr, dc, visited) && word.charAt(counter) == board[dr][dc]) {

//                 visited[dr][dc] = 1;
//                 if (search(board, word, dr, dc, counter + 1, visited))
//                     return true;
//                 visited[dr][dc] = 0;
//             }
//         }

//         return false;

//     }

//     private boolean isSafe(int row, int col, int[][] visited) {
//         if (row >= 0 && row < M && col >= 0 && col < N && visited[row][col] == 0)
//             return true;

//         return false;
//     }
// }


// 2) Similar to above but space optimal. T: O()
class Solution {
    private int M = 0;
    private int N = 0;

    // Up, Down, Left, Right
    private int[][] DIRECTIONS = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

    public boolean exist(char[][] board, String word) {
        M = board.length;
        N = board[0].length;

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (word.charAt(0) == board[i][j]) {
                    // Try saerching in all directions with this position

                    char ch = board[i][j];
                    board[i][j] = '#'; // Marking it as a special character so that we do not revisit it. Works as visited arr.
                    if (search(board, word, i, j, 1)) {
                        return true;
                    }
                    board[i][j] = ch; // replacing back the original matrix value
                }
            }
        }

        return false;
    }

    private boolean search(char[][] board, String word, int row, int col, int counter) {

        if (counter == word.length())
            return true;

        for (int[] dir : DIRECTIONS) {
            int dr = row + dir[0];
            int dc = col + dir[1];

            if (isSafe(dr, dc) && word.charAt(counter) == board[dr][dc]) {
                char ch = board[dr][dc];
                board[dr][dc] = '#';
                if (search(board, word, dr, dc, counter + 1))
                    return true;
                board[dr][dc] = ch;
            }
        }

        return false;

    }

    private boolean isSafe(int row, int col) {
        if (row >= 0 && row < M && col >= 0 && col < N)
            return true;

        return false;
    }
}