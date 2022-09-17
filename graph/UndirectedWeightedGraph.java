package graph;

public class UndirectedWeightedGraph {

	int vertices;
	int adjacentMatrix[][];
	
	public UndirectedWeightedGraph(int vertices){
		this.vertices = vertices;
		adjacentMatrix = new int[vertices][vertices];
	}
	
	public void addEdge(int i, int j, int weight) {
		adjacentMatrix[i][j] = weight;
		adjacentMatrix[j][i] = weight;
		
	}
	
	public void removeEdge(int i, int j, int weight) {
		adjacentMatrix[i][j] = 0;
		adjacentMatrix[j][i] = 0;
		
	}
	
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<vertices; i++) {
			sb.append(i + ": ");
			for(int j: adjacentMatrix[i]) {
				sb.append((j>0 ? j : "0") + " ");
			}
			sb.append("\n");
		}
		
		return sb.toString();
	}
	
	public static void main(String arrs[]) {
		UndirectedWeightedGraph uWightGraph = new UndirectedWeightedGraph(5);
		uWightGraph.addEdge(0, 1, 1);
		uWightGraph.addEdge(0, 4, 7);
		uWightGraph.addEdge(0, 3, 2);
		uWightGraph.addEdge(1, 3, 3);
		uWightGraph.addEdge(1, 2, 9);
		uWightGraph.addEdge(4, 3, 5);
		uWightGraph.addEdge(3, 2, 7);
		System.out.println(uWightGraph.toString());
	}
}
