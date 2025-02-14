package EDA;

public class NodoN {

    private Object elemento;
    NodoN hijo;
    NodoN hermano;

    public NodoN(Object elemento){
        setElemento(elemento);
    }

    public void setElemento(Object elemento){
        this.elemento=elemento;
    }

    public Object getElemento(){
        return elemento;
    }

    public void setHijo(NodoN hijo){
        this.hijo=hijo;
    }

    public NodoN getHijo(){
        return hijo;
    }

    public void setHermano(NodoN hermano){
        this.hermano=hermano;
    }

    public NodoN getHermano(){
        return hermano;
    }

    public String toString(){
        return elemento+" ";
    }

}
