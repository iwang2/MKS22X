public class KnightBoard{
    private int[][] board;
    private int[][] less;
    private boolean solved;
    private int size;
    private int wide;
    private int tall;
    
    private int[][] direction = new int[8][2];
    
    public KnightBoard(int width, int length){
	wide = width;
	tall = length;
	size = wide * tall;
	
	board = new int[wide][tall];
	less = new int[wide][tall];
	solved = false;
	
	direction[0][0] = 1; direction[0][1] = 2;
	direction[1][0] = 1; direction[1][1] = -2;
	direction[2][0] = -1; direction[2][1] = 2;
	direction[3][0] = -1; direction[3][1] = -2;
	direction[4][0] = 2; direction[4][1] = 1;
	direction[5][0] = 2; direction[5][1] = -1;
	direction[6][0] = -2; direction[6][1] = 1;
	direction[7][0] = -2; direction[7][1] = -1;

	for(int r = 0; r < wide; r++){
	    for(int c = 0; c < tall; c++){
		int pos = 0; 
		for(int i = 0; i < 8; i++){
		    int newr = r + direction[i][0];
		    int newc = c + direction[i][1];
		    if(newr >= 0 && newr < wide &&
		       newc >= 0 && newc < tall){
			pos++;
		    }
		}
		less[r][c] = pos;
	    }
	}
    }

    public void solve(){
	int row = wide / 2 + wide % 2;
	int col = tall / 2 + tall % 2;
	for(int r = 0; r < row; r++){
	    for( int c = r; c < col; c++){
		if(solveH(r,c,1)){
		    solved = true;
		    return;
		}
	    }
	}
    }
    
    private boolean solveH(int row, int col, int level){
	if(level > size){
	    return true;
	}
	else if(board[row][col] == 0){
	    board[row][col] = level;

	    for(int i = 0; i < 8; i++){
		int r = row + direction[i][0];
		int c = col + direction[i][1];

		if((wide == 1 && tall == 1) ||
		   (r >= 0 && r < wide && c >= 0 && c < tall
		    && solveH(r,c,level+1))){
		    return true;
		}
	    }
	    board[row][col] = 0;	    
	}
	return false;
    }

    public void solveFast(){
	int row = wide / 2 + wide % 2;
	int col = tall / 2 + tall % 2;
	for(int r = 0; r < row; r++){
	    for(int c = r; c < col; c++){
		if(faster(r,c,1)){
		    solved = true;
		    return;
		}
	    }
	}
    }
    public boolean faster(int row, int col, int level){
	if(level > size){
	    return true;
	}
	else if(board[row][col] == 0){
	}
	return false;
    }
    public int[][] arr(int row, int col){
	int options = 0;
	for(int i = 0; i < 8; i++){
	    int r = row + direction[i][0];
	    int c = row + direction[i][1];

	    if(r >= 0 && r < wide && c >= 0 && c < tall){
		options++;
	    }
	}
    }
    
    //blank if never called or no solution
    public String toString(){
	String ans = "";
	if(solved){
	    for(int r = 0; r < wide; r++){
		for(int c = 0; c < tall; c++){
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
    public String toString2(){
	String ans = "";
	for(int r = 0; r < wide; r++){
	    for(int c = 0; c < tall; c++){
		ans += less[r][c] + " ";
	    }
	    ans += "\n";
	}
	return ans;
    }

    public static void main(String[]args){
	if(args.length == 2){
	    KnightBoard a = new KnightBoard(Integer.parseInt(args[0]),
					    Integer.parseInt(args[1]));
	    
	    System.out.println(a.toString2());
	    a.solve();
	    System.out.println(a);
	}
    }
}
