// VERY IMPORTANT AND TRICKY
// 1) SOLUTION HACK: https://www.youtube.com/watch?v=TzoDDOj60zE
class Solution {

    class Coords {
        int x;
        int y;

        Coords(int x, int y) {
            this.x = x;
            this.y = y;
        }

        // One needs to override hashCode and equals method in a CLASS for below reasonse :  
        // 1) Without overriding "equals", "contains" method uses "reference/ addresss" equality. If the objects are distinct instances with the same fields then contains will return false. 
        // 2) Java have a rule "If two objects are equal using Object class equals method, then the hashcode method should give the same value for these two objects"
        
        // Summary : One must override hashCode() in every class that overrides equals(). Failure to do so will result in a violation of the general contract for Object.hashCode(), which will prevent one's class from functioning properly in conjunction with all hash-based collections, including HashMap, HashSet, and Hashtable.

        // HACK: Refer to 3 upvoted ans on https://stackoverflow.com/questions/2265503/why-do-i-need-to-override-the-equals-and-hashcode-methods-in-java
        @Override
        public boolean equals(Object o) {

            if ( o == null || this.getClass() != o.getClass() ) // both object are instances of same class or not
                return false;
            
            Coords coordsObj = (Coords) o;
            return x == coordsObj.x && y == coordsObj.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    public int orangesRotting(int[][] grid) {

        Set<Coords> fresh = new HashSet<>();
        Set<Coords> rotten = new HashSet<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                if (grid[i][j] == 1)
                    fresh.add(new Coords(i, j));

                else if (grid[i][j] == 2)
                    rotten.add(new Coords(i, j));
            }
        }

        int minutes = 0;

        // Up, Down, Left, Right
        int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

        while (fresh.size() > 0) {
            Set<Coords> infected = new HashSet<>();

            for (Coords currentRotten : rotten) {
                for (int[] dir : directions) {
                    int newRow = currentRotten.x + dir[0];
                    int newCol = currentRotten.y + dir[1];

                    if (fresh.contains(new Coords(newRow, newCol))) {
                        fresh.remove(new Coords(newRow, newCol));
                        infected.add(new Coords(newRow, newCol));
                    }
                }
            }

            if (infected.size() == 0)
                return -1;

            rotten = infected;
            minutes++;
        }
        return minutes;
    }
}

// 2) HACK: https://www.youtube.com/watch?v=vzPobzjJYbw

class Solution {
    
    class Coords { 
        int x;
        int y;
        int layer;
        
        Coords(int x, int y, int layer) {
            this.x = x;
            this.y = y;
            this.layer = layer;
        }
        // This Class doesn't need to override equals and hashCode methods as we're not using Hash-based collections.
    }
    
    public int orangesRotting(int[][] grid) {
               
        Queue<Coords> rotten = new ArrayDeque<>();         
                
        for ( int i = 0; i < grid.length; i ++ ){
            for( int j = 0; j < grid[0].length; j++ ){
                            
                if( grid[i][j] == 2 )
                    rotten.add( new Coords(i,j, 0) );                              
            }
        }
                        
        // Up, Down, Left, Right
        int[][] directions = { {-1,0}, {1,0}, {0, -1}, {0,1} };
        int minutes = 0;
        
        while ( rotten.size() > 0 ){
            Coords currentRotten = rotten.poll();         
            
            minutes = Math.max( minutes, currentRotten.layer );
            
            for ( int[] dir : directions ) {
                int newRow = currentRotten.x  + dir[0];
                int newCol = currentRotten.y  + dir[1];
                    
                if ( newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length && grid[newRow][newCol] == 1 ){
                    rotten.offer( new Coords(newRow, newCol, currentRotten.layer + 1) );
                    grid[newRow][newCol] = 2;                    
                }
                
            }                        
        }
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1)
                    return -1;                
            }
        }
        
        return minutes;
    }
}
