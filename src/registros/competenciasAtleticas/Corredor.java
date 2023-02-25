package registros.competenciasAtleticas;

public class Corredor {

    protected String nombre;
    protected int numCorredor;
    protected int edad;
    protected String nacionalidad;

    public Corredor(String nombre, int numCorredor, int edad, String nacionalidad) {
        this.nombre = nombre;
        this.numCorredor = numCorredor;
        this.edad = edad;
        this.nacionalidad = nacionalidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumCorredor() {
        return numCorredor;
    }

    public void setNumCorredor(int numCorredor) {
        this.numCorredor = numCorredor;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    @Override
    public String toString() {
        return "" + getNumCorredor();
    }
}
