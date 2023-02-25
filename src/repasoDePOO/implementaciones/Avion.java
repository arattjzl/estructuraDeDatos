package repasoDePOO.implementaciones;

import repasoDePOO.interfaces.IAvion;
import repasoDePOO.interfaces.IPiloto;

public class Avion implements IAvion {

    // La clase sirve para crear objetos de tipo avion
    // la cual tiene atributos de tipo de avion, matricula, fabricante
    // modelo, capacidad y autonomia

    public String tipoAvion;
    public String matricula;
    public String fabricante;
    public String modelo;
    public int capacidad;
    public String autonomia;


    public Avion(String tipoAvion, String matricula, String fabricante, String modelo, int capacidad, String autonomia){
        this.tipoAvion = tipoAvion;
        this.matricula = matricula;
        this.fabricante = fabricante;
        this.modelo = modelo;
        this.capacidad = capacidad;
        this.autonomia = autonomia;

        System.out.println("Se creo correctamente el Avion");
    }
    @Override // Cambia el tipo de avion
    public void setTipoAvion(String tipoAvion) {
        this.tipoAvion = tipoAvion;
    }

    @Override // Regresa el tipo de avion
    public String getTipoAvion() {
        return tipoAvion;
    }

    @Override // Cambia la matricula
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    @Override // Regresa la matricula
    public String getMatricula() {
        return matricula;
    }

    @Override // Cambia el fabricante
    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    @Override // Regresa el fabricante
    public String getFabricante() {
        return fabricante;
    }

    @Override // Cambia el modelo
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @Override // Regresa el modelo
    public String getModelo() {
        return modelo;
    }

    @Override // Cambia la capacidad
    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    @Override // Regresa la capacidad
    public int getCapacidada() {
        return capacidad;
    }

    @Override // Cambia la autonomia
    public void setAutonomia(String autonomia) {
        this.autonomia = autonomia;
    }

    @Override // Regresa la autonomia
    public String getAutonomia() {
        return autonomia;
    }

    @Override
    public String toString() {
        return "Avion guardado correctamente{" +
                "tipoAvion='" + tipoAvion + '\'' +
                ", matricula='" + matricula + '\'' +
                ", fabricante='" + fabricante + '\'' +
                ", modelo='" + modelo + '\'' +
                ", capacidad=" + capacidad +
                ", autonomia=" + autonomia +
                '}';
    }
}
