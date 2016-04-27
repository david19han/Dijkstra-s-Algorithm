import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Dijkstra {

	public Dijkstra(){
		
	}
	
	public void runAlgorithm(GraphMaker maker) throws FileNotFoundException{
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the starting vertex");
		String startVertex = in.next();
		System.out.println("Enter the ending vertex");
		String endVertex = in.next();
		
		Graph<Vertex> theGraph = maker.getFileGraph();
		Set<DijkstraVertex> dVertices = new HashSet<DijkstraVertex>(); //set.add
		Map<Integer, Vertex> nameVertices = maker.getNameVertices();
		Map<Integer,DijkstraVertex> vertexList = null;
		int counter = 1;
		for(int i:nameVertices.keySet()){
			//name and distance
			Vertex v = nameVertices.get(i);
			vertexList.put(counter,new DijkstraVertex(v.getName(),Integer.MAX_VALUE,null));
		}
		
		for(int j:vertexList.keySet()){
			dVertices.add(vertexList.get(j));
		}
		
		
		
		
	}
}
