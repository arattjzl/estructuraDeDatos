package estructurasLineales;

public class ColaEstatica implements Lote{

    protected Object informacion[];
    protected int MAXIMO;
    protected int inicio;
    protected int fin;

    public int getMAXIMO() {
        return MAXIMO;
    }

    public void setMAXIMO(int MAXIMO) {
        this.MAXIMO = MAXIMO;
    }

    public int getInicio() {
        return inicio;
    }

    public void setInicio(int inicio) {
        this.inicio = inicio;
    }

    public int getFin() {
        return fin;
    }

    public void setFin(int fin) {
        this.fin = fin;
    }

    public ColaEstatica(int tamanio){
        MAXIMO = tamanio;
        informacion = new Object[tamanio];
        inicio = -1;
        fin = -1;
    }

    @Override
    public boolean lleno() {
        return (inicio == 0 && fin == (MAXIMO) - 1) || fin == inicio - 1;
    }

    @Override
    public boolean vacia() {
       return inicio == -1;
    }

    @Override
    public boolean poner(Object info) {
        if(!lleno()){
            if(vacia()){
                inicio = 0;
                fin = 0;
            } else if(fin == getMAXIMO()-1){
                fin = 0;
            } else {
                fin++;
            }
            informacion[fin] = info;
            return true;
        }
        return false;
    }

    @Override
    public Object quitar() {
        return null;
    }

    @Override
    public void imprimir() {

    }

    @Override
    public Object verTope() {
        return null;
    }
}
