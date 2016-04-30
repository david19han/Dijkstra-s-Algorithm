/**
 * @author davidhan
 */
import java.awt.List;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

/**
 * @param maker-
 *            GraphMaker that will allow for graph to be built
 * @param vertexList-
 *            hashmap that hashes names of vertices to DijkstraVertex. basically allows
 *            for the names of vertices to be easily associated with its
 *            respective DijkstraVertex
 * @param dVertices
 *            - priority queue that will put the DijkstraVertices in its natural
 *            order based on its compareTo
 * @param startVertex
 *            - String that represents the name of the startVertex
 * @param endVertex
 *            - String that represents the name of the endVertex
 * @author davidhan
 *
 */
public class Dijkstra {
	private GraphMaker maker;
	private Map<String, DijkstraVertex> vertexList;
	private Queue<DijkstraVertex> dVertices;
	private String startVertex;
	private String endVertex;

	/**
	 * Constructor for Dijkstra
	 * 
	 * @param theMaker
	 */
	public Dijkstra(GraphMaker theMaker) {
		maker = theMaker;
	}

	/**
	 * Primary method that runs the algorithm.
	 * 
	 * @throws FileNotFoundException
	 */
	public void runAlgorithm() throws FileNotFoundException {
		//asks the user for information
		maker.promptUserFile();// /Users/davidhan/Documents/Algorithms/Dijkstra/JapanCities.txt
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the starting vertex");
		startVertex = in.next();
		System.out.println("Enter the ending vertex");
		endVertex = in.next();

		Graph<Vertex> theGraph = maker.getFileGraph();// make the graph
		vertexList = new HashMap<String, DijkstraVertex>();
		Map<String, Vertex> nameVertices = maker.getNameVertices();
		dVertices = new PriorityQueue<DijkstraVertex>();

		// fill in the vertexList hashMap with strings and DijkstraVertices,
		// with a default of infinity and no parent.
		for (String i : nameVertices.keySet()) {
			vertexList.put(i, new DijkstraVertex(i, Double.MAX_VALUE, null));
		}
		//fill in the priority queue with the DijkstraVertices found in vertexList
		for (String j : vertexList.keySet()) {
			dVertices.add(vertexList.get(j));
		}
		//Make the startVertex have no parent and a distance of 0 to itself.
		this.updateDistance(vertexList.get(startVertex), 0, null);
		//tracker - list of vertices whose shortest paths have already been confirmed
		ArrayList<DijkstraVertex> tracker = new ArrayList<DijkstraVertex>();

		//Goes through the priority queue dVertices and extracts the smallest distance node (DijkstraVertex)
		//relaxes to find the distances to all vertices adjacent to it.
		while (dVertices.size() > 0) {
			DijkstraVertex head = dVertices.remove();//parent
			tracker.add(head);
			//list of adjacent vertices.
			Collection<Vertex> adjacents = theGraph.getAdjacentVertices(nameVertices.get(head.getName()));
			for (Vertex j : tracker) {
				//remove all vertices that have already been confirmed earlier by the algorithm
				adjacents.remove(j);
			}
			for (Vertex i : adjacents) {
				//updates the priority queue if the original distance is greater than the newDistance
				DijkstraVertex updateThis = vertexList.get(i.getName());
				double newDistance = head.getDistance()
						+ theGraph.getWeight(nameVertices.get(head.getName()), nameVertices.get(updateThis.getName()));
				if (updateThis.getDistance() > newDistance) {
					this.updateDistance(updateThis, newDistance, head);
				}
			}
		}
		System.out.println("The shortest path is " + vertexList.get(endVertex).getDistance());
		System.out.println(this.shortestPath());
	}

	/**
	 * Updates the priority queue by deleting node DijkstraVertex and adding a
	 * new node with the updated distance and parent. Puts in vertexList hashMap
	 * the updated DijkstraVertex. Will allow for fast lookup later.
	 * 
	 * @param v
	 * @param distance
	 * @param parent
	 */
	public void updateDistance(DijkstraVertex v, double distance, DijkstraVertex parent) {
		DijkstraVertex added = new DijkstraVertex(v.getName(), distance, parent);
		boolean whatt = dVertices.remove(v);
		dVertices.add(added);
		// dPVertices.remove(v);
		// dPVertices.add(added);
		vertexList.put(v.getName(), added);
	}

	/**
	 * Returns the shortest path to endVertex. Uses a stack structure.
	 * 
	 * @return resultPath - the shortest path.
	 */
	public String shortestPath() {
		Stack<String> thePath = new Stack<String>();
		String resultPath = "";
		String theParent = endVertex;
		thePath.push(theParent);
		while (!theParent.equals(startVertex)) {
			theParent = vertexList.get(theParent).getParent().getName();
			thePath.push(theParent);
		}
		while (!thePath.isEmpty()) {
			resultPath += thePath.pop() + "::";
		}
		return resultPath;
	}

}
