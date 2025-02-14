package EDA;

public class Nodo {
  private Object elemento;
  private Nodo sig;
  public Nodo(Object elemento){setElemento(elemento);}
  public void setElemento(Object elemento){this.elemento=elemento;}
  public Object getElemento(){return elemento;}
  public void setSig(Nodo sig){this.sig=sig;}
  public Nodo getSig(){return sig;}
  public String toString(){return elemento+"";}
}