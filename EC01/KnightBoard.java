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
	    board[row][col] = level;
	    int[][] arr = arr(row,col);
	    int r;
	    int c;
	    for(int i = arr.length-1; i >= 0; i--){
	        r = row + direction[arr[i][0]][0];
		c = col + direction[arr[i][0]][1];
		
		if(r >= 0 && r < wide && c >= 0 && c < tall &&
		   faster(r,c,level+1)){
		    return true;
		}
		else{
		}
	    }
	}
	return false;
    }

    public int[][] arr(int row, int col){
	int[] values = new int[8];
	int asize = 0;
	
	for(int i = 0; i < 8; i++){
	    int r = row + direction[i][0];
	    int c = col + direction[i][1];

	    if(r >= 0 && r < wide && c >= 0 && c < tall && less[r][c] > 0){
		values[i] = less[r][c];
		less[r][c]--;
		less[row][col] = 0;
		asize++;
	    }
	}
	
	int[][] val = new int[asize][2];
	for(int a = 0; a < asize; a++){
	    int max = 0;
	    for(int l = 0; l < 8; l++){
		if(values[l] > max){
		    max = values[l];
		    val[a][0] = l;
		}
	    }
	    values[val[a][0]] = 0;
	    val[a][1] = max;
	}
	return val;
    }

    public void revertless(int row, int col){
	int self = 0;
	for(int i = 0; i < 8; i++){
	    int r = row + direction[i][0];
	    int c = col + direction[i][1];
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
    public static void print2(int[][] ar){
	String ans = "";
	for(int r = 0; r < ar.length; r++){
	    for(int c = 0; c < ar[0].length; c++){
		ans += ar[r][c] + " ";
	    }
	    ans += "\n";
	}
	System.out.println(ans);
    }
    public static void print1(int[] ar){
	String ans = "";
	for(int r = 0; r < ar.length; r++){
	    ans += ar[r] + " ";
	}
	System.out.println(ans);
    }

    public static void main(String[]args){
	if(args.length == 2){
	    KnightBoard a = new KnightBoard(Integer.parseInt(args[0]),
					    Integer.parseInt(args[1]));
	    
	    System.out.println(a.toString2());
	    int[][] b = a.arr(Integer.parseInt(args[0])-2,Integer.parseInt(args[1])-2);
	    System.out.println(a.toString2());
	    a.solveFast();
	    System.out.println(a.solved);
	    System.out.println(a);
	}
    }
}
