import java.util.*;

public class MyHeap{
    
    private ArrayList<Integer> heap;
    private boolean b;
    private int tail;
    
    public MyHeap(){
	b = true;
	heap = new ArrayList<Integer>();
	heap.add(null);
	tail = 0;
    }

    //true - max heap, false - min heap
    public MyHeap(boolean b){
	this.b = b;
	heap = new ArrayList<Integer>();
	heap.add(null);
	tail = 0;
    }

    public void add(int s){
	heap.add(s);
	tail++;
	if(b){
	    upM(tail);
	}else{
	    upm(tail);
	}
    }

    public int remove(){
	int ans = heap.get(1);
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

    public int peek(){
	return heap.get(1);
    }
    
    private void upM(int index){
	if(index != 1 && heap.get(index / 2) < (heap.get(index))){
	    swap(index, index / 2);
	    upM(index / 2);
	}
    }

    private void upm(int index){
	if(index != 1 && heap.get(index / 2) > (heap.get(index))){
	    swap(index, index / 2);
	    upm(index / 2);
	}
    }
    
    private void downM(int index){
	if(index > tail / 2){
	    return;
	}else if(heap.get(index) < heap.get(index*2) &&
		 heap.get(index*2) > heap.get(index*2 + 1)){
	    swap(index, index*2);
	    downM(index*2);
	}else if(heap.get(index) < heap.get(index*2 + 1)){
	    swap(index, index*2 + 1);
	    downM(index*2 + 1);
	}
    }

    private void downm(int index){
	if(index > tail / 2){
	    return;
	}else if(heap.get(index) > heap.get(index*2) &&
		 heap.get(index*2) < heap.get(index*2 + 1)){
	    swap(index, index*2);
	    downm(index*2);
	}else if(heap.get(index) > heap.get(index*2 + 1)){
	    swap(index, index*2 + 1);
	    downm(index*2 + 1);
	}
    }

    private void swap(int in1, int in2){
	int hold = heap.get(in1);
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

	if(b){
	    System.out.print("max: ");
	}else{
	    System.out.print("min: ");
	}
	for(int i = 1; i <= tail; i++){
	    System.out.print(heap.get(i) + " ");
	}
	System.out.println();
    }

    public static void main(String[] args){
	MyHeap a = new MyHeap(false);
	a.add(4);
	a.add(3);
	a.add(8);
	a.add(1);
	a.add(5);
	a.add(6);
	a.add(0);
	a.add(7);
	a.print();
	a.remove();
	a.print();
    }
}
