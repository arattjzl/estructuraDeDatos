package utils.commons;

public enum TipoRenglon {
    SUP(1),
    INF(2);
    private int renglon;

    private TipoRenglon(int renglon){
        this.renglon = renglon;
    }

    private int getRenglon(){
        return renglon;
    }
}
