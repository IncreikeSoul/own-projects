package EDA;

public interface IHashTable {

    public void clear();
    public boolean containsKey(Object key);
    public boolean containsValue(Object value);
    public Object get(Object key);
    public boolean isEmpty();
    public Object put(Object key, Object value);
    public void putAll(IHashTable t);
    public Object remove(Object key);
    public int size();
    public Iterator keyIterator();
    public Iterator valueIterator();
     
    
}
