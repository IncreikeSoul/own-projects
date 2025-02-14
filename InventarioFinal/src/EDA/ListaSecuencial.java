package EDA;

public class ListaSecuencial implements InterfaceLista{
    
private Nodo Lista;
private int size;

public ListaSecuencial(){
    size=0;
}

@Override
public void add (int index, Object x){
    
    if(index<0||index>size){
        throw new IllegalArgumentException("add: index<0|index>size");
        }
    Nodo nuevo=new Nodo(x);//crea nodo
    
    if(isEmpty()){//si la lista esta vacia
        Lista=nuevo;
        
    }else if(index==0){//se inserta al inicio
        nuevo.setSig(Lista);
        Lista=nuevo;
       
    }else if(index==size){//se inserta al finall                       
       nodo(size-1).setSig(nuevo);
        
    }else{
        Nodo actual=nodo(index-1);//se inserta al medio
        nuevo.setSig(actual.getSig());
        actual.setSig(nuevo);
        
    }
    size++;
             
    }

@Override
public void remove(int index){
    
    if(index<0 || index>(size-1)){
        throw new IllegalArgumentException("remove: index<0 || index>(size-1)");
    }
    if(index==0){
        Lista=Lista.getSig();
    }else if(index==(size-1)){
        nodo(size-2).setSig(null);
    }else{
        Nodo anterior=nodo(index-1);
        anterior.setSig(anterior.getSig().getSig());
    }
    size--;
    
}

@Override
public int indexOf(Object x){
    int i;
    Nodo actual=Lista;
    for(i=0;actual!=null && i<size;actual=actual.getSig(),i++){                                        
        if(x.toString().equals(actual.toString())){
            break;
        }
    }
    return i==size?-1:i;  
}

@Override
public Object get(int index){
    if(index<0||index>(size-1)){
        throw new IllegalArgumentException("get: index<0||index>(size-1)");
    }
    return nodo(index).getElemento();
}

@Override
public void clear(){
    Lista=null;
    size=0;
}

@Override
public boolean isEmpty(){
    return size==0;
    
}


public int length(){
    return size;
}

public String toString(){
    StringBuffer  sb= new StringBuffer(); 
    sb.append('[');
    boolean wb=false;
    for(Nodo actual=Lista; actual!=null; actual=actual.getSig()){
    if(wb!=false){
        sb.append("," +actual);
    }else{
        sb.append(actual+ "");
        wb=true;
    }
    }
    sb.append(']');   
    return sb.toString();
}

private Nodo nodo(int index){
    if(index<0 ||index>=size){
        throw new IllegalArgumentException("nodo:index<0||index>=size");
    }
    Nodo actual=Lista;
    for(int i=0;i<index;i++){
        actual=actual.getSig();
    }
    return actual;
    
}
public String ObtenerNombre(){
    return Lista.toString();
}
}