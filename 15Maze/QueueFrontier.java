import java.util.*;

public class QueueFrontier implements Frontier{
    private LinkedList<Location> q;

    public QueueFrontier(){
	q = new LinkedList<Location>();
    }

    public void add(Location l){
	q.add(l);
    }
    
    public Location next(){
	return q.removeFirst();
    }

    public boolean hasNext(){
	return q.peekFirst() != null;
    }
}
