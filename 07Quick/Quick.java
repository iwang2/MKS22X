public class Quick{
    public static int part(int[] data, int start, int end){
	int index = (int)(Math.random() * (end-start)) + start;
	int part = data[index];
	
	data[index] = data[start];
	data[start] = part;
	int hold = start;

	boolean parted = false;

        while(!parted){
	    if(start > end){
		parted = true;
	    }else if(data[start] > part){
	        swap(data, start, end);
		end--;
	    }else if(data[start] <= part){
		start++;
	    }
	}
	return -1;
    }

    public static void swap(int[] data, int first, int last){
	int swap = data[first];
	data[first] = data[last];
	data[last] = swap;
    }

    public static void print(int[] ary){
	for(int i = 0; i < ary.length; i++){
	    System.out.print(ary[i] + " ");
	}
	System.out.println();
    }

    public static void main(String[]args){
	int[] ary = {2, 10, 15, 23, 0, 5};
	print(ary);
	System.out.println(part(ary, 1, 4));
	print(ary);
    }
}
