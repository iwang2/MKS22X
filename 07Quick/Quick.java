public class Quick{
    
    public static int part(int[] data, int start, int end){
	int index = (int)(Math.random() * (end-start)) + start;
	int part = data[index];
	int first = start;
	swap(data, start, index);
	start++;
	int equal = start;

	while(equal <= end){
	    if(data[equal] == part){
		equal++;
	    }else if(data[equal] < part){
		swap(data, start, equal);
		start++;
		equal++;
	    }else if(data[equal] > part){
		swap(data, equal, end);
		end--;
	    }
	}
	swap(data, first, end);
	return end;
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
	System.out.println(quickSelect(ary, 4));
	print(ary);
    }
}
