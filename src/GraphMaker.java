/**
 * @author davidhan
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.swing.JFileChooser;

public class GraphMaker {
/**
 * @param selectedFile - the file selected
 * @param nameVertices - hashMap that will hash names of vertices to the actual Vertex object
 * @param graph - the graph that will be built
 * @param idVertices - hashMap that assists in building the graph by using index values to interpet the 
 * matrix of values on the file
 */
	private File selectedFile;
	private Map<String, Vertex> nameVertices;
	private AdjListGraph graph;
	private Map<Integer, String> idVertices;

	/**
	 * Prompts the user to choose a file from the window.
	 * @return File
	 * @throws FileNotFoundException
	 */
	public File promptFile() throws FileNotFoundException {
		JFileChooser chooser = new JFileChooser();
		boolean valid = false;
		while (!valid) {// or valid == false. valid checks for boolean true.
						// !valid checks for boolean that is false.
			try {
				if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
					selectedFile = chooser.getSelectedFile();
					valid = true;
				}
			} catch (Exception exception) {
				String message = "Why???";
			}
		}
		return selectedFile;
	}
/**
 * Prompts the user for specific file name.
 * @return
 */
	public File promptUserFile() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the file name");
		String filename = scan.nextLine().trim();
		File dummyFile = new File(filename);
		selectedFile = new File(dummyFile.getAbsolutePath());
		return selectedFile;
	}
/**
 * Stores all names of vertices into nameVertices and idVertices.
 * @param vertices
 */
	public void storeVertices(String vertices) {
		Scanner in2 = new Scanner(vertices);
		int idNum = 1;
		nameVertices = new HashMap<String, Vertex>();
		idVertices = new HashMap<Integer, String>();
		while (in2.hasNext()) {
			String name = in2.next();
			nameVertices.put(name, graph.addVertex(new Vertex(name)));
			idVertices.put(idNum, name);
			idNum++;
		}
	}
/**
 * Constrcuts edges to two vertices.
 * @param value - edgeWeight
 * @param counter1 - index value representing row
 * @param counter2 - index value representing column 
 */
	public void addEdges(double value, int counter1, int counter2) {
		if (value != 0) {
			String nameVertex1 = idVertices.get(counter1);
			String nameVertex2 = idVertices.get(counter2);
			graph.addEdge(nameVertices.get(nameVertex1), nameVertices.get(nameVertex2), value);
		}
	}
/**
 * Constructs the actual graph.
 * @return graph
 * @throws FileNotFoundException
 */
	public Graph<Vertex> getFileGraph() throws FileNotFoundException {
		graph = new AdjListGraph(Graph.DIRECTED);
		Scanner in = new Scanner(selectedFile);
		int dimension = Integer.parseInt(in.nextLine());
		String vertices = in.nextLine();// all of the cities
		this.storeVertices(vertices);
		int counter1 = 1;
		while (in.hasNextLine()) {
			int counter2 = 1;
			String theLine = in.nextLine();// going through the lines that
											// actually have numbers now
			Scanner scLine = new Scanner(theLine);
			String nameNotNeeded = scLine.next();// title first
			while (scLine.hasNext()) {
				double value = Double.parseDouble(scLine.next());
				if (value != 0) {
					this.addEdges(value, counter1, counter2);
				}
				counter2++;
			}
			counter1++;
		}
		return graph;
	}
/**
 * Returns the nameVertices variable.
 * @return
 */
	public Map getNameVertices() {
		return nameVertices;
	}

}
