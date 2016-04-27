public class GraphBuilder {
	
	public Graph<Vertex> getDefaultGraph(){
		AdjListGraph graph = 
				new AdjListGraph (Graph.UNDIRECTED);
			
			Vertex a = graph.addVertex(new Vertex("A"));
			Vertex b = graph.addVertex(new Vertex("B"));
			Vertex c = graph.addVertex(new Vertex("C"));
			Vertex d = graph.addVertex(new Vertex("D"));
			Vertex e = graph.addVertex(new Vertex("E"));
			Vertex f = graph.addVertex(new Vertex("F"));
			Vertex g = graph.addVertex(new Vertex("G"));
			Vertex h = graph.addVertex(new Vertex("H"));
			Vertex i = graph.addVertex(new Vertex("I"));
			Vertex j = graph.addVertex(new Vertex("J"));
			Vertex k = graph.addVertex(new Vertex("K"));
			Vertex l = graph.addVertex(new Vertex("L"));
			
			graph.addEdge(a, b);
			graph.addEdge(a, c);
			graph.addEdge(a, d);
			graph.addEdge(b, e);
			graph.addEdge(b, f);
			graph.addEdge(c, f);
			graph.addEdge(d, g);
			graph.addEdge(d, h);
			graph.addEdge(e, i);
			graph.addEdge(e, j);
			graph.addEdge(g, h);
			graph.addEdge(i, j);
			graph.addEdge(k, l);
			
			return graph;
	}
}
