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
        board[row][col] = -1;
	for(int c = col+1; c < board.length; c++){
	    board[row][c]++;
	}
	int tr = row-1;
	int tc = col+1;
	while(tr >= 0 && tc < board.length){
	    board[tr][tc]++;
	    tr--;
	    tc++;
	}
	int br = row+1;
	int bc = col+1;
	while(br < board.length && bc < board.length){
	    board[br][bc]++;
	    br++;
	    bc++;
	}
    }
    private void removeQueen(int row, int col){
	board[row][col] = 0;
	for(int c = col+1; c < board.length; c++){
	    board[row][c]--;
	}
	int tr = row-1;
	int tc = col+1;
	while(tr >= 0 && tc < board.length){
	    board[tr][tc]--;
	    tr--;
	    tc++;
	}
	int br = row+1;
	int bc = col+1;
	while(br < board.length && bc < board.length){
	    board[br][bc]--;
	    br++;
	    bc++;
	}
    }

    /*
    //find 1st solution and stop; updates toString board
    public void solve(){
	return solveH(0);
    }
    private boolean solveH(int col){
	for(int r = 0; r < board.length; r++){
	    if(board[r][col] < 1){
		addQueen(r,col);
		return solveH(col+1);
	    }
	}
    }
    */
    
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
		if(board[r][c] < 0){
		    ans+= "[Q]";
		}else{
		    ans += "[" + board[r][c] + "]";
		}
	    }
	    ans += "\n";
	}
	return ans;
    }

    public static void main(String[]args){
	QueenBoard a = new QueenBoard(5);
	a.addQueen(1,2);
	a.addQueen(3,1);
	System.out.println(a);
	a.removeQueen(1,2);
	System.out.println(a);
    }
}
