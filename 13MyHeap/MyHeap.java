public class MyHeap{
    
    private ArrayList<String> heap;
    private boolean b;
    private int tail;
    
    public MyHeap(){
	b = true;
	heap = new ArrayList<String>();
	heap.add("");
	tail = 1;
    }

    //true - max heap, false - min heap
    public MyHeap(boolean b){
	this.b = b;
	heap = new ArrayList<String>();
	heap.add("");
    }

    public void add(String s){
	heap.add(s);
	tail++;
	up(tail);
    }

    public String remove(){
	heap.remove(tail);
	tail--;
    }

    public String peek(){
	return heap.get(tail);
    }

    //max --> min
    private void up(int index){
	if(index != 1 || heap.get(index / 2).compareTo(heap.get(index)) < 0){
	    swap(index, index / 2);
	    up(index / 2);
	}
    }

    private void down(){
    }
}
