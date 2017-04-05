public class MyLinkedList{
    
    private class LNode{
	private int value;
	private LNode next, prev;

	public LNode(int value){
	    this.value = value;
	}

	public String toString(){
	    return value + " ";
	}
    }
    
    private LNode head, tail;
    private int size;

    public MyLinkedList(){
	size = 0;
    }

    public String toString(){
	LNode node = head;
	String ans = "[";
	for(int i = 0; i < size; i++){
	    ans += node.value;
	    node = node.next;
	    if(i != size-1){
		ans += ", ";
	    }
	}
	return ans + "]";
    }

    //EXCEPTIONS!!! -- but could be wrapper using getNode
    public int get(int index){
	/*
	if(index < 0 || index >= size){
	    throw new IndexOutOfBoundsException();
	}
	LNode temp = head;
	for(int i = 0; i < index; i++){
	    temp = temp.next;
	}
	return temp.value;
	*/

	return getNode(index).value;
    }

    //EXCEPTIONS!!!
    public int set(int index, int newValue){
	/*
	if(index < 0 || index >= size){
	    throw new IndexOutOfBoundsException();
	}
	LNode temp = head;
	int old = get(index);
	
	for(int i = 0; i < index; i++){
	    temp = temp.next;
	}

	temp.value = newValue;
	return old;
	*/
	LNode swap = getNode(index);
	int old = swap.value;
	swap.value = newValue;
	return old;
    }
    
    public int indexOf(int value){
	LNode current = head;
	for(int i = 0; i < size; i++){
	    if(current.value == value){
		return i;
	    }
	    current = current.next;
	}
	return -1;
    }

    //EXCEPTION!!!
    private LNode getNode(int index){
	if(index < 0 || index >= size){
	    throw new IndexOutOfBoundsException();
	}
	LNode current = head;
	for(int i = 0; i < index; i++){
	    current = current.next;
	}
	return current.next;
    }

    private void remove(LNode node){
	if(node == tail){
	    node.prev.next = null;
	}else if(node == head){
	    node.next.prev = null;
	    head = node.next;
	}else{
	    node.prev.next = node.next;
	    node.next.prev = node.prev;
	}
    }

    private void addAfter(LNode location, LNode toBeAdded){
	if(location == tail){
	    location.next = toBeAdded;
	    toBeAdded.prev = location;
	}else{
	    toBeAdded.next = location.next;
	    toBeAdded.prev = location;
	    location.next.prev = toBeAdded;
	    location.next = toBeAdded;
	}
    }
    private void addBefore(LNode location, LNode toBeAdded){
	if(location == head){
	    toBeAdded.next = location;
	    location.prev = toBeAdded;
	}else{
	    toBeAdded.next = location;
	    toBeAdded.prev = location.prev;
	    location.prev.next = toBeAdded;
	    location.prev = toBeAdded;
	}
    }
    
    public int remove(int index){
	int rem = get(index);
	remove(getNode(index));
	return rem;
    }
    
    public void add(int index, int value){
	LNode add = new LNode(value);
	if(index == size - 1){
	    addAfter(getNode(index), add);
	}else{
	    addBefore(getNode(index),add);
	}
    }
    
    //EXCEPTIONS!!!
    public boolean add(int value){
	if(size == 0){
	    head = new LNode(value);
	    tail = head;
	}else{
	    add(size-1, value);
	}
	size++;
	return true;
    }

    public int size(){
	return size;
    }
    
    public static void main(String[] args){
	MyLinkedList a = new MyLinkedList();
	System.out.println(a);
	a.add(2);
	a.add(-4);
	a.add(100);
	a.set(1, 50);
	System.out.println(a);
    }
}
