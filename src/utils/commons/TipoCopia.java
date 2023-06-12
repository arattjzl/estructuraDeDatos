package utils.commons;

public enum TipoCopia {
    PRINCIPIO(1),
    FINAL(2);
    private int copia;

    private TipoCopia(int copia){
        this.copia = copia;
    }

    private int getOrden(){
        return copia;
    }
}
