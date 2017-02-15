public class KnightBoard{
    private int[][] board;
    private boolean solved;
    private int size;
    
    private int[][] direction = new int[8][2];
    
    public KnightBoard(int row, int col){
	board = new int[row][col];
	size = row * col;
	solved = false;
	
	direction[0][0] = 1; direction[0][1] = 2;
	direction[1][0] = 1; direction[1][1] = -2;
	direction[2][0] = -1; direction[2][1] = 2;
	direction[3][0] = -1; direction[3][1] = -2;
	direction[4][0] = 2; direction[4][1] = 1;
	direction[5][0] = 2; direction[5][1] = -1;
	direction[6][0] = -2; direction[6][1] = 1;
	direction[7][0] = -2; direction[7][1] = -1;
    }

    public void solve(){
	for(int r = 0; r < board.length; r++){
	    for( int c = 0; c < board[0].length; c++){
		if(solveH(r,c,1)){
		    return;
		}
	    }
	}
    }
    private boolean solveH(int row, int col, int level){
	if(level >= size){
	    solved = true;
	    return true;
	}else if(board[row][col] == 0){
	    board[row][col] = level + 1;
	    for(int i = 0; i < 8; i++){
		int r = row + direction[i][0];
		int c = col + direction[i][1];
		if(r >= 0 && r < board.length &&
		   c >= 0 && c < board[0].length &&
		   solveH(r, c, level + 1)){
		    return true;
		}
	    }
	    board[row][col] = 0;	    
	}
	return false;
    }

    //blank if never called or no solution
    public String toString(){
	String ans = "";
	if(solved){
	    for(int r = 0; r < board.length; r++){
		for(int c = 0; c < board[0].length; c++){
		    if(board[r][c] < 10){
			ans += " " + board[r][c] + " ";
		    }else{
			ans += board[r][c] + " ";
		    }
		}
		ans += "\n";
	    }
	}
	return ans;
    }

    public static void main(String[]args){
	KnightBoard a = new KnightBoard(4,4);
	a.solve();
	System.out.println(a);
    }
}
