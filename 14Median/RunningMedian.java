public class RunningMedian{
    private MyHeap min, max;
    private int msize, Msize;
    private boolean debug;

    public RunningMedian(){
	min = new MyHeap(false);
	max = new MyHeap();
	
        msize = 0;
	Msize = 0;
	
	debug = false;
    }

    public void add(int in){
	if(msize == 0 || Msize == 0){
	    if(msize == Msize){
		min.add(in);
		msize++;
	    }else if(in < min.peek()){
		max.add(in);
		Msize++;
	    }else{
		min.add(in);
		msize++;
		balance();
	    }
	}else if(in > getMedian()){
	    min.add(in);
	    msize++;
	    balance();
	}else{
	    max.add(in);
	    Msize++;
	    balance();
	}
    }

    private void balance(){
	if(msize > Msize){
	    max.add(min.remove());
	    Msize++;
	    msize--;
	}else if(Msize > msize){
	    min.add(max.remove());
	    msize++;
	    Msize--;
	}
    }

    public double getMedian(){
	if(msize > Msize){
	    return min.peek();
	}else if(msize < Msize){
	    return max.peek();
	}else{
	    return (min.peek() + max.peek()) / 2.0;
	}
    }

    public static void main(String[] args){
	RunningMedian a = new RunningMedian();
	a.add(4);
	a.min.print();
	a.max.print();
	System.out.println("median: " + a.getMedian());
	
	a.add(5);
	a.min.print();
	a.max.print();
	System.out.println("median: " + a.getMedian());

	a.add(1);
	a.min.print();
	a.max.print();
	System.out.println("median: " + a.getMedian());

	a.add(0);
	a.min.print();
	a.max.print();
	System.out.println("median: " + a.getMedian());

	a.add(2);
	a.min.print();
	a.max.print();
	System.out.println("median: " + a.getMedian());

	a.add(3);
	a.min.print();
	a.max.print();
	System.out.println("median: " + a.getMedian());
    }
}
