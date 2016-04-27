import java.util.Comparator;

public class DijkstraVertex extends Vertex implements Comparable<DijkstraVertex>  {
	
	private double myDistance;
	private Vertex myParent;
	
	public DijkstraVertex(String name,double distance,Vertex parent){
		super(name);
		myDistance = distance;
		myParent = parent;
	}
	
	public double getDistance(){
		return myDistance;
	}
	
	public Vertex getParent(){
		return myParent;
	}

	@Override
	public int compareTo(DijkstraVertex o) {
		if(this.myDistance<o.myDistance){
			return -1;
		}else if (this.myDistance>o.myDistance){
			return 1;
		}else{
			return 0;
		}
	}
}
