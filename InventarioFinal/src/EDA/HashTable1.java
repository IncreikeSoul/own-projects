package EDA; 

public class HashTable1 implements IHashTable{
    private Entry1 table[];
    private int size;
    private final float loadFactor;
    private int threshold;

    private final int DEFAULT_INITIAL_CAPACITY=1024;
    private final float DEFAULT_LOAD_FACTOR=0.75f;

    public HashTable1 (){
        this.loadFactor=DEFAULT_LOAD_FACTOR;
        this.threshold=DEFAULT_INITIAL_CAPACITY;
        table=new Entry1[DEFAULT_INITIAL_CAPACITY];
    }

    public HashTable1 (int initialCapacity, float loadFactor){
        if(initialCapacity<0){
            throw new IllegalArgumentException("Illegal Initial Capacity: "+initialCapacity);
        }
        if(loadFactor<=0||loadFactor>1){
            throw new IllegalArgumentException("Illegal Load Factor: " +loadFactor);
        }
        int capacity=1;
        if(capacity<initialCapacity){
            capacity<<=1;
        }
        this.loadFactor=loadFactor;
        this.threshold=(int)(capacity*loadFactor);
        table=new Entry1[capacity];
    }

    public HashTable1 (int initialCapacity){
        this(initialCapacity, 0.75f);
    }

    public void clear() {
        Entry1 tab[]=table;
        for(int i=0;i<table.length;i++){
            tab[i]=null;
        }
        size=0;
    }

    public boolean containsKey(Object key) {
        Object k=maskNull(key);
        int i=hCode(k, table.length);
        Entry1 e=table[i];
        while(e!=null){
            if(eq(k, maskNull(e.getKey()))){
                return true;
            }
            e=e.getNext();
        }
        return false;
    }

    public boolean containsValue(Object value) {
        if(value==null){
            return containsNullValue();
        }
        Entry1 tab[]=table;
        for(int i=0;i<table.length;i++){
            for(Entry1 e=tab[i];e!=null;e=e.getNext()){
                if(value.equals(e.getValue())){
                    return true;
                }
            }
        }
        return false;
    }

    public Object get(Object key) {
       Object k = maskNull(key);
        int i = hCode(k, table.length);
        Entry1 e = table[i];
        while(true) {
            if(e == null) {
                return e;
            }
            if(eq(k, maskNull(e.getKey()))) {
                return e.getValue();
            }
            e = e.getNext();
        }
    }

    public boolean isEmpty() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Object put(Object key, Object value) {
         Object k = maskNull(key);
        int i = hCode(k, table.length);
        
        for(Entry1 e=table[i]; e!=null; e=e.getNext()) {
            if(eq(k, maskNull(e.getKey()))) {
                Object oldValue = e.getValue();
                e.setValue(value);
                return oldValue;
            }
        }
        
        addEntry(k, value, i);
        return null;

    }

    public void putAll(IHashTable t) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Object remove(Object key) {
       
        Entry1 e = removeEntryForKey(key);
        return (e == null ? e : e.getValue());

    }

    public int size() {
       return size;

    }
    ///////////////////////////////////////////
    public String toString() {
        StringBuffer sb = new StringBuffer();
        Entry1 tab[] = table;
        for(int i=0; i<tab.length; i++) {
            for(Entry1 e=tab[i]; e!=null; e=e.getNext()) {
                sb.append(e + " ");
            }
        }
        return sb.toString();

    }

    public static final Object NULL_KEY=new Object();

    public static Object maskNull(Object key){
        return (key==null?NULL_KEY:key);
    }

    public static Object unmaskNull(Object key){
        return (key==NULL_KEY?null:key);
    }

    public boolean containsNullValue(){
        Entry1 tab[]=table;
        for(int i=0;i<tab.length;i++){
            for(Entry1 e=tab[i];e!=null;e=e.getNext()){
                if(e.getValue()==null){
                    return true;
                }
            }
        }
        return false;
    }
    ///////////////////////////////////
    private int hCode(Object k, int capacity){
        return maskNull(k).hashCode()&(capacity-1);
    }

    private static boolean eq(Object x, Object y){
        return x==y||x.equals(y);
    }

    private void addEntry(Object key, Object value, int index){
        Entry1 newEntry1=new Entry1(key, value);
        newEntry1.setNext(table[index]);
        table[index]=newEntry1;
        if(size++>=threshold){
            resize(2*table.length);
        }
    }

    private void resize(int newCapacity){
        Entry1 oldTable[]=table;
        int oldCapacity=oldTable.length;
        if(size<threshold||oldCapacity>newCapacity){
            return;
        }
        Entry1 newTable[]=new Entry1[newCapacity];
        transfer(newTable);
        table=newTable;
        threshold=(int)(newCapacity*loadFactor);
    }

    private void transfer(Entry1 newTable[]){
        Entry1 src[]=table;
        int newCapacity=src.length;
        for(int i=0;i<src.length;i++){
            Entry1 e=src[i];
            if(e!=null){
                src[i]=null;
                do{
                    Entry1 next=e.getNext();
                    int j=hCode(e.getKey(), newCapacity);
                    e.setNext(newTable[j]);
                    newTable[j]=e;
                    e=next;
                }
                while(e!=null);
            }
        }
    }

    private Entry1 removeEntryForKey(Object key){
        Object k=maskNull(key);
        int i=hCode(k, table.length);
        Entry1 previous=null;
        for(Entry1 e=table[i];e!=null;e=e.getNext()){
            if(eq(k, maskNull(e.getKey()))){
                if(e==table[i]){
                    table[i]=e.getNext();
                }
                else{
                    previous.setNext(e.getNext());
                }
                size--;
                return e;
            }
            previous=e;
        }
        return null;
    }
    private Iterator keyIterator;
    public Iterator keyIterator(){
        if(keyIterator!= null){
            keyIterator.reset();
            return keyIterator;
        }
        else{
            return keyIterator=new Iterator(){
                private int i; 
                private Entry1 next;
                private Entry1 previous;
                {
                    reset();
                }
                public boolean hasNext(){
                    return next!=null;
                }
                public Object next(){
                    previous = next;
                    if(next==null){
                        return next;
                    }
                    Object key = next.getKey();
                    updateNext();
                    return key;                
                }
                public void remove(){
                    
                }
                public void reset(){
                    next=null;
                    for(i=0;i<table.length;i++){
                        next=table[i];
                        if(next!= null){
                            break;
                        }
                    }
                }
                 void updateNext(){
                    if(next.getNext()!=null){
                        next= next.getNext();
                    }
                    else{
                        while(++i<table.length){
                            next=table[i];
                            if(next!= null){
                                break;
                            }
                        }
                    }
                 }
                        
            };
        }
    }

    private Iterator valueIterator;
    public Iterator valueIterator() {
        if(valueIterator!= null){
            valueIterator.reset();
            return valueIterator;
        }
        else{
            return valueIterator=new Iterator(){
                private int i; 
                private Entry1 next;
                private Entry1 previous;
                {
                    reset();
                }
                public boolean hasNext(){
                    return next!=null;
                }
                public Object next(){
                    previous = next;
                    if(next==null){
                        return next;
                    }
                    Object value = next.getValue();
                    updateNext();
                    return value;                
                }
                public void remove(){
                    
                }
                public void reset(){
                    next=null;
                    for(i=0;i<table.length;i++){
                        next=table[i];
                        if(next!= null){
                            break;
                        }
                    }
                }
                 void updateNext(){
                    if(next.getNext()!=null){
                        next= next.getNext();
                    }
                    else{
                        while(++i<table.length){
                            next=table[i];
                            if(next!= null){
                                break;
                            }
                        }
                    }
                 }
                        
            };
        }
    }
}
    
 