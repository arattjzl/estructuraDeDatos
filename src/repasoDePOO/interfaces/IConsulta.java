package repasoDePOO.interfaces;

import repasoDePOO.implementaciones.Aeropuerto;
import repasoDePOO.implementaciones.Avion;
import repasoDePOO.implementaciones.Vuelo;

import java.util.List;

public interface IConsulta {
    public List<Avion> getAvionTipo(String tipo, List<Avion> lista);
    public List<Vuelo> getVueloOrigen(String origen, List<Vuelo> lista);
    public List<Vuelo> getVueloDestino(String destino, List<Vuelo> lista);
    public List<Aeropuerto> getAeropuertoCiudad(String ciudad, List<Aeropuerto> lista);
}
