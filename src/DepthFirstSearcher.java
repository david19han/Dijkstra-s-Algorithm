import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;


public class DepthFirstSearcher {
	
	private HashMap<Vertex,Boolean> visited;
	private HashMap<Vertex,Integer> pre;
	private HashMap<Vertex,Integer> post;
	private static Integer clock;

	/*
	 * Depth-first search exploration
	 */
	public void explore(Graph<Vertex> g, Vertex v) {
		visited.put(v, true);
		pre.put(v, clock);
		clock++;
		System.out.println(v.getName());
		for (Vertex u : g.getAdjacentVertices(v))
			if (!visited.get(u)) 
				explore(g, u);
		post.put(v, clock);
		clock++;
	}

	/*
	 * Depth-First search
	 */
	public void depthFirstSearch(Graph<Vertex> g){
		visited = new HashMap<Vertex, Boolean>();
		pre = new HashMap<Vertex, Integer>();
		post = new HashMap<Vertex, Integer>();
		clock = 1;
		for(Vertex v : g.getVertices()){
			visited.put(v, false);
		}
		for(Vertex v: g.getVertices()){
			if (visited.get(v) == false){
				explore(g, v);
			}
		}
	}
	

	public void printDFSDataStructures(){
		for (Vertex v: visited.keySet())
			System.out.println("visited["+ v.getName() + "] = " + visited.get(v));
		for (Vertex v: pre.keySet())
			System.out.println("pre["+ v.getName() + "] = " + pre.get(v));
		for (Vertex v: post.keySet())
			System.out.println("post["+ v.getName() + "] = " + post.get(v));
	}
}
