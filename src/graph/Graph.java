package graph;

import graph.Vertex;

public class Graph {
	private final int MAX_VERTS = 20;
	private final int INFINITY = 0;
	
	// Daftar Vertex
	private Vertex vertexList[];
	
	// Adjancency Matrix
	private int adjMat[][];
	
	// index vetex saat ini
	private int vertId;
	
	public Graph() {
		vertexList = new Vertex[MAX_VERTS];
		
		adjMat = new int[MAX_VERTS][MAX_VERTS];
		vertId = 0;
		
		for(int j=0; j<MAX_VERTS; j++) {
			for(int k=0; k<MAX_VERTS; k++) {
				adjMat[j][k] = INFINITY;
			}
		}
	}
	
	public void addVertex(char lab) {
		vertexList[vertId++] = new Vertex(lab);
	}
	
	public void addEdge(int start, int end, int weight) {
		adjMat[start][end] = weight;
	}
	
	public void listAllNeightbor() {
		System.out.println("Jarak antar Vertex");
		
		for(int j=0; j<vertexList.length; j++) {
			if (vertexList[j] == null) break;
			
			String vertexLabel = "Vertex " + vertexList[j].label;
			System.out.println(vertexLabel);
			
			for (int k=0; k<vertexList.length; k++) {
				if (vertexList[k] == null) break;
				
				System.out.print(vertexLabel);
				if (adjMat[j][k] == 0) {
					System.out.print(" Tidak bertetangga dengan " );
					System.out.println(vertexList[k].label);
				} else {
					System.out.print(" bertetangga dengan ");
					System.out.print(vertexList[k].label);
					System.out.print(" dengan jarak = ");
					System.out.println(adjMat[j][k]);
				}
			}
			System.out.println();
		}
	}
	
	public Integer getCitiesDistance(int start, int end) {
		if (adjMat[start][end] == 0) {
			System.out.println("Invalid");
			return null;
		}
		return adjMat[start][end];
	}
	
	public void printAdjTable() {
		System.out.print(" ");
		for(int j=0; j<vertexList.length; j++) {
			if (vertexList[j] == null) break;
			System.out.print(" " + vertexList[j].label);
		}
		System.out.println();
		
		for(int j=0; j<vertexList.length; j++) {
			if (vertexList[j] == null) break;
			
			System.out.print(vertexList[j].label);
			for (int k=0; k<vertexList.length; k++) {
				if (vertexList[k] == null) break;
				
				if (adjMat[j][k] > 0) {
					System.out.print(" " +  1);
				} else System.out.print(" " + 0);
			}
			System.out.println();
		}
	}
}
