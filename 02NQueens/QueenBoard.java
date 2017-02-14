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
    
    //find 1st solution and stops; updates toString board
    public boolean solve(){
	return solveH(0,0);
    }
    private boolean solveH(int row, int col){
	if(col >= board.length){
	    return true;
	}
	if(row >= board.length && col < 0){
	    return false;
	}else if(row >= board.length){
	    for(int i = 0; i < board.length; i++){
		if(board[i][col-1] < 0){
		    removeQueen(i,col-1);
		    return solveH(i+1,col);
		}
	    }
	}else if(board[row][col] == 0){
	    addQueen(row,col);
	    return solveH(0,col+1);
	}else{
	    return solveH(row+1,col);
	}
	return false;
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
		if(board[r][c] < 0){
		    ans+= "[Q]";
		}else{
		    //ans += "[" + board[r][c] + "]";
		    ans+= "[_]";
		}
	    }
	    ans += "\n";
	}
	return ans;
    }

    public static void main(String[]args){
	try{
	    QueenBoard input = new QueenBoard(Integer.parseInt(args[0]));
	    System.out.println(input.solve());
	    System.out.println(input);
	}
	catch(IndexOutOfBoundsException e){	    
	    QueenBoard a = new QueenBoard(5);
	    System.out.println(a.solve());
	    System.out.println(a);

	    QueenBoard b = new QueenBoard(10);
	    System.out.println(b.solve());
	    System.out.println(b);
	}
    }
}
