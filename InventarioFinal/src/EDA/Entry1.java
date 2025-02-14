package EDA;

public class Entry1 {
    private Object key;
    private Object value;
    private Entry1 next;
    
    public Entry1(Object key, Object value){
        this.key=key;
        this.value=value;
    }
    
    public Object getKey(){
        return HashTable1.unmaskNull(key) ; 
    }
    public Object getValue(){
        return value;
    }
    public Object setValue(Object newValue){
        Object oldValue=value;
        value=newValue;
        return oldValue;
    }
    public void setNext(Entry1 next){
        this.next=next;
    }
    public Entry1 getNext(){
        return next;
    }
    public String toString(){
        return getKey()+"="+getValue();
    }    
}