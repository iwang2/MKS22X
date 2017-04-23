import java.util.*;

public class MyDeque{
    private String[] ar;
    private int front, back, size;

    public MyDeque(){
	ar = new String[6];
	size = 0;
    }

    public void addFirst(String s){
	if(size == ar.length){
	    resize();
	}
	if(s == null){
	    throw new NullPointerException();
	}
	
	if(size == 0){
	    front = 0;
	    back = 0;
	}else if(front == 0){
	    front = ar.length - 1;
	}else{
	    front--;
	}
	ar[front] = s;
	size++;
    }
    
    public void addLast(String s){
	if(size == ar.length){
	    resize();
	}
	if(s == null){
	    throw new NullPointerException();
	}
	
	if(size == 0){
	    front = 0;
	    back = 0;
	}else if(back == ar.length - 1){
	    back = 0;
	}else{
	    back++;
	}
	ar[back] = s;
	size++;
    }

    public String removeFirst(){
	if(size == 0){
	    throw new NoSuchElementException();
	}
	String ans = ar[front];
	ar[front] = null;
	if(front == ar.length - 1){
	    front = 0;
	}else{
	    front++;
	}
	size--;
	return ans;
    }

    public String removeLast(){
	if(size == 0){
	    throw new NoSuchElementException();
	}
	String ans = ar[back];
	ar[back] = null;
	if(back == 0){
	    back = ar.length - 1;
	}else{
	    back--;
	}
	size--;
	return ans;
    }

    public String getFirst(){
	return ar[front];
    }

    public String getLast(){
	return ar[back];	
    }

    private void resize(){
	String[] old = ar;
	ar = new String[ar.length * 2];
	if(back > front){
	    for(int i = front; i <= back; i++){
		ar[i - front] = old[i];
	    }
	}else{
	    int index = 0;
	    for(int i = front; i < size; i++){
		ar[index] = old[i];
		index++;
	    }
	    for(int i = back; i < front; i++){
		ar[index] = old[i];
		index++;
	    }
	}
	front = 0;
	back = size - 1;
    }

    private void print(){
	for(int i = 0; i < ar.length; i++){
	    if(ar[i] == null){
		System.out.print("_ ");
	    }
	    else{
		System.out.print(ar[i] + " ");
	    }
	}
	System.out.println();
    }
    
    public static void main(String[] args){
	MyDeque a = new MyDeque();
	a.print();
	a.addLast("c");
	a.print();
	a.addFirst("b");
	a.print();
	a.addLast("d");
	a.print();
	a.addFirst("a");
	a.print();
	a.removeLast();
	a.print();
	a.removeFirst();
	a.print();
    }
}
