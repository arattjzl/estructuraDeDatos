package registros.commons;

public class VariableEstadistica {
    protected String info;
    protected double probabilidad;
    public VariableEstadistica(String info, double probabilidad){
        this.info = info;
        this.probabilidad = probabilidad;
    }
    public VariableEstadistica(){
        this.info = info;
        this.probabilidad = probabilidad;
    }

    public String getInfo(){
        return info;
    }
    public void setInfo(String info){
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
        return "("+ info + ")" + "->" + probabilidad;
    }
}
