import java.util.Comparator;

public class DijkstraVertexComparator implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		DijkstraVertex v1 = (DijkstraVertex) o1;
		DijkstraVertex v2 = (DijkstraVertex) o2;
		
		if(v1.getDistance()<v2.getDistance()){
			return -1;
		}else if (v1.getDistance()>v2.getDistance()){
			return 1;
		}else{
			return 0;
		}
	}
	

}
