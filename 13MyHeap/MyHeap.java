import java.util.*;

public class MyHeap{
    
    private ArrayList<String> heap;
    private boolean b;
    private int tail;
    
    public MyHeap(){
	b = true;
	heap = new ArrayList<String>();
	heap.add("");
	tail = 0;
    }

    //true - max heap, false - min heap
    public MyHeap(boolean b){
	this.b = b;
	heap = new ArrayList<String>();
	heap.add("");
	tail = 0;
    }

    public void add(String s){
	heap.add(s);
	tail++;
	if(b){
	    upM(tail);
	}else{
	    upm(tail);
	}
    }

    public String remove(){
	String ans = heap.get(1);
	heap.set(1, heap.get(tail));
	heap.remove(tail);
	tail--;
	if(b){
	    downM(1);
	}else{
	    downm(1);
	}
	return ans;
    }

    public String peek(){
	return heap.get(tail);
    }
    
    private void upM(int index){
	if(index != 1 && heap.get(index / 2).compareTo(heap.get(index)) < 0){
	    swap(index, index / 2);
	    upM(index / 2);
	}
    }

    private void upm(int index){
	if(index != 1 && heap.get(index / 2).compareTo(heap.get(index)) > 0){
	    swap(index, index / 2);
	    upm(index / 2);
	}
    }
    
    private void downM(int index){
	if(index > tail / 2){
	    return;
	}else if(heap.get(index).compareTo(heap.get(index*2)) < 0 &&
		 heap.get(index*2).compareTo(heap.get(index*2 + 1)) > 0){
	    swap(index, index*2);
	    downM(index*2);
	}else if(heap.get(index).compareTo(heap.get(index*2 + 1)) < 0){
	    swap(index, index*2 + 1);
	    downM(index*2 + 1);
	}
    }

    private void downm(int index){
	if(index > tail / 2){
	    return;
	}else if(heap.get(index).compareTo(heap.get(index*2)) > 0 &&
		 heap.get(index*2).compareTo(heap.get(index*2 + 1)) < 0){
	    swap(index, index*2);
	    downm(index*2);
	}else if(index*2 < tail && heap.get(index).compareTo(heap.get(index*2 + 1)) > 0){
	    swap(index, index*2 + 1);
	    downm(index*2 + 1);
	}
    }

    private void swap(int in1, int in2){
	String hold = heap.get(in1);
	heap.set(in1, heap.get(in2));
	heap.set(in2, hold);
    }

    public void print(){
	/*
	for(int i = 1; i < tail; i *= 2){
	    for(int j = i; j < i*2; j++){
		System.out.println(i*2);
		//System.out.print(heap.get(j) + " ");
	    }
	    //System.out.println();
	}
	*/

	for(int i = 1; i <= tail; i++){
	    System.out.print(heap.get(i) + " ");
	}
	System.out.println();
    }

    public static void main(String[] args){
	MyHeap a = new MyHeap(false);
	a.add("b");
	a.add("d");
	a.add("a");
	a.add("e");
	a.add("c");
	a.add("f");
	a.print();
	a.remove();
	a.print();
	a.remove();
	a.print();
    }
}
