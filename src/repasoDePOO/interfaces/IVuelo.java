package repasoDePOO.interfaces;

import repasoDePOO.implementaciones.Aeropuerto;
import repasoDePOO.implementaciones.Avion;

import java.time.LocalDate;

public interface IVuelo {
    public void setAeropuertoOrigen(IAeropuerto aeropuertoOrigen);
    public IAeropuerto getAeropuertoOrigen();
    public void setAeropuertoDestino(IAeropuerto aeropuertoDestino);
    public IAeropuerto getAeropuertoDestino();
    public void setAvion(IAvion avion);
    public IAvion getAvion();
    public void setFecha(LocalDate fecha);
    public LocalDate getFecha();
    public void setPiloto(IPiloto piloto);
    public IPiloto getPiloto();
}
