import java.util.Arrays;

public class Quick{
    
    public static int[] part(int[] data, int start, int end){
	int index = (int)(Math.random() * (end-start)) + start,
	    part = data[index],
	    first = start;
	
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
	int[] ans = {start, end};
	return ans;
    }

    private static void swap(int[] data, int first, int last){
	int swap = data[first];
	data[first] = data[last];
	data[last] = swap;
    }
    
    public static int quickSelect(int[] data, int k){
	k--;
	int start = 0, end = data.length - 1;
	while(start < end){
	    int[] part = part(data, start, end);
	    if(part[1] > k){
		end = part[1] - 1;
	    }else if(part[0] < k){
		start = part[0] + 1;
	    }else{
		return data[part[0]];
	    }
	}
	return data[start];
    }

    public static void quickSort(int[] data){
	sortH(data, 0, data.length -1 );
    }
    
    public static void sortH(int[] data, int start, int end){
	//print(data);	
	if(end-start > 1){
	    int[] part = part(data, start, end);
	    sortH(data, start, part[0] - 1);
	    sortH(data, part[1] + 1, end);
	}
    }

    public static void print(int[] ary){
	for(int i = 0; i < ary.length; i++){
	    System.out.print(ary[i] + " ");
	}
	System.out.println();
    }

    public static boolean compare(int[] a, int[] b){
	for(int i = 0; i < a.length; i++){
	    if(a[i] != b[i]){
		return false;
	    }
	}
	return true;
    }

    public static void main(String[]args){
	/*
	int[] ary = {3, 1, 3, 4, 3, 3, 3, 0};
	//System.out.println(quickSelect(ary, 1));
	quickSort(ary);
	print(ary);

	int[] a = {6, 3, 4, 0, 2, 1, 5};
	quickSort(a);
	print(a);
	*/

	int[] b1 = new int[1000000];
	for(int i = 0; i < 1000000; i++){
	    b1[i] = (int)(Math.random() * 50);
	}
	int[] b2 = b1;
	Arrays.sort(b1);
	quickSort(b2);
	System.out.println(compare(b1,b2));
	
    }
}
