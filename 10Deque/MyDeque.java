public class MyDeque{
    private String[] ar;
    private int front, back, size;

    public MyDeque(){
	ar = new String[6];
	front = 0;
	back = ;
	size = 0;
    }

    public void addFirst(String s){
	if(size == 0){
	    front = 0;
	    back = 0;
	}else if(front == 0){
	    front = size - 1;
	}else{
	    front--;
	}
	ar[front] = s;
	size++;
    }
    
    public void addLast(String s){
	if(size == 0){
	    front = 0;
	    back = 0;
	}else if(back == size - 1){
	    back = 0;
	}else{
	    back++;
	}
	ar[back] = s;
	size++;
    }

    public String removeFirst(){
    }

    public String removeLast(){
    }

    public String getFirst(){
    }

    public String getLast(){
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
	    }
	}
	front = 0;
	back = size - 1;
    }
}
