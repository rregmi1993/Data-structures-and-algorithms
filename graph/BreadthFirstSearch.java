package graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {
	int vertices;
	LinkedList<Integer>[] adjList;
	
	public BreadthFirstSearch(int vertices) {
		this.vertices = vertices;
		adjList = new LinkedList[vertices];
		for(int i=0; i<vertices; i++) {
			adjList[i] = new LinkedList<>();
		}
	}
	
	public void addEdge(int source, int destination) {
		adjList[source].add(destination);
		adjList[destination].add(source);
		
	}
	
	public void bfs(int source) {
		boolean[] visited = new boolean[vertices];
		Queue<Integer> queue = new LinkedList<Integer>();
		visited[source] = true;
		queue.add(source);
		while(queue.size() != 0) {
			source = queue.poll();
			System.out.println(source + " " );
			Iterator<Integer> i = adjList[source].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
		}
	}
	
	private void printGraph() {
		for(int i=0; i<vertices; i++) {
			System.out.print("vertex " + i + ": ");
			for(int j=0; j<adjList[i].size(); j++) {
				System.out.print("->" + adjList[i].get(j));
			}
			System.out.println();
		}
		
	}
	
	public static void main(String[] args) {
		BreadthFirstSearch graph = new BreadthFirstSearch(5);

		graph.addEdge(0, 1);
		graph.addEdge(0, 4);
		graph.addEdge(0, 3);
		graph.addEdge(1, 2);
		graph.addEdge(1, 3);
		graph.addEdge(2, 3);
		graph.addEdge(3, 4);

		graph.printGraph();
		
		graph.bfs(0);

	}



}
