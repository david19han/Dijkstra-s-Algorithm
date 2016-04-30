/**
 * @author davidhan
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

import javax.swing.JFileChooser;

public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		Dijkstra algorithm = new Dijkstra(new GraphMaker());
		algorithm.runAlgorithm();
	}

}
