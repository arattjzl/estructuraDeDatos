package repasoDePOO.implementaciones;

import repasoDePOO.interfaces.IAeropuerto;
import repasoDePOO.interfaces.IAvion;
import repasoDePOO.interfaces.IPiloto;
import repasoDePOO.interfaces.IVuelo;

import java.time.LocalDate;
import java.util.Objects;

public class Vuelo implements IVuelo {

    // La clase permite crear un objeto tipo vuelo
    // la cual tiene atributos de aeropuerto de origen y destino,
    // avion, piloto y fecha las cuales serviran para el registro
    protected IAeropuerto aeropuertoOrigen, aeropuertoDestino;
    protected IAvion avion;
    protected IPiloto piloto;
    protected LocalDate fecha;

    public Vuelo(IAeropuerto origen, IAeropuerto destino, IAvion avion, LocalDate fecha, IPiloto piloto){
        aeropuertoOrigen = origen;
        aeropuertoDestino = destino;
        this.avion = avion;
        this.fecha = fecha;
        System.out.println("Se creo correctamente un vuelo");
    }
    @Override // Cambia el aeropuerto de origen
    public void setAeropuertoOrigen(IAeropuerto aeropuerto){
        aeropuertoOrigen = aeropuerto;
    }
    @Override // Regresa el aeropuerto de origen
    public IAeropuerto getAeropuertoOrigen(){
        return aeropuertoOrigen;
    }
    @Override // Cambia el aeropuerto de destino
    public void setAeropuertoDestino(IAeropuerto aeropuerto){
        aeropuertoDestino = aeropuerto;
    }
    @Override // Regresa el aeropuerto de destino
    public IAeropuerto getAeropuertoDestino(){
        return aeropuertoDestino;
    }
    @Override // Cambia el avion
    public void setAvion(IAvion avion){
        this.avion = avion;
    }
    @Override // Regresa el avion
    public IAvion getAvion(){
        return avion;
    }
    @Override // Cambia la fecha
    public void setFecha(LocalDate fecha){
        this.fecha = fecha;
    }
    @Override // Regresa la fecha
    public LocalDate getFecha(){
        return fecha;
    }
    @Override // Cambia el piloto solo si tiene la misma licencia que el avion que tiene el vuelo
    public void setPiloto(IPiloto piloto) {
        if(Objects.equals(avion.getTipoAvion(), piloto.getLicencia())){
            this.piloto = piloto;
        } else {
            System.out.println("El piloto no tiene la misma licencia");
        }

    }
    @Override // Regresa el piloto
    public IPiloto getPiloto() {
        return piloto;
    }

    @Override
    public String toString() {
        return "Vuelo{" +
                "aeropuertoOrigen=" + aeropuertoOrigen +
                ", aeropuertoDestino=" + aeropuertoDestino +
                ", avion=" + avion +
                ", fecha=" + fecha +
                '}';
    }
}
