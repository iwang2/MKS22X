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
	return solveH(0);
    }
    private boolean solveH(int col){
	if(col >= board.length){
	    return true;
	}
        for(int r = 0; r < board.length; r++){
	    if(board[r][col] == 0){
		addQueen(r,col);
	        if(solveH(col+1)){
		    return true;
		}else{
		    removeQueen(r,col);
		}
	    }
	}
	return false;
    }
        
    //look for all solutions, updates solutionCount
    public void countSolutions(){
        counter(0);
	solutionCount++;
    }
    private boolean counter(int col){
	if(col >= board.length){
	    solutionCount++;
	    return true;
	}
	for(int r = 0; r < board.length; r++){
	    if(board[r][col] == 0){
		addQueen(r,col);
	        counter(col+1);
		removeQueen(r,col);
	    }
	}
	return false;
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
	    int input = Integer.parseInt(args[0]);
	    QueenBoard a = new QueenBoard(input);
	    //System.out.println(a.solve());
	    //System.out.println(a);
	    a.countSolutions();
	    System.out.println(a.getCount());
	}
	catch(IndexOutOfBoundsException e){
	    QueenBoard a;
	    for(int i = 0; i < 11; i++){
		a = new QueenBoard(i);
		a.countSolutions();
		System.out.println(i + ": " + a.getCount());
	    }
	}
    }
}
