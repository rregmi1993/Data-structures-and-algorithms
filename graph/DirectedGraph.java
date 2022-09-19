package graph;

public class DirectedGraph {

	int vertices;
	int adjacentMatrix[][];
	
	public DirectedGraph(int vertices) {
		this.vertices = vertices;
		this.adjacentMatrix = new int[vertices][vertices];
	}
	
	
	public void addEdge(int i, int j) {
		adjacentMatrix[i][j] = 1;
	}
	
	public void removeEdge(int i, int j) {
		adjacentMatrix[i][j] = 0;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<vertices; i++) {
			sb.append(i + ": ");
			for(int j : adjacentMatrix[i]) {
				sb.append((j>0 ? "1" : "0") + " ");
			}
			sb.append("\n");
		}
		
		return sb.toString();
	}
	
	
	
	public static void main(String arrs[]) {
		DirectedGraph dg = new DirectedGraph(5);
		dg.addEdge(0, 1);
		dg.addEdge(0, 4);
		dg.addEdge(0, 3);
		dg.addEdge(1, 3);
		dg.addEdge(1, 2);
		dg.addEdge(2, 3);
		dg.addEdge(3, 4);
		System.out.println(dg.toString());
	}
	
	
	
}
