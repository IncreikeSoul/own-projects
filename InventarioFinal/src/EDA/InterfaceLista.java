package EDA;

public interface InterfaceLista {
    void add(int index,Object x);// añadir
    void remove(int index);//eliminar
    int indexOf(Object x);//retorna el indice
    Object get (int index);//retorna el elemendo de la ubicacion del indice
    void clear();//limpia la lista
    boolean isEmpty();//retorna v si es que la lista esta vacia
    int length();//retorn la longitud

}
