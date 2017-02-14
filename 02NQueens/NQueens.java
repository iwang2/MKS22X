public class NQueens{
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

    //find 1st solution and stop; updates toString board
    public void solve(){
	
    }

    //look for all solutions, updates solutionCount
    public void countSolutions(){
    }

    //returns number of solutions, or -1 if solver was never run
    public int getCount(){
	return solutionCount;
    }

    public String toString(){
	for(int r = 0; r < board.length; r++){
	    for (int c = 0; c < board[0].length; c++){
		System.out.print("[" + board[r][c] + "]");
	    }
	    System.out.println();
	}
    }
}
