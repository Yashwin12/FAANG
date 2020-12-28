// 1) T: O( M * N) | S: O( M + N)
// class Solution {
//     private int M;
//     private int N;
//     public void setZeroes(int[][] matrix) {
//         M = matrix.length;
//         N = matrix[0].length;

//         List<int[]> list = new ArrayList<>();        

//         for( int row = 0; row < M; row++ ){            
//             for( int col = 0; col < N; col++ ){
//                 if( matrix[row][col] == 0)
//                     list.add( new int[]{row, col} );
//             }            
//         }

//         for( int[] pair: list ){
//             rowNullifier( pair[0], matrix);
//             colNullifier( pair[1], matrix);
//         }

//     }

//     private void rowNullifier( int row, int[][] matrix ){

//         for( int col = 0; col < N; col++ ){
//             matrix[row][col] = 0;       
//         }
//     }

//     private void colNullifier( int col, int[][] matrix ){

//         for( int row = 0; row < M; row++ ){
//             matrix[row][col] = 0;       
//         }
//     }
// }


// HACK: https://www.youtube.com/watch?v=1KnLIAvTxjQ
// 2) Constant Space => T: O( M * N) | S: O(1)
class Solution {
    private int M;
    private int N;

    public void setZeroes(int[][] matrix) {
        boolean firstRowHasZero = false;
        boolean firstColHasZero = false;

        M = matrix.length;
        N = matrix[0].length;

        for (int row = 0; row < M; row++) {
            if (matrix[row][0] == 0) {
                firstColHasZero = true;
                break;
            }
        }

        for (int col = 0; col < N; col++) {
            if (matrix[0][col] == 0) {
                firstRowHasZero = true;
                break;
            }
        }

        for (int row = 1; row < M; row++) {
            for (int col = 1; col < N; col++) {
                if (matrix[row][col] == 0) {
                    matrix[0][col] = 0;
                    matrix[row][0] = 0;
                }
            }
        }

        for (int col = 1; col < N; col++) {
            if (matrix[0][col] == 0) {
                colNullifier(col, matrix, 0, 1);
            }
        }

        for (int row = 1; row < M; row++) {
            if (matrix[row][0] == 0) {
                rowNullifier(row, matrix, 0, 1);
            }
        }

        if (firstRowHasZero) {
            rowNullifier(0, matrix, 0, 0);
        }

        if (firstColHasZero) {
            colNullifier(0, matrix, 0, 0);
        }

    }

    private void rowNullifier(int row, int[][] matrix, int val, int startingIdx) {

        for (int col = startingIdx; col < N; col++) {
            matrix[row][col] = val;
        }
    }

    private void colNullifier(int col, int[][] matrix, int val, int startingIdx) {

        for (int row = startingIdx; row < M; row++) {
            matrix[row][col] = val;
        }
    }
}