public class Quick{
    
    public static int part(int[] data, int start, int end){
	int index = (int)(Math.random() * (end-start)) + start;
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

    public static int quickSelect(int[] data, int k){
	int start = 0, end = data.length - 1;
	while(start < end){
	    int part = part(data, start, end);
	    if(part == k){
		return data[part];
	    }else
	    if(part > k){
		end = part-1;
	    }else if(part < k){
		start = part+1;
	    }/*else{
		System.out.println("index: " + part);
		return data[part];
	    }*/
	}
	return data[start];
    }

    public static void print(int[] ary){
	for(int i = 0; i < ary.length; i++){
	    System.out.print(ary[i] + " ");
	}
	System.out.println();
    }

    public static void main(String[]args){
	int[] ary = {3, 1, 3, 4, 3, 3, 3, 0};
	System.out.println(quickSelect(ary, 7));
	print(ary);
    }
}
