package repasoDePOO.implementaciones;

import repasoDePOO.interfaces.IAeropuerto;

public class Aeropuerto implements IAeropuerto {

    // La clase es creada para crear objetos de tipo aeropuerto los cuales
    // tienes atributos de ciudada y pais
    protected String ciudad;
    protected String pais;
    public Aeropuerto(String ciudad, String pais){
        this.ciudad = ciudad;
        this.pais = pais;
        System.out.println("Se creo correctamente un aeropuerto");
    }

    @Override // Cambia la ciudad
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    @Override // Regresa la ciudad
    public String getCiudad() {
        return ciudad;
    }

    @Override // Cambia el pais
    public void setPais(String pais) {
        this.pais = pais;
    }

    @Override // Regresa el pais
    public String getPais() {
        return pais;
    }

    @Override
    public String toString() {
        return "Aeropuerto guardado correctamente{" +
                "ciudad='" + ciudad + '\'' +
                ", pais='" + pais + '\'' +
                '}';
    }
}
