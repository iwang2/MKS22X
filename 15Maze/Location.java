public class Location implements Comparable<Location>{
    private int row, col;
    private int distToGoal, distToStart;
    private Location previous;
    private boolean aStar;

    public Location(int r, int c, Location previous,
		    int distToStart, int distToGoal, boolean aStar){
	row = r;
	col = c;
	this.previous = previous;
	this.distToStart = distToStart;
	this.distToGoal = distToGoal;
	this.aStar = aStar;
    }

    public Location(int distToGoal){
	this.distToGoal = distToGoal;
	aStar = false;
    }    

    public int compareTo(Location other){
	if(aStar){
	    return distToGoal + distToStart -
		other.distToGoal - other.distToStart;
	}else{
	    return distToGoal - other.distToGoal;
	}
    }

    public int getDG(){
	return distToGoal;
    }
}
