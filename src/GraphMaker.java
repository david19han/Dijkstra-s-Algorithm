import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.swing.JFileChooser;

public class GraphMaker{

	private File selectedFile;
	private Map<Integer, Vertex> nameVertices;
	
	public File promptFile() throws FileNotFoundException{
		JFileChooser chooser = new JFileChooser();
	    boolean valid = false;
	    while (!valid) {// or valid == false. valid checks for boolean true. !valid checks for boolean that is false.
	      try {
	        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
	           selectedFile = chooser.getSelectedFile();
	          valid = true;
	        }
	      }catch (Exception exception) {   
	          String message = "Why???";
	        }
	    }
		return selectedFile;
	}
	
	public Graph<Vertex> getFileGraph() throws FileNotFoundException{
		AdjListGraph graph = new AdjListGraph (Graph.UNDIRECTED);
		
		Scanner in = new Scanner(selectedFile);
		int dimension = Integer.parseInt(in.nextLine());
		String vertices = in.nextLine();//all of the cities
		
		Scanner in2 = new Scanner(vertices);
		int idNum = 1;
		nameVertices = new HashMap<Integer, Vertex>();//giving an id number to each vertex
		while(in2.hasNext()){
			String name = in2.next();
			nameVertices.put(idNum, graph.addVertex(new Vertex(name)));
			idNum++;
		}
		
		//double [][] weights = new double [dimension][dimension];
		int counter1 = 1;
		
		while(in.hasNextLine()){
			int counter2 = 1;
			String theLine = in.nextLine();
			
			Scanner scLine = new Scanner(theLine);
			String nameNotNeeded = scLine.next();
			while(scLine.hasNext()){
				double value = Double.parseDouble(scLine.next());
				//weights[counter1][counter2] = value;
				if(value!=0){
					graph.addEdge(nameVertices.get(counter1), nameVertices.get(counter2), value);
				}
				counter2++;
			}
			counter1++;
		}
		//nameVertices.put(_,_) nameVertices.get()			
		return graph;
	}
	
	public Map getNameVertices(){
		return nameVertices;
	}
	
	
	
	
}
