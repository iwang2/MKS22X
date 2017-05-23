public class FrontierPriorityQueue implements Frontier{
    private MyPriorityQueue pq;
    
    public void add(Location l){
	pq.add(l);
    }
    
    public Location next(){
	return pq.remove();
    }

    public boolean hasNext(){
	return !pq.empty();
    }
}
