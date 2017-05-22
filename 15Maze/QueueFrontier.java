public class QueueFrontier{
    private Queue<Location> q;

    public void add(Location l){
	q.add(l);
    }
    
    public Location next(){
	return q.remove();
    }
}
