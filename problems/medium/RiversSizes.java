import java.util.*;

// HACK: 1) https://www.geeksforgeeks.org/find-number-of-islands/
// HACK: 2) https://leetcode.com/discuss/interview-question/411357/
// The below solution is done using DFS. Moreover, it can also be done using BFS. 

// 1) T: O(now of rows *  now of cols) T: O(now of rows *  now of cols) 
// class Program {
//     public static List<Integer> riverSizes(int[][] matrix) {

//         List<Integer> list = new ArrayList<>();
//         int[][] visited = new int[matrix.length + 1][matrix[0].length + 1];

//         for (int row = 0; row < matrix.length; row++) {
//             for (int col = 0; col < matrix[0].length; col++) {

//                 if (visited[row][col] != 1 && matrix[row][col] == 1) {
//                     int count = 1;
//                     visited[row][col] = 1;
//                     count = helperFunc(row, col, matrix, visited, count);
//                     list.add(count);
//                 }
//             }
//         }
//         System.out.println("LIST" + list);
//         return list;
//     }

//     public static int helperFunc(int row, int col, int[][] matrix, int[][] visited, int count) {
//         // Up, Down, Right, Left
//         int[][] DIRECTIONS = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };

//         for (int[] d : DIRECTIONS) {

//             int x = row + d[0];
//             int y = col + d[1];

//             if (x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length && matrix[x][y] == 1
//                     && visited[x][y] == 0) {
//                 visited[x][y] = 1;
//                 count++;
//                 count = helperFunc(x, y, matrix, visited, count);
//             }

//         }
//         return count;
//     }
// }

// WRONG WAY: Extremely similar to above method. This would not work b/c "count"
// argument is "passed by value".
// HACK: https://www.educative.io/edpresso/pass-by-value-vs-pass-by-reference
// HACK:
// https://blog.penjee.com/passing-by-value-vs-by-reference-java-graphical/

// import java.util.*;

// class Program {
// // L, R, U, D
// private static final int[] dr = {0, 0, -1, 1};
// private static final int[] dc = {-1, 1, 0, 0};

// private static int totalRows;
// private static int totalCols;

// public static List<Integer> riverSizes(int[][] matrix) {
// totalRows = matrix.length;
// totalCols = matrix[0].length;

// int[][] visited = new int[totalRows + 1][totalCols + 1];

// List<Integer> riverCounts = new ArrayList<>();

// for( int row = 0; row < totalRows; row++ ){
// for( int col = 0; col < totalCols; col++ ){

// if( visited[row][col] == 1)
// continue;

// if( matrix[row][col] == 1){
// int count = 1;
// DFSHelper( matrix, visited, row, col, count );
// riverCounts.add(count);
// }

// }
// }

// return riverCounts;
// }

// public static void DFSHelper( int[][] matrix, int[][] visited, int
// currentRow, int currentCol, int count ){
// visited[currentRow][currentCol] = 1;

// for( int i = 0; i < dr.length; i++){
// int newRow = currentRow + dr[i];
// int newCol = currentCol + dc[i];

// System.out.println( "Row: " + newRow + " Col: " + newCol + " Count: " +
// count);

// Boolean safe = isSafe( matrix, visited, newRow, newCol, count );

// if( safe == true ){
// System.out.println( "Inside Safe condition! Count: " + count);
// DFSHelper( matrix, visited, newRow, newCol, count );
// }

// }
// }

// public static Boolean isSafe( int[][] matrix, int[][] visited, int
// currentRow, int currentCol, int count ){
// if( currentRow >= 0 && currentRow < totalRows && currentCol >= 0 &&
// currentCol < totalCols && visited[currentRow][currentCol] == 0 &&
// matrix[currentRow][currentCol] == 1 ){
// count++;
// visited[currentRow][currentCol] = 1;
// System.out.println( "Ji! Count: " + count);

// return true;
// }
// return false;
// }

// }

// 2) RIGHT WAY :  This passes int[] count instead of just int count, which sends the reference instead of just value. This is the correction of the above WRONG WAY!
import java.util.*;
class Program {
    // L, R, U, D
    private static final int[] dr = { 0, 0, -1, 1 };
    private static final int[] dc = { -1, 1, 0, 0 };

    private static int totalRows;
    private static int totalCols;

    public static List<Integer> riverSizes(int[][] matrix) {
        totalRows = matrix.length;
        totalCols = matrix[0].length;

        int[][] visited = new int[totalRows + 1][totalCols + 1];

        List<Integer> riverCounts = new ArrayList<>();

        for (int row = 0; row < totalRows; row++) {
            for (int col = 0; col < totalCols; col++) {

                if (visited[row][col] == 1)
                    continue;

                if (matrix[row][col] == 1) {
                    int[] count = { 1 };
                    DFSHelper(matrix, visited, row, col, count);
                    riverCounts.add(count[0]);
                }

            }
        }

        return riverCounts;
    }

    public static void DFSHelper(int[][] matrix, int[][] visited, int currentRow, int currentCol, int[] count) {
        visited[currentRow][currentCol] = 1;

        for (int i = 0; i < dr.length; i++) {
            int newRow = currentRow + dr[i];
            int newCol = currentCol + dc[i];

            Boolean safe = isSafe(matrix, visited, newRow, newCol, count);

            if (safe == true) {

                DFSHelper(matrix, visited, newRow, newCol, count);
            }

        }
    }

    public static Boolean isSafe(int[][] matrix, int[][] visited, int currentRow, int currentCol, int[] count) {
        if (currentRow >= 0 && currentRow < totalRows && currentCol >= 0 && currentCol < totalCols
                && visited[currentRow][currentCol] == 0 && matrix[currentRow][currentCol] == 1) {
            count[0]++;
            visited[currentRow][currentCol] = 1;

            return true;
        }
        return false;
    }

}


// 3) RIGHT WAY :  This passes Count count instead of just int count, which sends the reference instead of just value. This is the correction of the above WRONG WAY!
// import java.util.*;

// class Program {
	
// 	private static class Count{
// 		private int count;
		
// 		Count( int v ){
// 			this.count = v; 
// 		}
		
// 		public int getCount(){
// 			return count;
// 		}
		
// 		public void setCount( int v ){
// 			this.count = v; 
// 		}
			
// 	}
	
// 	// L, R, U, D
// 	private static final int[] dr = {0, 0, -1, 1};
// 	private static final int[] dc = {-1, 1, 0, 0};
	
// 	private static int totalRows;
// 	private static int totalCols;
	
//   public static List<Integer> riverSizes(int[][] matrix) {
// 		totalRows = matrix.length;
// 		totalCols = matrix[0].length;
		
//     int[][] visited = new int[totalRows + 1][totalCols + 1];
		
// 		List<Integer> riverCounts = new ArrayList<>();
		
// 		for( int row = 0; row < totalRows; row++ ){
// 			for( int col = 0; col < totalCols; col++ ){
				
// 				if( visited[row][col] == 1)
// 					continue;
				
// 				if( matrix[row][col] == 1){
//                     // int[] count = {1};
//                     Count count = new Count(1);
// 					DFSHelper( matrix, visited, row, col, count );
// 					riverCounts.add(count.getCount());
// 				}
				
// 			}
// 		}
		
// 		return riverCounts;
//   }
	
// 	public static void DFSHelper( int[][] matrix, int[][] visited, int currentRow, int currentCol, Count count ){
// 		visited[currentRow][currentCol] = 1;
		
// 		for( int i = 0; i < dr.length; i++){
// 			int newRow = currentRow + dr[i];
// 			int newCol = currentCol + dc[i];
			
// 			Boolean safe = isSafe( matrix, visited, newRow, newCol, count );
			
// 			if( safe == true ){
				
// 				DFSHelper( matrix, visited, newRow, newCol, count );
// 			}
			
// 		}
// 	}
	
// 	public static Boolean isSafe( int[][] matrix, int[][] visited, int currentRow, int currentCol, Count count ){
// 		if( currentRow >= 0 && currentRow < totalRows && currentCol >= 0 && currentCol < totalCols && visited[currentRow][currentCol] == 0 && matrix[currentRow][currentCol] == 1 ){
            
//             count.setCount( count.getCount() + 1 );
//             // count[0]++;
// 			visited[currentRow][currentCol] = 1;

// 			return true;
// 		}
// 		return false;		
// 	}

// }
