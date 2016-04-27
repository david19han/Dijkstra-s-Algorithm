import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

import javax.swing.JFileChooser;

public class Main {
	public static void main(String[] args) throws FileNotFoundException {		
		GraphMaker maker = new GraphMaker();
		File theFile = maker.promptFile();
		maker.getFileGraph().print();
		/*
		Scanner in = new Scanner(theFile);
		
		while(in.hasNextLine()){
			System.out.println(in.nextLine());
		}
		*/
		
		
		/*
		Graph<Vertex> graph = new GraphBuilder().getDefaultGraph();
		DepthFirstSearcher searcher = new DepthFirstSearcher();	
		
		//searcher.depthFirstSearch(graph);
		//searcher.printDFSDataStructures();
		//searcher.explore(graph, graph.getVertices().iterator().next());
		
		for(Vertex v:graph.getVertices()){
			if(v.getName().equals("A")){
				searcher.explore(graph, v);
			}
			searcher.printDFSDataStructures();
		}
		*/
	}
	
}
