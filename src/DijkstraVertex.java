/**
 * @author davidhan
 */
import java.util.Comparator;

public class DijkstraVertex extends Vertex implements Comparable<DijkstraVertex> {
	/**
	 * @param myDistance
	 *            - the distance from the startVertex to this vertex
	 * @param myParent
	 *            - the parent node, which is the node before this node on the
	 *            shortest path.
	 */
	private double myDistance;
	private Vertex myParent;

	/**
	 * Constructor for Dijkstra Vertex
	 * 
	 * @param name
	 *            - name of this vertex
	 * @param distance
	 *            - distance of this vertex from the startVertex
	 * @param parent
	 *            - the parent node, which is the node before this node on the
	 *            shortest path.
	 */
	public DijkstraVertex(String name, double distance, Vertex parent) {
		super(name);
		myDistance = distance;
		myParent = parent;
	}

	public double getDistance() {
		return myDistance;
	}

	public Vertex getParent() {
		return myParent;
	}

	/**
	 * Compare method that will dictate the natural order when multiple
	 * DijkstraVertices are in a priority queue
	 */
	@Override
	public int compareTo(DijkstraVertex o) {
		if (this.getDistance() < o.getDistance()) {
			return -1;
		} else if (this.getDistance() > o.getDistance()) {
			return 1;
		} else {
			return 0;
		}
	}

}
