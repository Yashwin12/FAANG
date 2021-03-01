import java.util.*;

class Program {
	
    private int totalRow = 0;
    private int totalCol = 0;	

    // Up, Down, Right, Left
    private static int[][] DIRECTIONS = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };

  public int[][] removeIslands(int[][] matrix) {
    totalRow = matrix.length;
		totalCol = matrix[0].length;
				
		int[][] visited = new int[totalRow + 1][totalCol + 1];
		
		for( int row = 0; row < totalRow; row++ ){
			for( int col = 0; col < totalCol; col++ ){
								
				boolean rowIsBorder = row == 0 || row == matrix.length - 1;
				boolean colIsBorder = col == 0 || col == matrix[0].length - 1;
				boolean isBorder = rowIsBorder || colIsBorder;
				
				if( !isBorder || visited[row][col] == 1 || matrix[row][col] == 0 )
					continue;
				
				findOnesConnectedWithBorder( matrix, visited, row, col );									
			}			
		}
		
		for( int row = 0; row < totalRow; row++ ){
			for( int col = 0; col < totalCol; col++ ){
				
				if( visited[row][col] == 0 && matrix[row][col] == 1)
					matrix[row][col] = 0;
				
				visited[row][col] = 1; 
			}
		}
		
    return matrix;
  }
	
	private void findOnesConnectedWithBorder( int[][] matrix, int[][] visited, int row, int col ){
		visited[row][col] = 1;
		
		for( int[] dir: DIRECTIONS ){
			int dr = row + dir[0];
			int dc = col + dir[1];
						
			if( inBounds( matrix, visited, dr, dc ) && matrix[dr][dc] == 1 ){
					findOnesConnectedWithBorder( matrix, visited, dr, dc );
			}			
		}		
	}
		
	private boolean inBounds( int[][] matrix, int[][] visited, int row, int col ){
		if( row >= 0 && row < totalRow && col >= 0 && col < totalCol && visited[row][col] == 0 )
			return true;			
		
		return false;
	}

}