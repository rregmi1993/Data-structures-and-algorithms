package graph;

public class DirectedWeightedGraph {

	int vertices;
	int adjacentMatrix[][];
	
	public DirectedWeightedGraph(int vertices) {
		this.vertices = vertices;
		this.adjacentMatrix = new int[vertices][vertices];
	}
	
	
	public void addEdge(int i, int j, int weight) {
		adjacentMatrix[i][j] = weight;
	}
	
	public void removeEdge(int i, int j) {
		adjacentMatrix[i][j] = 0;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<vertices; i++) {
			sb.append(i + ": ");
			for(int j : adjacentMatrix[i]) {
				sb.append((j>0 ? j : 0 ) + " ");
			}
			sb.append("\n");
		}
		
		return sb.toString();
	}
	
	
	
	public static void main(String arrs[]) {
		DirectedWeightedGraph dwg = new DirectedWeightedGraph(5);
		dwg.addEdge(0, 1, 2);
		dwg.addEdge(0, 4, 4);
		dwg.addEdge(0, 3, 6);
		dwg.addEdge(1, 3, 9);
		dwg.addEdge(1, 2, 1);
		dwg.addEdge(2, 3, 9);
		dwg.addEdge(3, 4, 8);
		System.out.println(dwg.toString());
	}
	
	
	
}
