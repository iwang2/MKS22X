public class MyHeap{
    
    private ArrayList<String> heap;
    private boolean b;
    private int head, tail;
    
    public MyHeap(){
	b = true;
	heap = new ArrayList<String>();
	head = 1;
	tail = 1;
    }

    //true - max heap, false - min heap
    public MyHeap(boolean b){
	this.b = b;
	heap = new ArrayList<String>();
    }

    public void add(String s){
    }

    public String remove(){
    }

    public String peek(){
    }

    private void up(){
	int tail = heap.get(heap.size() - 1);
    }

    private void down(){
    }
}
