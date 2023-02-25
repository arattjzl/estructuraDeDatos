package repasoDePOO.implementaciones;

import repasoDePOO.interfaces.IConsulta;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Consulta implements IConsulta {

    // La clase tiene como objetivo poder consultar todos los
    // registros que se hayan realizado, filtrandolos por un string el cual
    // regresara una lista con cada todos los objetos que hagan match con ese string que buscamos

    public ArrayList<Avion> nuevosAviones;
    public ArrayList<Vuelo> nuevosVuelosOrigen;
    public ArrayList<Vuelo> nuevosVuelosDestino;
    public ArrayList<Aeropuerto> nuevosAeropuertos;
    public Consulta(){}

    // Regresa una lista de objetos tipo avion con objetos que tengan el mismo tipo de avion que se busca
    @Override
    public List<Avion> getAvionTipo(String tipo, List<Avion> lista) {
        nuevosAviones = new ArrayList<>();
        for(Avion avion: lista){
            if(Objects.equals(avion.getTipoAvion(), tipo)){
                nuevosAviones.add(avion);
            }
        }
        return nuevosAviones;
    }

    // Regresa una lista de objetos tipo vuelo con objetos que tengan el mismo aeropuerto de origen que se busca
    @Override
    public List<Vuelo> getVueloOrigen(String origen, List<Vuelo> lista) {
        nuevosVuelosOrigen = new ArrayList<>();
        for(Vuelo vuelo: lista){
            if(Objects.equals(vuelo.getAeropuertoOrigen().getCiudad(), origen)){
                nuevosVuelosOrigen.add(vuelo);
            }
        }
        return nuevosVuelosOrigen;
    }

    // Regresa una lista de objetos tipo vuelo con objetos que tengan el mismo aeropuerto de destino que se busca
    @Override
    public List<Vuelo> getVueloDestino(String destino, List<Vuelo> lista) {
        nuevosVuelosDestino = new ArrayList<>();
        for(Vuelo vuelo: lista){
            if(Objects.equals(vuelo.getAeropuertoDestino().getCiudad(), destino)){
                nuevosVuelosDestino.add(vuelo);
            }
        }
        return nuevosVuelosDestino;
    }

    // Regresa una lista de objetos tipo aeropuerto con objetos que tengan la misma ciudad que se busca
    @Override
    public List<Aeropuerto> getAeropuertoCiudad(String ciudad, List<Aeropuerto> lista) {
        nuevosAeropuertos = new ArrayList<>();
        for(Aeropuerto aeropuerto: lista){
            if(Objects.equals(aeropuerto.getCiudad(), ciudad)){
                nuevosAeropuertos.add(aeropuerto);
            }
        }
        return nuevosAeropuertos;
    }
}
