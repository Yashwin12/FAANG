import java.util.*;

// 1) T: O(M*N) | S: O(M*N); wheree M = total rows and N = total cols
class Program {

    private static int totalRows;
    private static int totalCols;

    public static List<Integer> zigzagTraverse(List<List<Integer>> array) {

        Boolean goingDown = true;
        List<Integer> returnArr = new ArrayList<>();

        totalRows = array.size() - 1;
        totalCols = array.get(0).size() - 1;

        int row = 0;
        int col = 0;

        while (isSafe(row, col)) {

            returnArr.add(array.get(row).get(col));
            if (goingDown) {

                if (col == 0 || row == totalRows) {
                    goingDown = false;
                    if (row == totalRows) {
                        col++;
                    } else {
                        row++;
                    }
                } else {
                    row++;
                    col--;
                }

            } else {

                if (row == 0 || col == totalCols) {
                    goingDown = true;
                    if (col == totalCols) {
                        row++;
                    } else {
                        col++;
                    }
                } else {
                    col++;
                    row--;
                }
            }
        }

        return returnArr;
    }

    private static Boolean isSafe(int i, int j) {
        if (i >= 0 && j >= 0 && i <= totalRows && j <= totalCols) {
            return true;
        }
        return false;
    }

}
