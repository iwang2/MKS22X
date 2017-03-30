import java.util.*;

public class Merge{
    public static void mergesort(int[] ary){
	if(ary.length > 1){
	    int split = ary.length / 2;
	    int[] left = Arrays.copyOfRange(ary, 0, split);
	    int[] right = Arrays.copyOfRange(ary, split, ary.length);

	    mergesort(left);
	    mergesort(right);
	    merge(left, right, ary);
	}
    }

    private static void merge(int[] a, int[] b, int[] end){
	int indexa = 0, indexb = 0;
	for(int i = 0; i < end.length; i++){
	    if(indexa < a.length && indexb < b.length){
		if(a[indexa] < b[indexb]){
		    end[i] = a[indexa];
		    indexa++;
		}else{
		    end[i] = b[indexb];
		    indexb++;
		}
	    }else{
		if(indexa < a.length){
		    end[i] = a[indexa];
		    indexa++;
		}else{
		    end[i] = b[indexb];
		    indexb++;
		}
	    }
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
	int[] a = {4, 5, 1, 7, 2, 3, 6, 0};
	mergesort(a);
	print(a);

	System.out.println();
	
	int[] b1 = new int[30];
	for(int i = 0; i < 30; i++){
	    b1[i] = (int)(Math.random() * 10);
	}
	print(b1);
	int[] b2 = b1;
	mergesort(b1);
	Arrays.sort(b2);
	System.out.println(compare(b1,b2));
	print(b1);
    }
}
