public class KnightBoard{
    private int[][] board;
    private boolean solved;
    private int size;
    
    private int[][] direction = new int[8][2];
    
    public KnightBoard(int row, int col){
	board = new int[row][col];
	size = row * col;
	
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
    }
    private boolean solveH(int row, int col, int level){
	if(level >= size){
	    return true;
	}
	return false;
    }

    //blank if never called or no solution
    public String toString(){
    }
}
