
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (int[] a, int[] b) -> {
            return a[0] - b[0];
        });

        List<int[]> list = new ArrayList<>();

        for (int[] currentPair : intervals) {

            if (list.isEmpty() || list.get(list.size() - 1)[1] < currentPair[0]) {
                list.add(currentPair);
            }

            else {
                // Eligible to merge

                int startInterval = Math.min(list.get(list.size() - 1)[0], currentPair[0]);
                int endInterval = Math.max(list.get(list.size() - 1)[1], currentPair[1]);

                list.remove(list.size() - 1);
                list.add(new int[] { startInterval, endInterval });
            }

        }

        return list.toArray(new int[list.size() - 1][]);
    }
}


class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> intervalsList = new ArrayList<>();
        
        for( int[] interval : intervals){
            intervalsList.add( interval );
        }
        
        Collections.sort( intervalsList, (int[] a, int[] b ) -> {
            return a[0] - b[0];
        });
                
        for( int i = 0; i < intervalsList.size() - 1; i++ ){
            int[] currentPair = intervalsList.get(i);
            int[] nextPair = intervalsList.get(i+1);
            
            if( currentPair[1] >= nextPair[0] ){
                int[] newPair = new int[2];
                newPair[0] = Math.min( currentPair[0], nextPair[0]);
                newPair[1] = Math.max( currentPair[1], nextPair[1] );
                
                intervalsList.remove(i);
                
                intervalsList.set(i, newPair );
                i--;
            }            
        }
        
        return intervalsList.toArray( new int[intervalsList.size()][]  );
    }
}