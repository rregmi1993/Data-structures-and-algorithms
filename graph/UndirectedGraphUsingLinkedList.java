package graph;

import java.util.LinkedList;

public class UndirectedGraphUsingLinkedList {
	
	int vertices;
	LinkedList<Integer>[] adjList;
	UndirectedGraphUsingLinkedList(int vertices){
		this.vertices = vertices;
		this.adjList = new LinkedList[vertices];
		for(int i=0; i<vertices; i++) {
			adjList[i] = new LinkedList<>();
		}
		
	}
	
	void addEdge(int i, int j) {
		adjList[i].add(j);
		adjList[j].add(i);
	}
	
	public void display() {
		for(int i=0; i<vertices; i++) {
			System.out.print("Vertex " + i + ": ");
			for (int j = 0; j < adjList[i].size(); j++) {
				System.out.print("->" + adjList[i].get(j));
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		UndirectedGraphUsingLinkedList ugl = new UndirectedGraphUsingLinkedList(5);
		ugl.addEdge(0, 1);
		ugl.addEdge(0, 4);
		ugl.addEdge(0, 3);
		ugl.addEdge(1, 2);
		ugl.addEdge(1, 3);
		ugl.addEdge(2, 3);
		ugl.addEdge(3, 4);
		ugl.display();
	}
}
