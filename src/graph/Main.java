package graph;

import graph.Graph;

public class Main {
	public static void main(String[] args) {
		Graph graph = new Graph();
		char cities[] = {'A', 'B', 'C', 'D'};
		for(char city : cities) {
			graph.addVertex(city);
		}
		
		graph.addEdge(0, 1, 50); // AB 50
		
		graph.addEdge(2, 1, 20); // CB 20
		graph.addEdge(1, 0, 50); // BA 50
		graph.addEdge(2, 0, 70); // CA 70
		
		graph.addEdge(3, 1, 30); // DB 30
		graph.addEdge(1, 0, 50); // BA 50
		graph.addEdge(3, 0, 80); // DA 80
		
		graph.addEdge(1, 2, 20); // BC 20
		graph.addEdge(2, 3, 20); // CD 20
		graph.addEdge(1, 3, 20); // BD 40
		
		graph.listAllNeightbor();
		//graph.printAdjTable();
		
		//System.out.println(graph.getCitiesDistance(1, 2));
		//System.out.println(graph.getCitiesDistance(1, 4));
	}
}
