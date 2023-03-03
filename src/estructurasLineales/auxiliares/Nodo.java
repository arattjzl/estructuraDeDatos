package estructurasLineales.auxiliares;

public class Nodo {
    protected Object info;
    protected Nodo apuntadorOtroNodo;

    public Nodo(Object info){
        this.info = info;
        apuntadorOtroNodo = null;
    }

    public Nodo(){
        info = null;
        apuntadorOtroNodo = null;
    }

    public Object getInfo() {
        return info;
    }

    public void setInfo(Object info) {
        this.info = info;
    }

    public Nodo getApuntadorOtroNodo() {
        return apuntadorOtroNodo;
    }

    public void setApuntadorOtroNodo(Nodo apuntadorOtroNodo) {
        this.apuntadorOtroNodo = apuntadorOtroNodo;
    }

    @Override
    public String toString() {
        return info.toString();
    }
}
