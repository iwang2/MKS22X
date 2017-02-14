public class QueenBoard{
    private int[][] board;
    private int solutionCount = -1;

    public QueenBoard(int size){
	board = new int[size][size];
	for(int r = 0; r < size; r++){
	    for(int c = 0; c < size; c++){
		board[r][c] = 0;
	    }
	}
    }

    private void addQueen(int row, int col){
	int num = col+1;
        board[row][col] = -1;
	for(int r = 0; r < board.length; r++){
	    board[r][col] = num;
	}
	for(int c = 0; c < board.length; c++){
	    board[row][c] = num;
	}
	num--;
	for(int t = row; t >= 0; t--){
	    for(int c = num; c < 
    }
    private void removeQueen(int row, int col){
	board[row][col] = col;
	for(int r = 0; r < board.length; r++){
	    for(int c = 0; c < board.length; c++){
		if(board[r][c] == col+1){
		    board[r][c] = col;
		}
	    }
	}
    }
    
    //find 1st solution and stop; updates toString board
    public void solve(int row, int col){
	
    }

    //look for all solutions, updates solutionCount
    public void countSolutions(){
    }

    //returns number of solutions, or -1 if solver was never run
    public int getCount(){
	return solutionCount;
    }

    public String toString(){
	String ans = "";
	for(int r = 0; r < board.length; r++){
	    for (int c = 0; c < board.length; c++){
		ans += "[" + board[r][c] + "]";
	    }
	    ans += "\n";
	}
	return ans;
    }

    public static void main(String[]args){
	QueenBoard a = new QueenBoard(5);
	a.addQueen(2,2);
	System.out.println(a);
	a.removeQueen(2,2);
	System.out.println(a);
    }
}
