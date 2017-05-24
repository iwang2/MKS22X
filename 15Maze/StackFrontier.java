import java.util.*;

public class StackFrontier implements Frontier{
    private Stack<Location> s;

    public void add(Location l){
	s.push(l);
    }

    public Location next(){
	return s.pop();
    }

    public boolean hasNext(){
	return !s.empty();
    }
}
