import java.util.Scanner;
import java.io.*;

public class USACO{
    private int width, length, elevation;
    private int[][] lake;
    private int[][] stomps;

    public USACO(String file){
	scan(file);
    }
    
    private void scan(String file){
	try{
	    Scanner scan = new Scanner(new File(file));
	    length = Integer.parseInt(scan.next());
	    width = Integer.parseInt(scan.next());
	    elevation = Integer.parseInt(scan.next());
	    stomps = new int[Integer.parseInt(scan.next())][3];
	    lake = new int[length][width];

	    for(int r = 0; r < length; r++){
		for(int c = 0; c < width; c++){
		    lake[r][c] = Integer.parseInt(scan.next());
		}
	    }

	    for(int r = 0; r < stomps.length; r++){
		for(int c = 0; c < 3; c++){
		    stomps[r][c] = Integer.parseInt(scan.next());
		}
	    }
	}
	catch(FileNotFoundException f){
	    System.out.println("Invalid filename");
	    System.exit(1);
	}
    }

    public void printLake(){
	for(int r = 0; r < length; r++){
	    for(int c = 0; c < width; c++){
		System.out.print(lake[r][c] + " ");
	    }
	    if(r < length-1){
		System.out.println();
	    }
	}
    }

    public void printStomps(){
	for(int r = 0; r < stomps.length; r++){
	    for(int c = 0; c < 3; c++){
		System.out.print(stomps[r][c] + " ");
	    }
	    if(r < 2){
		System.out.println();
	    }
	}
    }
    
    public static void main(String[]args){
	USACO a = new USACO("makelake.txt");
	a.printLake();
	System.out.println();
	a.printStomps();
    }
}
