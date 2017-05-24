public class MazeSolver{
    private Maze maze;
    private int[][] alternate;
    private boolean animate;

    public MazeSolver(String file){
	this(file, false);
    }

    public MazeSolver(String file, boolean animate){
	maze = new Maze(file);
	alternate = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
	animate = false;
    }

    public void solve(){
	solve(1);
    }

    // 0 - dfs, 1 - bfs, 2 - best first, 3 - a-star,
    public void solve(int style){
	Frontier f = new StackFrontier();
	boolean aStar = false;
	Location start = maze.getStart();
	int sr = start.getCo()[0];
	int sc = start.getCo()[1];
	
	Location end = maze.getEnd();
	int er = end.getCo()[0];
	int ec = end.getCo()[1];
	
	if(style == 0){
	    f.add(start);
	}else if(style == 1){
	    f = new QueueFrontier();
	    f.add(maze.getStart());
	}else if(style == 2){
	    f = new FrontierPriorityQueue();
	    f.add(start);
	}else if(style == 3){
	    f = new FrontierPriorityQueue();
	    aStar = true;
	    f.add(start);
	}
	while(f.hasNext()){
	    Location next = f.next();
	    int r = next.getCo()[0];
	    int c = next.getCo()[1];
	    if(maze.get(r,c) == 'E'){
		while(next.getPrev() != start){
		    int rp = next.getPrev().getCo()[0];
		    int cp = next.getPrev().getCo()[1];
		    maze.set(rp, cp, '@');
		}
		return;
	    }
	    if(animate) System.out.println(this);
	    maze.set(r, c, '.');
	    for(int i = 0; i < 4; i++){
		int addR = alternate[i][0];
		int addC = alternate[i][1];
		if(isValid(r + addR, c + addC)){
		    maze.set(r + addR, c + addC, '?');
		    f.add(new Location(r + addR, c + addC, next,
				       Math.abs(r+addR - sr) + Math.abs(c+addC - sc),
				       Math.abs(r+addR - er) + Math.abs(c+addC - ec),
				       aStar));
		    if(animate) System.out.println(this);
		}
	    }
	}	
    }

    private boolean isValid(int r, int c){
	return r < maze.getHeight()-1 && r > 0
	    && c < maze.getWidth()-1 && c > 0
	    && maze.get(r,c) == ' ';
    }
    
    public String toString(){
	return maze.toString(50);
    }

    public static void main(String[] args){
	if(args.length == 2){
	    String s = args[0];
	    MazeSolver a = new MazeSolver(s);
	    a.animate = true;
	    System.out.println(a);
	    a.solve(Integer.parseInt(args[1]));
	}
    }
}
