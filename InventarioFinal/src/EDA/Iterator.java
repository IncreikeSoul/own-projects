package EDA;

abstract 
public interface Iterator {
    public boolean hasNext();
    public Object next();
    public void remove();
    public void reset();
}
