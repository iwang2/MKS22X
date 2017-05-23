public class MazeSolver{
    private Maze maze;

    public MazeSolver(String file){
	this(file, false);
    }

    public MazeSolver(String file, boolean animate){
	maze = new Maze(file, animate);
    }

    public void solve(){
	solve(1);
    }

    // 0 - dfs, 1 - bfs, 2 - best first, 3 - a-star,
    public void solve(int style){
	Frontier f;
	Location start = maze.getStart();
	if(style == 0){
	    f = new StackFrontier();
	    f.add(start);
	}else if(style == 1){
	    f = new QueueFrontier();
	    f.add(maze.getStart())
	}else if(style == 2){
	    f = new FrontierPriorityQueue();
	    f.add(start);
	}else if(style == 3){
	    f = new FrontierPriorityQueue();
	    start.setaStar(true);
	    f.add(start);
	    //how do i set astar to true...
	}
	while(f.hasNext()){
	}
    }

    private boolean valid(

    public String toString(){
	return maze;
    }
}
