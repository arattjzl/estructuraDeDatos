package registros.commons;

import estructurasLineales.ListaDinamicaClave;

public class AtributosMOM {
    protected String estado;
    protected double probabilidadInicio;
    protected ListaDinamicaClave probabilidadEmision;

    public AtributosMOM() {
        probabilidadEmision = new ListaDinamicaClave();
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public double getProbabilidadInicio() {
        return probabilidadInicio;
    }

    public void setProbabilidadInicio(double probabilidadInicio) {
        this.probabilidadInicio = probabilidadInicio;
    }

    public ListaDinamicaClave getProbabilidadEmision() {
        return probabilidadEmision;
    }

    public void setProbabilidadEmision(ListaDinamicaClave probabilidadEmision) {
        this.probabilidadEmision = probabilidadEmision;
    }

    @Override
    public String toString() {
        return estado;
    }
}
