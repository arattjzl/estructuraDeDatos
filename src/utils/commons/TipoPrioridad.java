package utils.commons;

public enum TipoPrioridad {
    MAYOR_MENOR(1),
    MENOR_MAYOR(2);
    private int prioridad;
    private TipoPrioridad(int prioridad){
        this.prioridad = prioridad;
    }

    public int getPrioridad(){
        return prioridad;
    }
}
