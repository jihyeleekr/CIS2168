package DFSpack;

import java.util.List;

public class Main {

	public static void main(String[] args) {
		// Simple weighted direct graph(no cycle)
		 int numVertices = 4;
	     int[][] adjacencyMatrix = {{0,5,0,40},{0,0,10,0},{0,0,0,10},{0,0,0,0}};
	     
	     WeightedGraph graph = new WeightedGraph(numVertices, adjacencyMatrix); 
		 
		 
		 
	     try {
	            List<Integer> topologicalOrder1 = graph.topologicalSort();
	            System.out.println("Topological Order: " + topologicalOrder1);
	        } catch (RuntimeException e) {
	            System.out.println(e.getMessage());
	        }
	     
		 //Shortest path from 0 to every connected vertices.
	     System.out.println();
		 graph.dijkstra(0);
	     
		 
	     // Weighted directed graph with cycle
	     int[][] adjacencyMatrix2 = {{0,3,4,0},{0,0,0,0},{0,2,0,4},{0,0,10,0}};
	     
	     WeightedGraph graph2 = new WeightedGraph(numVertices, adjacencyMatrix2);
	       
	     
	     try {
	            List<Integer> topologicalOrder = graph2.topologicalSort();
	            System.out.println("Topological Order: " + topologicalOrder);
	        } catch (RuntimeException e) {
	            System.out.println(e.getMessage());
	        }
	      //Shortest path from 0 to every connected vertices.
		     System.out.println();
			 graph2.dijkstra(0);
	     
	}

}
