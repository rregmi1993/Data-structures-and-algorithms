package graph;

public class UndirectedGraph {
	
	int vertices;
	int adjacentMatrix [][];
	
	public UndirectedGraph(int vertices) {
		this.vertices = vertices;
		adjacentMatrix = new int[vertices][vertices];
	}
	
	
	public void addEdge(int i, int j) {
		adjacentMatrix[i][j] = 1;
		adjacentMatrix[j][i] = 1;
		
	}
	
	public void removeEdge(int i, int j) {
		adjacentMatrix[i][j] = 0;
		adjacentMatrix[j][i] = 0;
		
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<vertices; i++) {
			sb.append(i + ": ");
			for(int j : adjacentMatrix[i]) {
				sb.append((j == 1 ? "1": "0") + " ");
			}
			sb.append("\n");
		}
		return sb.toString();
	}

	
	public static void main(String arrs[]) {
		UndirectedGraph uGraph = new UndirectedGraph(5);
		uGraph.addEdge(0, 1);
		uGraph.addEdge(0, 4);
		uGraph.addEdge(0, 3);
		uGraph.addEdge(1, 3);
		uGraph.addEdge(1, 2);
		uGraph.addEdge(4, 3);
		uGraph.addEdge(3, 2);
		System.out.println(uGraph.toString());
	}

}
