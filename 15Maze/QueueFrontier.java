public class QueueFrontier implements Frontier{
    private Queue<Location> q;

    public void add(Location l){
	q.add(l);
    }
    
    public Location next(){
	return q.remove();
    }

    public boolean hasNext(){
	return q.peek() != null;
    }
}
