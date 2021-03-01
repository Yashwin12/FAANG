// HACK for both the solutions: https://leetcode.com/problems/letter-case-permutation/discuss/115485/Java-Easy-BFS-DFS-solution-with-explanation

// 1) BFS
// class Solution {
//     public List<String> letterCasePermutation(String S) {

//         Queue<String> queue = new LinkedList<>();
//         queue.offer( S );

//         for( int i = 0; i < S.length(); i++ ){
//             if( Character.isDigit( S.charAt(i) ))
//                 continue;

//             // Below is required as we do not want to touch the "newly" added items in the queue. 
//             int size = queue.size();
//             for( int j = 0; j < size; j++ ){
//                 char[] current = queue.poll().toCharArray();

//                 current[i] = Character.toUpperCase(current[i]);
//                 queue.offer( String.valueOf(current) );

//                 current[i] = Character.toLowerCase(current[i]);
//                 queue.offer( String.valueOf(current) );
//             }            
//         }
//         return new LinkedList<>(queue);
//     }
// }

// 2) DFS
class Solution {
    public List<String> letterCasePermutation(String S) {
        List<String> list = new LinkedList<>();
        permHelper(S.toCharArray(), 0, list);
        return list;
    }

    private void permHelper(char[] strArr, int pos, List<String> list) {
        if ( pos == strArr.length) {
            list.add(new String(strArr));
            return;
        }

        if ( Character.isDigit(strArr[pos])) {
            permHelper(strArr, pos + 1, list);
            return;
        }

        strArr[pos] = Character.toUpperCase(strArr[pos]);
        permHelper(strArr, pos + 1, list);

        strArr[pos] = Character.toLowerCase(strArr[pos]);
        permHelper(strArr, pos + 1, list);

    }
}