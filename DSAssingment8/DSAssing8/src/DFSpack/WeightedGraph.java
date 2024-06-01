package DFSpack;
import java.util.Arrays;
import java.util.*;
public class WeightedGraph {
	
	private int[][] adjacencyMatrix;
	private int numVertices;
	
	// Constructor. Create an empty adjacency Matrix with given number of vertices.
	
	public WeightedGraph(int numVertices,int[][] adjacencyMatrix) {
		this.numVertices = numVertices;
        this.adjacencyMatrix = adjacencyMatrix;
		}
	// Dijkstra's Algorithm
	public void dijkstra(int startPoint) {
		
		// Create an array which stores all the dists that parent vertex has.
		int dist[] = new int[numVertices]; 
        // Check whether the vertex was visited or not
        boolean[] visited = new boolean[numVertices];
        
        for (int i = 0; i < numVertices; i++) {
			dist[i] = Integer.MAX_VALUE;
			visited[i] = false;
		}

        // Mark the parent's(which is the starting point) dist 0 
        dist[startPoint] = 0;
        
        
        // Now check whether the vertices are connected to the parent vertex
        for (int count = 0; count < numVertices - 1; count++) {
			
			int u = shortPath(dist, visited);

			// Mark the picked vertex as processed
			visited[u] = true;

			// Update dist value of the adjacent vertices of
			// the picked vertex.
			for (int v = 0; v < numVertices; v++) {
				
				int newDist = dist[u] + adjacencyMatrix[u][v];
			
				if (!visited[v] && adjacencyMatrix[u][v] != 0&& dist[u] != Integer.MAX_VALUE
					&& newDist < dist[v]) {
					dist[v] = newDist;
				}
			}
        }
        for(int i = 0; i < numVertices; i++) {
        	System.out.println("The shortest path from " + startPoint + " to "+ i + " is: " + dist[i]);
        }
        
    }
	
	// Find the index for smallest weight.
	private int shortPath(int dist[], boolean vistied[])
	{
		// Initialize min value
		int min = Integer.MAX_VALUE, min_index = -1;

		for (int v = 0; v < numVertices; v++)
			if (vistied[v] == false && dist[v] <= min) {
				min = dist[v];
				min_index = v;
			}

		return min_index;
	}
	
	// Topological Sort
	 public List<Integer> topologicalSort() {
		 
		 // Create an int array which contains edges for v
		 int[] edges = new int[numVertices];
	     for (int i = 0; i < numVertices; i++) {
	    	 for (int j = 0; j < numVertices; j++) {
	    		 // If there is an edge with vertex v then add that vertex into edges.
	    		 if (adjacencyMatrix[i][j] == 1) {
	    			 edges[j]++;
	    			 }
	    		 }
	    	 }
	     
	     Queue<Integer> queue = new LinkedList<>();
	     for (int i = 0; i < numVertices; i++) {
	    	 // If there is no any other vertices that are connected with i then add it into queue
	    	 if (edges[i] == 0) {
	    		 queue.add(i);
	    		 }
	    	 }
	     
	     // If there is an edge that has added into the queue(which means no cycle)
	     List<Integer> order = new ArrayList<>();
	     while (queue.isEmpty() != true) {
	    	 // Pull out the vertex then add it into the order.
	    	 int current = queue.poll();
	    	 order.add(current);
	    	 // Check any other connected vertices
	    	 for (int neighbor = 0; neighbor < numVertices; neighbor++) {
	    		 if (adjacencyMatrix[current][neighbor] == 1) {
	    			 // Because we added the edge into our array we remove the edge.
	    			 edges[neighbor]--;
	    			 if (edges[neighbor] == 0) {
	    				 queue.add(neighbor);
	    				 }
	    			 }
	    		 }
	    	 }
	     if (order.size() != numVertices) {
	    	 // Graph has a cycle, attempt to remove an edge
	    	 System.out.println("\nThe graph has a cycle.");
	    	 for (int i = 0; i < numVertices; i++) {
	    		 if (edges[i] > 0) {
	    			 for (int neighbor = 0; neighbor < numVertices; neighbor++) {
	    				 if (adjacencyMatrix[i][neighbor] == 1) {
	                            // Remove the edge (i, neighbor)
	    					 adjacencyMatrix[i][neighbor] = 0;
	    					 adjacencyMatrix[i][neighbor] = 0;
	                            // Re-run topological sort
	    					 return topologicalSort();
	    					 }
	    				 }
	    			 }
	    		 }
	            // If no edge can be removed, the graph has an unsolvable cycle
	    	 throw new RuntimeException("Graph contains an unsolvable cycle");
	    	 }
	     return order;
	    }
}
