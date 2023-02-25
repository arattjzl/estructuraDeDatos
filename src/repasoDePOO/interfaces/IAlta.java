package repasoDePOO.interfaces;

import repasoDePOO.implementaciones.Aeropuerto;
import repasoDePOO.implementaciones.Avion;
import repasoDePOO.implementaciones.Piloto;
import repasoDePOO.implementaciones.Vuelo;

import java.util.List;

public interface IAlta {
    public void darDeAltaAvion(Avion objeto, List<Avion> lista);
    public void darDeAltaPiloto(Piloto objeto, List<Piloto> lista);
    public void darDeAltaAeropuerto(Aeropuerto objeto, List<Aeropuerto> lista);
    public void darDeAltaVuelo(Vuelo objeto, List<Vuelo> lista);
}
