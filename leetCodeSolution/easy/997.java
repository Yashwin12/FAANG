// 1) Intutive solution. HACK  : https://www.youtube.com/channel/UCkP5vMAGeXt3IM5JbyzDxsA
// class Solution {
//     public int findJudge(int N, int[][] trust) {
           
//         if( trust.length == 0 )
//             return 1;
        
//         // person, trusts number of different people
//         Map<Integer, List<Integer> > trustingPeople = new HashMap<>();
        
//         for ( int[] arr: trust ) {
//             if( trustingPeople.containsKey ( arr[0] ) )
//                 trustingPeople.get( arr[0] ).add( arr[1] );
//             else{
//                 List<Integer> list = new ArrayList<>();
//                 list.add(arr[1]);
//                 trustingPeople.put( arr[0], list );
//             }                
//         }
        
//         // ele, count
//         Map<Integer, Integer > trustedPeople = new HashMap<>();
        
//         for ( int key : trustingPeople.keySet() )
//             for( int i = 0; i < trustingPeople.get(key).size(); i++ )
//                 trustedPeople.put( trustingPeople.get(key).get(i), trustedPeople.getOrDefault( trustingPeople.get(key).get(i), 0 ) + 1 );    
            
        
//         for ( int key: trustedPeople.keySet() )
//             if( trustedPeople.get(key) == N -1 && !trustingPeople.containsKey(key) )
//                return key;
        
//         return -1;         
//     }
// }

// 2) Non-intuitive, but clever way. 
class Solution {
    public int findJudge(int N, int[][] trust) {
        
        if(trust.length == 0) 
            return 1;
    
        // We need trustCount array for N+1 places as we've people range from 1-N. 
        int[] trustCount = new int[N+1];
        
        for ( int[] arr : trust ){
            trustCount[arr[0]]--;
            trustCount[arr[1]]++;
        }
        
        for( int i = 1; i < trustCount.length; i++ )
            if( trustCount[i] == N - 1 )
                return i;
     
        return -1;
    }
}


