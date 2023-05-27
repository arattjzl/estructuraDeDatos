package registros.commons;

public class VariableEstadistica {
    protected Object info;
    protected double probabilidad;
    public VariableEstadistica(Object info, double probabilidad){
        this.info = info;
        this.probabilidad = probabilidad;
    }
    public VariableEstadistica(){
        this.info = "";
        this.probabilidad = -1.0;
    }

    public Object getInfo(){
        return info;
    }
    public void setInfo(Object info){
        this.info = info;
    }

    public double getProbabilidad(){
        return probabilidad;
    }
    public void setProbabilidad(double probabilidad){
        this.probabilidad = probabilidad;
    }

    @Override
    public String toString() {
        return "(" + info.toString() + ")";
    }
}
