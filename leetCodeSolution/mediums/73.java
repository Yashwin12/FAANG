class Solution {
    private int M = 0;
    private int N = 0;

    public void setZeroes(int[][] matrix) {
        M = matrix.length;
        N = matrix[0].length;
        List<Pair<Integer, Integer>> pairs = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (matrix[i][j] == 0)
                    pairs.add(new Pair(i, j));
            }
        }

        for (Pair pair : pairs) {
            makeRowsAndColsZeroes(pair, matrix);
        }

    }

    private void makeRowsAndColsZeroes(Pair pair, int[][] matrix) {
        Integer currentRow = (Integer) pair.getKey();
        Integer currentCol = (Integer) pair.getValue();

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (i == currentRow || j == currentCol) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}