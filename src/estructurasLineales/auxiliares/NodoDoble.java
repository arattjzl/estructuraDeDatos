package estructurasLineales.auxiliares;

public class NodoDoble {
    protected NodoDoble apuntadorAIzquierda;
    protected NodoDoble apuntadorADerecha;
    protected Object info;

    public NodoDoble(Object info) {
        this.info = info;
        apuntadorADerecha = null;
        apuntadorAIzquierda = null;
    }

    public NodoDoble getApuntadorAIzquierda() {
        return apuntadorAIzquierda;
    }

    public void setApuntadorAIzquierda(NodoDoble apuntadorAIzquierda) {
        this.apuntadorAIzquierda = apuntadorAIzquierda;
    }

    public NodoDoble getApuntadorADerecha() {
        return apuntadorADerecha;
    }

    public void setApuntadorADerecha(NodoDoble apuntadorADerecha) {
        this.apuntadorADerecha = apuntadorADerecha;
    }

    public Object getInfo() {
        return info;
    }

    public void setInfo(Object info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return info.toString();
    }
}
