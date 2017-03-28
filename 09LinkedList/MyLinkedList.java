public class MyLinkedList{    
    private class LNode{
	private int value;
	private LNode next;

	public LNode(int value, LNode next){
	    this.value = value;
	    this.next = next;
	}
    }
    
    private LNode start;
    private int size;

    public MyLinkedList(){
	size = 0;
	start = new LNode(null, null);
    }
    
    //EXCEPTIONS!!!
    public boolean add(int value){
	LNode temp = start;
	for(int i = 0; i < size; i++){
	    temp = temp.next;
	}
	temp.value = value;
	size++;
	return true;
    }

    public int size(){
	return size;
    }

    public String toString(){
	LNode node = start;
	System.out.print("[");
	for(int i = 0; i < size; i++){
	    System.out.print(node.value + " ");
	    node = node.next;
	}
    }

    //EXCEPTIONS!!!
    public int get(int index){
    }

    //EXCEPTIONS!!!
    public int set(int index, int newValue){
    }
}
