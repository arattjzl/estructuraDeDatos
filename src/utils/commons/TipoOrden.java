package utils.commons;

public enum TipoOrden {
    DEC(2),
    INC(1);
    private int orden;

    private TipoOrden(int orden){
        this.orden = orden;
    }

    private int getOrden(){
        return orden;
    }
}
