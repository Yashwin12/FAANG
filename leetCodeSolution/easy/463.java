// 1) Lengthy (inefficient) solution
// class Solution {
    
//     private int perimeter = 0;
    
//     public int islandPerimeter(int[][] grid) {
//         int[][] visited = new int[grid.length][grid[0].length];
        
//         for ( int row = 0; row< grid.length; row++){
//             for ( int col =0; col< grid[0].length; col++){
                
//                 if( grid[row][col] == 1 && visited[row][col] == 0){
//                     visited[row][col] = 1;
//                     helperMethod( row, col, visited, grid );
//                     return perimeter;
//                 }
//             }
//         }
        
//         return perimeter;
//     }
    
//     public void helperMethod ( int row, int col, int[][] visited, int[][] grid){
//         // Up, Down, Left, Right
//         int[][] directions = { {-1,0}, {1,0}, {0, -1}, {0,1} };

//         for (int[] dir: directions ){
//             int rc = dir[0] + row;
//             int cc = dir[1] + col;
//             if( rc >= 0 && rc < grid.length && cc >= 0 && cc < grid[0].length && grid[rc][cc] == 1 ){
//                 // it is safe to enter this.
//                 if ( visited[rc][cc] == 0  ){
//                     visited[rc][cc] = 1;
//                     helperMethod( rc, cc, visited, grid );                    
//                 }
//                 else if( visited[rc][cc] == 1 ){
//                     continue;
//                 }
//             }
//             else {              
//                 perimeter++;                
//             }
//         }
//     }
// }


// 2) Efficient and better solution
class Solution {

    public int islandPerimeter(int[][] grid) {
        if ( grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        
        int result = 0;
        for (int i =0; i< grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                
                if( grid[i][j] == 1){
                    result += 4;
                    if( i>0 && grid[ i - 1][j] == 1)
                        result -= 2;
                    if( j>0 && grid[ i ][j - 1] == 1)
                        result -= 2;
                }
            }
        }
                
        return result;
    }
}