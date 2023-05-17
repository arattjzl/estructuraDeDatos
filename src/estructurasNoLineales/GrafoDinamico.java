package estructurasNoLineales;

import entradasalida.SalidaPorDefecto;
import estructurasLineales.ListaDinamica;
import estructurasLineales.PilaDinamica;
import estructurasLineales.auxiliares.Nodo;
import estructurasNoLineales.auxiliares.Vertice;

/**
 * Clase con los métodos para el TDA Grafo Dinámico.
 * @author Aratt
 * @version 1.0
 */

public class GrafoDinamico {
    protected ListaDinamica listaAdyacencia;


    public GrafoDinamico() {
        listaAdyacencia = new ListaDinamica();
    }

    /**
     * Obtiene la sublista del vértice indicado.
     * @param verticeBuscado Vértice por buscar.
     * @return Regresa la sublista del vértice.
     */
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

    /**
     * Agrega un nuevo vértice al grafo.
     * @param info Información que contendrá el vértice.
     * @return Regresa <b>true</b> si se agregó o <b>false</b> si no.
     */
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

    /**
     * Agrega una arista entre dos vértices.
     * @param origen Vértice origen.
     * @param destino Vértice destino.
     * @return Regresa <b>true</b> si se agregó o <b>false</b> si no.
     */
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

    /**
     * Agrega una arista entre dos vértices.
     * @param origen Vértice origen.
     * @param destino Vértice destino.
     * @param peso Peso que tiene la arista.
     * @return Regresa <b>true</b> si se agregó o <b>false</b> si no.
     */
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

    /**
     * Imprime el grafo.
     */
    public void imprimir(){
        listaAdyacencia.inicializarIterador();

        while(listaAdyacencia.hayNodo()){
            ListaDinamica sublista = (ListaDinamica) listaAdyacencia.obtenerNodo();

            sublista.imprimir();
            SalidaPorDefecto.terminal("\n");
        }
    }

    /**
     * Recorrido por profundidad del grafo.
     * @param origen Vértice origen.
     * @return Regresa el recorrido desde el origen.
     */
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

    /**
     * Realiza el algoritmo de Prim para encontrar el árbol abarcador de costo mínimo de un grafo.
     * @return Regresa una lista con los vértices mínimos.
     */
    public ListaDinamica algoritmoDePrim(){
        ListaDinamica conjuntoVertices = obtenerVertices();
        ListaDinamica conjuntoAuxiliar = new ListaDinamica();
        conjuntoAuxiliar.agregar(conjuntoVertices.getPrimero());
        ListaDinamica verticesMinimos = new ListaDinamica();
        Vertice anterior = new Vertice();

        conjuntoVertices.inicializarIterador();
        while(conjuntoVertices.hayNodo()){
            Vertice cadaVertice = (Vertice) conjuntoVertices.obtenerNodo();
            if(cadaVertice!=conjuntoVertices.verUltimo()){
                Vertice menor = elegirAristaMenorCosto(cadaVertice, anterior);
                conjuntoAuxiliar.agregar(menor);
                verticesMinimos.agregar("{ " + cadaVertice + " - " + menor + " }");
                anterior = cadaVertice;
            }
        }
        return verticesMinimos;
    }

    /**
     * Obtiene todos los vértices del grafo.
     * @return Regresa una lista con todos los vértices del grafo.
     */
    private ListaDinamica obtenerVertices(){
        ListaDinamica lista = new ListaDinamica();
        listaAdyacencia.inicializarIterador();
        while(listaAdyacencia.hayNodo()){
            ListaDinamica cadaSublista = (ListaDinamica) listaAdyacencia.obtenerNodo();
            lista.agregar(cadaSublista.getPrimero().getInfo());
        }
        return lista;
    }

    /**
     * Elige la arista con menor costo de una sublista.
     * @param origen Vértice origen en donde buscará la arista con menor costo.
     * @param anterior Vértice anterior que se utilizó.
     * @return Regresa el vértice con la arista de menor costo.
     */
    private Vertice elegirAristaMenorCosto(Vertice origen, Vertice anterior){
        ListaDinamica listaVertices = buscarVerticeSubLista(origen);
        if(listaVertices != null){
            listaVertices.inicializarIterador();
            double pesoMinimo = Double.MAX_VALUE;
            Vertice verticeMinimo = null;
            while(listaVertices.hayNodo()){
                Object peso = listaVertices.obtenerNodo();
                if(!(peso instanceof Vertice)){
                    Vertice verticeAnteriorPeso = (Vertice) ((Nodo) listaVertices.buscarAnterior(peso).obtener(0)).getInfo();
                    if(verticeAnteriorPeso != anterior){
                        if((double) peso < pesoMinimo){
                            pesoMinimo = (double) peso;
                            verticeMinimo = verticeAnteriorPeso;
                        }
                    }
                }
            }
            return verticeMinimo;
        }
        return null;
    }
}
