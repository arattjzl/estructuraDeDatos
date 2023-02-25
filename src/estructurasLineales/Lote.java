package estructurasLineales;

public interface Lote {
    public boolean lleno();
    public boolean vacia();
    public boolean poner(Object info);
    public Object quitar();
    public void imprimir();
    public Object verTope();

}