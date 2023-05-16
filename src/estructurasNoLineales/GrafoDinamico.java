package estructurasNoLineales;

import entradasalida.SalidaPorDefecto;
import estructurasLineales.ListaDinamica;
import estructurasLineales.PilaDinamica;
import estructurasNoLineales.auxiliares.Vertice;

public class GrafoDinamico {
    protected ListaDinamica listaAdyacencia;

    public GrafoDinamico() {
        listaAdyacencia = new ListaDinamica();
    }

    private ListaDinamica buscarVerticeSubLista(Object verticeBuscado){
        listaAdyacencia.inicializarIterador();
        while (listaAdyacencia.hayNodo()){
            ListaDinamica subLista = (ListaDinamica) listaAdyacencia.obtenerNodo();
            Vertice verticePrimero = (Vertice) subLista.getPrimero().getInfo();

            if(verticeBuscado.toString().equalsIgnoreCase(verticePrimero.toString())){
                return subLista;
            }
        }
        return null;
    }
    public boolean agregarVertice(Object info){
        ListaDinamica sublistaVertice = buscarVerticeSubLista(info);
        if(sublistaVertice == null){ // no esta, se puede agregar
            Vertice verticeNuevo = new Vertice();
            verticeNuevo.setInfo(info);

            ListaDinamica sublistaNueva = new ListaDinamica();
            int retornoSL = sublistaNueva.agregar(verticeNuevo);
            if(retornoSL == -1){
                return false;
            }

            int retornoLN = listaAdyacencia.agregar(sublistaNueva);
            if(retornoLN == -1){
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }
    public boolean agregarArista(Object origen, Object destino){
        ListaDinamica sublistaOrigen = buscarVerticeSubLista(origen);
        ListaDinamica sublistaDestino = buscarVerticeSubLista(destino);

        if(sublistaOrigen != null && sublistaDestino != null){
            Vertice verticeDestino = (Vertice) sublistaDestino.getPrimero().getInfo();

            int retorno = sublistaOrigen.agregar(verticeDestino);

            if(retorno == -1){
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    public boolean agregarArista(Object origen, Object destino, double peso){
        ListaDinamica sublistaOrigen = buscarVerticeSubLista(origen);
        ListaDinamica sublistaDestino = buscarVerticeSubLista(destino);

        if(sublistaOrigen != null && sublistaDestino != null){
            Vertice verticeDestino = (Vertice) sublistaDestino.getPrimero().getInfo();

            int retorno = sublistaOrigen.agregar(verticeDestino);
            sublistaOrigen.agregar(peso);

            if(retorno == -1){
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    public void imprimir(){
        listaAdyacencia.inicializarIterador();

        while(listaAdyacencia.hayNodo()){
            ListaDinamica sublista = (ListaDinamica) listaAdyacencia.obtenerNodo();

            sublista.imprimir();
            SalidaPorDefecto.terminal("\n");
        }
    }

    public ListaDinamica recorridoProfundidad(Object origen){
        PilaDinamica pila = new PilaDinamica();
        ListaDinamica marcados = new ListaDinamica();
        ListaDinamica recorridoSalida = new ListaDinamica();

        ListaDinamica sublistaOrigen = buscarVerticeSubLista(origen);
        if(sublistaOrigen == null){
            return null;
        }

        Vertice verticeOrigen = (Vertice) sublistaOrigen.getPrimero().getInfo();
        pila.poner(verticeOrigen);
        marcados.agregar(verticeOrigen);

        while(!pila.vacia()){
            Vertice verticeActual = (Vertice) pila.quitar();
            recorridoSalida.agregar(verticeActual.getInfo());

            ListaDinamica sublistaVerticeActual = buscarVerticeSubLista(verticeActual);
            marcarYEnpilarVerticesAydacentea(sublistaVerticeActual, marcados, pila);
        }
        return recorridoSalida;
    }

    private void marcarYEnpilarVerticesAydacentea(ListaDinamica sublistaOrigen, ListaDinamica marcados, PilaDinamica pila){
        sublistaOrigen.inicializarIterador();
        sublistaOrigen.obtenerNodo();

        while (sublistaOrigen.hayNodo()){
            Object cadaNodo = sublistaOrigen.obtenerNodo();
            if(cadaNodo instanceof Vertice verticDestino){
                if(marcados.buscar(verticDestino) == null){
                    pila.poner(verticDestino);
                    marcados.agregar(verticDestino);
                }
            }
        }
    }

    public void algoritmoDePrim(){
        ListaDinamica conjuntoVertices = obtenerVertices();
        ListaDinamica conjuntoAuxiliar = new ListaDinamica();
        conjuntoAuxiliar.agregar(conjuntoVertices.getPrimero());

        while(conjuntoVertices != conjuntoAuxiliar){
            buscarVerticeSubLista()
        }
    }

    private ListaDinamica obtenerVertices(){
        ListaDinamica lista = new ListaDinamica();
        listaAdyacencia.inicializarIterador();
        while(listaAdyacencia.hayNodo()){
            ListaDinamica cadaSublista = (ListaDinamica) listaAdyacencia.obtenerNodo();
            lista.agregar(cadaSublista.getPrimero());
        }
        return lista;
    }

    private void elegirAristaMenorCosto(){
        listaAdyacencia.an
    }
}
