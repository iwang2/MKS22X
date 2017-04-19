import java.util.*;

public class MyLinkedList implements Iterable<Integer>{

    //INNER CLASSES~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
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

    public class MyLinkedListIterator implements Iterator<Integer>{
	private MyLinkedList it;
	private LNode current;

	public MyLinkedListIterator(MyLinkedList it){
	    current = it.head;
	    this.it = it;
	}
	
	public boolean hasNext(){
	    return it.tail != current;
	}
	
	public Integer next(){
	    if(hasNext()){
		current = current.next;
		return current.prev.value;
	    }else{
		throw new NoSuchElementException();
	    }
	}
	
	public void remove(){
	}
    }
    
    public Iterator<Integer> iterator(){
	return new MyLinkedListIterator(this);
    }

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    
    private LNode head, tail;
    private int size;

    public MyLinkedList(){
	size = 0;
    }

    //PRIVATE HELPER METHODS~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    
    private LNode getNode(int index){
	if(index < 0 || index >= size){
	    throw new IndexOutOfBoundsException();
	}
	LNode current = head;
	for(int i = 0; i < index; i++){
	    current = current.next;
	}
	return current;
    }
    
    //addAfter and remove currently do not account for special cases
    private void addAfter(LNode location, LNode toBeAdded){
	// if size is 1
	if(location == tail && head == tail){
	    tail = toBeAdded;
	    head.next = tail;
	    tail.prev = head;
	}//if adding to the end
	else if(location == tail){
	    LNode hold = tail;
	    tail = toBeAdded;
	    hold.next = tail;
	    tail.prev = hold;
	}//all other cases
	else{
	    toBeAdded.next = location.next;
	    toBeAdded.prev = location;
	    location.next.prev = toBeAdded;
	    location.next = toBeAdded;
	}
	size++;
    }

    private void remove(LNode target){
	// if size is 1
	if(target == tail && tail == head){
	    head = null;
	    tail = null;
	}//if removing tail
	else if(target == tail){
	    tail.prev.next = null;
	    tail = tail.prev;
	}//if removing head
	else if(target == head){
	    head.next.prev = null;
	    head = head.next;
	}//all other cases
	else{
	    target.next.prev = target.prev;
	    target.prev.next = target.next;
	}
	size--;
    }
    
    //REQUIRED PUBLIC METHODS~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    public int size(){
	return size;
    }

    public String toString(){
	LNode node = head;
	String ans = "";
	for(int i = 0; i < size; i++){
	    ans += node.toString();
	    node = node.next;
	}
	return "[" + ans.trim() + "]";
    }

    //adds to the end
    public boolean add(int value){
	LNode toAdd = new LNode(value);
	if(size == 0){
	    head = toAdd;
	    tail = head;
	    size++;
	}else{
	    addAfter(tail, toAdd);
	}
	return true;
    }

    public int get(int index){
	return getNode(index).value;
    }

    public int set(int index, int value){
	int previous = getNode(index).value;
	getNode(index).value = value;
	return previous;
    }

    public int indexOf(int value){
	for(int i = 0; i < size; i++){
	    if(get(i) == value){
		return i;
	    }
	}
	return -1;
    }

    public int remove(int index){
	int hold = getNode(index).value;
	remove(getNode(index));
	return hold;
    }

    public void add(int index, int value){
	LNode toAdd = new LNode(value);
	if(index == 0 && size == 0){
	    add(value);
	}else if(index == 0){
	    LNode hold = head;
	    head = toAdd;
	    head.next = hold;
	    hold.prev = head;
	    size++;
	}else{
	    addAfter(getNode(index-1), toAdd);
	}
    }

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    
    public static void main(String[] args){
	MyLinkedList a = new MyLinkedList();
	a.add(2);
	a.add(-4);
	a.add(100);
	a.add(3,50);
	System.out.println(a);
	System.out.println(a.tail.prev);

	Iterator<Integer> it = a.iterator();
        while(it.hasNext()){
	    System.out.println(it.next());
	}
    }
}
