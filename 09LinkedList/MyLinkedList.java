import java.util.*;

public class MyLinkedList implements Iterable<Integer>{
    
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
    
    private LNode head, tail;
    private int size;
    private boolean testing;

    public MyLinkedList(){
	testing = false;
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
	return current;
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
	size++;
    }
    private void addBefore(LNode location, LNode toBeAdded){
	if(location == head){
	    LNode old = location;	    
	    head = toBeAdded;
	    head.next = old;
	    old.prev = head;
	}else{
	    toBeAdded.next = location;
	    toBeAdded.prev = location.prev;
	    location.prev.next = toBeAdded;
	    location.prev = toBeAdded;
	}
	size++;
    }
    
    public int remove(int index){
	int rem = get(index);
	remove(getNode(index));
	return rem;
    }
    
    public void add(int index, int value){
	LNode node = new LNode(value);
	if(index == size){
	    add(value);
	}else{
	    addBefore(getNode(index), node);
	}
    }
    
    //EXCEPTIONS!!!
    public boolean add(int value){
	if(size == 0){
	    head = new LNode(value);
	    tail = head;
	}else{
	    LNode follow = new LNode(value);
	    tail.next = follow;
	    tail = follow;
	}
	size++;
	if(testing) System.out.println(this);
	return true;
    }

    public int size(){
	return size;
    }

    public Iterator<Integer> iterator(){
	return new MyLinkedListIterator(this);
    }
    
    public static void main(String[] args){
	MyLinkedList a = new MyLinkedList();
	//a.testing = true;
	a.add(2);
	a.add(-4);
	a.add(100);
	//System.out.println(size);
	a.add(1, 50);
	//System.out.println(size);
	System.out.println(a);
    }
}
