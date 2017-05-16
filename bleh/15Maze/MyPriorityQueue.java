import java.util.*;

public class MyPriorityQueue{

    private ArrayList<Location> pq;
    private int tail;
    
    public MyPriorityQueue(){
	pq = new ArrayList<Location>();
	pq.add(null);
	tail = 0;
    }

    public void add(Location l){
	pq.add(l);
	up(tail);
    }

    public Location remove(){
	Location ans = pq.get(1);
	pq.set(1, pq.get(tail));
	pq.remove(tail);
	tail--;
	down(1);
	return ans;
    }

    public Location peek(){
	return pq.get(1);
    }

    // MODIFY FOR COMPARISON BETWEEN LOCATIONS
    private void up(int index){
	if(index != 1 && pq.get(index / 2).compareTo(pq.get(index)) > 0){
	    swap(index, index / 2);
	    up(index / 2);
	}
    }

    private void down(int index){
	if(index > tail / 2){
	    return;
	}
	else if(pq.get(index).compareTo(pq.get(index*2)) < 0 &&
		pq.get(index*2).compareTo(pq.get(index*2 + 1)) < 0){
	    swap(index, index*2);
	    down(index*2);
	}
	else if(pq.get(index).compareTo(pq.get(index*2 + 1)) > 0){
	    swap(index, index*2 + 1);
	    down(index*2 + 1);
	}
    }

    private void swap(int in1, int in2){
	Location hold = pq.get(1);
	pq.set(in1, pq.get(in2));
	pq.set(in2, hold);
    }
}
