package utils;

public class PalabraDiccionario {

    public String palabra;
    public String descripcion;
    public String sinonimo;
    public String uso;

    public PalabraDiccionario(String palabra, String descripcion, String sinonimo, String uso){
        this.palabra = palabra;
        this.descripcion = descripcion;
        this.sinonimo = sinonimo;
        this.uso = uso;
    }



    public String getPalabra() {
        return palabra;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getSinonimo() {
        return sinonimo;
    }

    public void setSinonimo(String sinonimo) {
        this.sinonimo = sinonimo;
    }

    public String getUso() {
        return uso;
    }

    public void setUso(String uso) {
        this.uso = uso;
    }

    @Override
    public String toString() {
        return descripcion;
    }
}
