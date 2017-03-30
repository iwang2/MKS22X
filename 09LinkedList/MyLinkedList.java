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
	    LNode temp = start;
	    start.value = value;
	    start.next = temp;
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
	    ans = node.value + " ";
	    node = node.next;
	}
	return ans.substring(0, ans.length() - 1) + "]";
    }

    //EXCEPTIONS!!!
    public int get(int index){
	LNode temp = start;
	for(int i = 0; i <= index; i++){
	    temp = temp.next;
	}
	return temp.value;
    }

    //EXCEPTIONS!!!
    public int set(int index, int newValue){
	LNode temp = start;
	int old = get(index);
	
	for(int i = 0; i <= index; i++){
	    temp = temp.next;
	}

	temp.value = newValue;
	return old;
    }

    public static void main(String[] args){
	MyLinkedList a = new MyLinkedList();
	a.add(2);
	a.add(-4);
	a.add(100);
	System.out.println(a);
    }
}
