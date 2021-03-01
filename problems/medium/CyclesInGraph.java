// IMPORTANT

// import java.util.*;

// HACK: https://www.geeksforgeeks.org/detect-cycle-in-a-graph/
// DFS for a DIRECTED Graph
// class Program {

//   public boolean cycleInGraph(int[][] edges) {

// 		int[] visited = new int[ edges.length];
// 		int[] inStack = new int[ edges.length]; 

// 		// This is to cover each and every node in the Graph, i.e disconneted Graph. If the graph is ONLY connected  then this for loop is not required..
// 		for( int row = 0; row < edges.length; row++ ){

// 			if( visited[row] == 1)
// 				continue;

// 			if( containsCycle( row, edges, visited, inStack ) ){
// 				return true;
// 			}

// 		}		
//     return false;
//   }

// 	private boolean containsCycle( int row, int[][] edges, int[] visited, int[] inStack ){

// 		if( inStack[row] == 1 )
// 			return true;

// 		if( visited[row] == 1 )
// 			return false;

// 		visited[row] = 1;		
// 		inStack[row] = 1;

// 		int[] neighbors = edges[row];

// 		for( int neighbor: neighbors ){			
// 			if( containsCycle( neighbor, edges, visited, inStack) ){
// 				return true;	
// 			} 			
// 		}
// 		inStack[row] = 0;

// 		return false;		
// 	}	
// }

// HACK: https://www.geeksforgeeks.org/detect-cycle-in-a-directed-graph-using-bfs/
// BFS, this is using topological Sort.
import java.util.*;

class Program {
	public boolean cycleInGraph(int[][] edges) {

		int len = edges.length;
		int[] inOrder = new int[len];

		// InOrder counts;
		for (int i = 0; i < len; i++) {
			for (int ele : edges[i]) {
				inOrder[ele]++;
			}
		}

		Queue<Integer> queue = new LinkedList<>();

		for (int i = 0; i < inOrder.length; i++) {
			if (inOrder[i] == 0)
				queue.add(i);
		}

		int count = 0;

		while (!queue.isEmpty()) {
			int currentEle = queue.poll();
			count++;

			if (edges[currentEle].length > 0) {
				removeConnections(edges[currentEle], queue, inOrder);
			}
		}

		if (count == len)
			return false;

		return true;
	}

	private void removeConnections(int[] list, Queue<Integer> queue, int[] inOrder) {
		for (int ele : list) {

			inOrder[ele]--;

			if (inOrder[ele] == 0)
				queue.add(ele);

		}
	}

}
