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
	if(msize == 0 && Msize == 0){
	    min.add(in);
	}else if(){
	}
    }

    public double getMedian(){
    }
}
