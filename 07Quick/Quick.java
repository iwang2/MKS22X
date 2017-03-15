public class Quick{
    public static int part(int[] data, int start, int end){
	int index = (int)(Math.random() * (end-start)) + start;
	System.out.println(index);
	int part = data[index];
	int first = start;
	swap(data, start, index);
	start++;

	while(start < end){
	    if(data[start] >= part){
		swap(data, start, end);
		end--;
	    }else if(data[start] < part){
		start++;
	    }
	}
	
	if(data[start] >= part){
	    swap(data, start-1, first);
	    return start-1;
	}else{
	    swap(data, start, first);
	    return start;
	}
    }
    
    private static void swap(int[] data, int first, int last){
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
	int[] ary = {0, 0, 1, 5, 2, 2, 3, 0, 0};
	print(ary);
	System.out.println(part(ary, 2, 6));
	print(ary);
    }
}
