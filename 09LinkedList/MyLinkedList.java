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
	start = null;
    }
    
    //EXCEPTIONS!!!
    public boolean add(int value){
	if(size == 0){
	    start = new LNode(value, null);
	}else{
	    LNode temp = new LNode(value, null);
	    LNode current = start;
	    for(int i = 1; i < size; i++){
		current = current.next;
	    }
	    current.next = temp;
	}
	/*
	for(int i = 0; i < size; i++){
	    temp = temp.next;
	}
	temp.value = value;
	*/
	size++;
	return true;	
    }

    public int size(){
	return size;
    }

    public String toString(){
	LNode node = start;
	String ans = "";
	System.out.print("[");
	for(int i = 0; i < size; i++){
	    ans += node.value;
	    node = node.next;
	    if(i != size-1){
		ans += ", ";
	    }
	}
	return ans + "]";
    }

    //EXCEPTIONS!!!
    public int get(int index){
	if(index < 0 || index >= size){
	    throw new IndexOutOfBoundsException();
	}
	LNode temp = start;
	for(int i = 0; i < index; i++){
	    temp = temp.next;
	}
	return temp.value;
    }

    //EXCEPTIONS!!!
    public int set(int index, int newValue){
	if(index < 0 || index >= size){
	    throw new IndexOutOfBoundsException();
	}
	LNode temp = start;
	int old = get(index);
	
	for(int i = 0; i < index; i++){
	    temp = temp.next;
	}

	temp.value = newValue;
	return old;
    }
    
    public int indexOf(int value){
	LNode current = start;
	for(int i = 0; i < size; i++){
	    if(current.value == value){
		return i;
	    }
	    current = current.next;
	}
	return -1;
    }

    public void add(int index, int value){
	LNode current = start;
	for(int i = 0; i < index; i++){
	    current = current.next;
	}
	LNode hold = current.next.next;
	current.next = new LNode(value, hold);
    }

    /*
    public int remove(int index){
    }
    */
    
    public static void main(String[] args){
	MyLinkedList a = new MyLinkedList();
	System.out.println(a);
	a.add(2);
	a.add(-4);
	a.add(100);
	a.add(1, 5);
	System.out.println(a);
    }
}
