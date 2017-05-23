public interface Frontier{
    void add(Location l);
    Location next();
    boolean hasNext();
}
