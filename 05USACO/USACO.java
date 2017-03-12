import java.util.Scanner;
import java.io.*;

public class USACO{

    public static int bronze(String file){
	Scanner scan = new Scanner("");
	try{
	    scan = new Scanner(new File(file));
	}catch(FileNotFoundException f){
	    System.out.println("Invalid filename.");
	    System.exit(1);
	}

	int length = scan.nextInt();
	int width = scan.nextInt();
	int elevation = scan.nextInt();
	int stomps = scan.nextInt();
	int[][] lake = new int[length][width];

	//fill int[][] with lake values
	for(int r = 0; r < length; r++){
	    for(int c = 0; c < width; c++){
		lake[r][c] = scan.nextInt();
	    }
	}

	//follow stomp digging instructions 
	for(int i = 0; i < stomps; i++){
	    int row = scan.nextInt() - 1;
	    int col = scan.nextInt() - 1;
	    int level = scan.nextInt();
	    
	    int max = 0;
	    for(int r = 0; r < 3; r++){
		for(int c = 0; c < 3; c++){		    
		    if(lake[row+r][col+c] > max){
			max = lake[row+r][col+c];
		    }
		}
	    }	    
	    int limit = max - level;
	    for(int r = 0; r < 3; r++){
		for(int c = 0; c < 3; c++){
		    if(lake[row+r][col+c] > limit){
			lake[row+r][col+c] = limit;
		    }
		}
	    }
	}
	//calculate aggregated depth
	int sum = 0;
	for(int r = 0; r < length; r++){
	    for(int c = 0; c < width; c++){
		if(lake[r][c] < elevation){
		    sum += (elevation - lake[r][c]);
		}
	    }
	}
	//conversion
	return sum * 72 * 72;
    }

    public static void print(int[][] ar){
	for(int r = 0 ; r < ar.length; r++){
	    for(int c = 0; c < ar[0].length; c++){
		System.out.print(ar[r][c] + " ");
	    }
	    System.out.println();
	}
    }

    public static void main(String[]args){
	try{
	    for(int i = 1; i < 11; i++){
		System.out.print("test " + i + ": ");		
		Scanner scan = new Scanner(new File("makelake." + i + ".out"));
		System.out.println(bronze("makelake." + i + ".in") == scan.nextInt());
	    }
	}catch(FileNotFoundException e){}
    }
}
