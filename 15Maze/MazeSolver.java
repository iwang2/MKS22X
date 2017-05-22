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
	if(style == 0){
	    StackFrontier f = new StackFrontier();
	    f.add(maze.getStart());
	}else if(style == 1){
	    QueueFrontier f = new QueueFrontier();
	    f.add(maze.getStart())
	}else if(style == 2){
	    FrontierPriorityQueue f = new FrontierPriorityQueue();
	    f.add(maze.getStart());
	}else if(style == 3){
	    FrontierPriorityQueue f = new FrontierPriorityQueue();
	    //how do i set astar to true...
	}
    }

    public String toString(){
	return maze;
    }
}
