package utils.commons;

public enum TipoColumna {
    IZQ(1),
    DER(2);
    private int columna;

    private TipoColumna(int columna){
        this.columna = columna;
    }

    private int getColumna(){
        return columna;
    }
}
