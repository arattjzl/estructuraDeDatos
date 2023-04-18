package estructurasLineales.auxiliares;

public class NodoClave {

    protected Object clave;
    protected Object valor;
    protected NodoClave ligaDer;

    public NodoClave(Object clave, Object valor){
        this.clave = clave;
        this.valor = valor;
    }

    public Object getClave() {
        return clave;
    }

    public void setClave(Object clave) {
        this.clave = clave;
    }

    public Object getValor() {
        return valor;
    }

    public void setValor(Object valor) {
        this.valor = valor;
    }

    public NodoClave getLigaDer() {
        return ligaDer;
    }

    public void setLigaDer(NodoClave ligaDer) {
        this.ligaDer = ligaDer;
    }
}
