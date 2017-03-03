import java.util.Scanner;
import java.io.*;

public class Maze{
    private char[][] maze;
    private boolean animate;
    private int width, length;

    /*Constructor loads a maze text file, and sets animate to false by default.
      1. The file contains a rectangular ascii maze, made with the following 4 characters:
      '#' - locations that cannot be moved onto
      ' ' - locations that can be moved onto
      'E' - the location of the goal (exactly 1 per file)
      'S' - the location of the start(exactly 1 per file)

      2. The maze has a border of '#' around the edges. So you don't have to check for out of bounds!
      3. When the file is not found OR there is no E or S then: print an error and exit the program.
    */

    public Maze(String filename){
	int s = 0, e = 0;
	width = 0; length = 0;
	String str = "";
	try{
	    Scanner scan = new Scanner(new File(filename));
	    while(scan.hasNextLine()){
		str += scan.nextLine();
		length++;
	    }
	}catch(FileNotFoundException n){
	    System.out.println("Invalid filename.");
	    System.exit(1);
	}
	width = str.length() / length;
	maze = new char[length][width];
	for(int r = 0; r < length; r++){
	    String line = str.substring(width*r,width*r+width);
	    for(int c = 0; c < width; c++){
		maze[r][c] = line.charAt(c);
		if(maze[r][c] == 'S'){
		    s++;
		}
		if(maze[r][c] == 'E'){
		    e++;
		}
	    }
        }
	if(e != 1 || s != 1){
	    System.out.println("Invalid number of start and end points.");
	    System.exit(1);
	}
	animate = false;
    }

    private void wait(int millis){
	try{
	    Thread.sleep(millis);
	}catch(InterruptedException e){
	}
    }

    public void setAnimate(boolean b){
	animate = b;
    }

    public void clearTerminal(){
	System.out.println("\033[2J\033[1;1H");
    }

    /*Wrapper Solve Function
      Since the constructor exits when the file is not found or is missing an E or S, we can assume it exists.
    */
    public boolean solve(){
	int startr = -1, startc = -1;

	//Initialize starting row and startint col with the location of the S.
	maze[startr][startc] = ' ';//erase the S, and start solving!
	return solve(startr,startc);
    }
    
    /*Recursive Solve function:

      A solved maze has a path marked with '@' from S to E.

      Returns true when the maze is solved,
      Returns false when the maze has no solution.

      Postcondition:

        The S is replaced with '@' but the 'E' is not.

        All visited spots that were not part of the solution are changed to '.'
        All visited spots that are part of the solution are changed to '@'
    */
    private boolean solve(int row, int col){
        if(animate){
            System.out.println("\033[2J\033[1;1H"+this);
            wait(20);
        }

        //COMPLETE SOLVE
	
        return false; //so it compiles
    }
    public String toString(){
	String ans = "";
	for(int r = 0; r < length; r++){
	    for(int c = 0; c < width; c++){
		ans += maze[r][c];
	    }
	    if(r < length-1){
		ans += "\n";
	    }
	}
	return ans;
    }

    public static void main(String[]args){
	Maze a = new Maze("test.txt");
	System.out.println(a);///
    }
}
