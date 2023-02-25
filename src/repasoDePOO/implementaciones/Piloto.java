package repasoDePOO.implementaciones;

import repasoDePOO.interfaces.IPiloto;

public class Piloto implements IPiloto {

    // La clase permite crear objetos de tipo piloto
    // la cual tiene atributos de licencia y nombre

    protected String licencia;
    protected String nombre;
    public Piloto(String licencia, String nombre){
        this.licencia = licencia;
        this.nombre = nombre;
        System.out.println("Se creo correctamente el piloto");
    }

    @Override // Cambiar la licencia
    public void setLicencia(String licencia) {
        this.licencia = licencia;
    }

    @Override // Regresa la licencia
    public String getLicencia() {
        return licencia;
    }

    @Override // Cambiar el nombre
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override // Regresa el nombre
    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "Piloto{" +
                "licencia='" + licencia + '\'' +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
