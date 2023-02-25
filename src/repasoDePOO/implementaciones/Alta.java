package repasoDePOO.implementaciones;

import repasoDePOO.interfaces.IAlta;

import java.util.List;

public class Alta implements IAlta {

    // La clase tiene como objetivo crear un objeto de alta,
    // el cual es el que se encargara de dar de alta a cada uno de los objetos
    // los cuales deberan de estar acompaniados de la lista en la cual se daran de alta
    public Alta(){}
    @Override // Da de alta a un objeto tipo avion en una lista de aviones
    public void darDeAltaAvion(Avion objeto, List<Avion> lista) {
        lista.add(objeto);
    }

    @Override // Da de alta a un objeto tipo piloto en una lista de pilotos
    public void darDeAltaPiloto(Piloto objeto, List<Piloto> lista) {
        lista.add(objeto);
    }

    @Override // Da de alta a un objeto tipo aeropuerto en una lista de aeropuertos
    public void darDeAltaAeropuerto(Aeropuerto objeto, List<Aeropuerto> lista) {
        lista.add(objeto);
    }

    @Override // Da de alta a un objeto tipo vuelo en una lista de vuelos
    public void darDeAltaVuelo(Vuelo objeto, List<Vuelo> lista) {
        lista.add(objeto);
    }
}
