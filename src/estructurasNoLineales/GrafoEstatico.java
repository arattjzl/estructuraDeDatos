package estructurasNoLineales;

import entradasalida.SalidaPorDefecto;
import estructurasLineales.ColaEstatica;
import estructurasLineales.ListaDinamica;
import estructurasLineales.ListaEstatica;
import estructurasLineales.PilaEstatica;
import estructurasNoLineales.auxiliares.Vertice;
import registros.commons.EtiquetaGrafo;
import utils.commons.TipoOrden;

public class GrafoEstatico {
    protected Matriz2Numerica aristas;
    protected ListaEstatica vertices;
    protected TipoOrden tipoOrden;

    public GrafoEstatico(int numVertices){
        aristas = new Matriz2Numerica(numVertices,numVertices);
        vertices = new ListaEstatica(numVertices);
    }

    public GrafoEstatico(int numVeces, Object inicializador){
        this(numVeces);
        aristas.rellenar(inicializador);
    }

    public GrafoEstatico(int numVeces, TipoOrden tipoOrden){
        this(numVeces);
        if(tipoOrden == TipoOrden.DEC){
            aristas.rellenar(Double.MAX_VALUE);
        } else {
            aristas.rellenar(Double.MIN_VALUE);
        }
        aristas.matrizDiagonal(0.0);
        this.tipoOrden = tipoOrden;
    }

    public boolean agregarVertice(Object info){
        int pos = (int) vertices.buscar(info);
        if(pos != -1){
            return false;
        } else {
            Vertice nuevoVertice = new Vertice();
            nuevoVertice.setInfo(info);
            nuevoVertice.setIndice(vertices.cantidad());
            int retorno = vertices.agregar(nuevoVertice);
            return retorno != -1;
        }
    }

    public boolean agregarArista(Object origen, Object destino){
        return agregarArista(origen,destino,1);
    }

    public boolean agregarArista(Object origen, Object destino, double peso){
        int indiceOrigen = (int) vertices.buscar(origen);
        int indiceDestino = (int) vertices.buscar(destino);

        if(indiceOrigen != -1 && indiceDestino != -1){
            return aristas.cambiar(indiceOrigen,indiceDestino,peso);
        } else {
            return false;
        }
    }

    public void imprimir(){
        vertices.imprimir();
        SalidaPorDefecto.terminal("\n");
        aristas.imprimirPorColumna();
    }

    public ListaDinamica recorridoProfundidad(Object origen){
        // 1. Partir de un nodo origen, marcarlo y meterlo a una pila
        PilaEstatica pila = new PilaEstatica(vertices.cantidad());
        ListaEstatica marcados = new ListaEstatica(vertices.cantidad());
        ListaDinamica recorrido = new ListaDinamica();
        marcados.rellenar(false, marcados.getTope());

        int indiceOrigen = (int) vertices.buscar(origen);
        if(indiceOrigen == -1){
            return null;
        }
        pila.poner(indiceOrigen);
        marcados.rellenar(false, vertices.cantidad());
        marcados.cambiar(indiceOrigen,true);

        // 2. Mientras la pila no este vacia, sacar un elemento y procesarlo
        while (!pila.vacia()){
            int indiceVertAct = (int) pila.quitar();
            Vertice verticeActual = (Vertice) vertices.obtener(indiceVertAct);
            recorrido.agregar(verticeActual.getInfo());

            // 3. Los vertices adyacentes a este vertices sacado, mientras no esten marcados, ponerlos en la pila y marcarlos
            // llama al metodo

            marcarVerticeAdyacente(indiceVertAct, marcados, pila);
        }
        return recorrido;
    }

    private void marcarVerticeAdyacente(int indiceVerticeOrigen, ListaEstatica marcados, PilaEstatica pila){
        for(int cadaDestino = 0; cadaDestino < aristas.getColumnas(); cadaDestino++){
            Double flecha = (Double) aristas.obtener(indiceVerticeOrigen, cadaDestino);
            if (flecha != null && flecha > 0 && ((boolean) marcados.obtener(cadaDestino))== false){
                marcados.cambiar(cadaDestino, true);
                pila.poner(cadaDestino);
            }
        }
    }

    public ListaDinamica recorridoAnchura(Object origen){
        ColaEstatica cola = new ColaEstatica(vertices.cantidad());
        ListaEstatica marcados = new ListaEstatica(vertices.cantidad());
        ListaDinamica recorridoSalida = new ListaDinamica();
        marcados.rellenar(false, marcados.getTope());
        //Partir de un nodo origen, marcarlo y ponerlo en la pila
        int indiceOrigen = (int) vertices.buscar(origen);
        if(indiceOrigen==-1){
            return null;
        }
        cola.poner(indiceOrigen);
        marcados.rellenar(false, vertices.cantidad());
        marcados.cambiar(indiceOrigen,true);

        while(!cola.vacia()) {
            //Mientras halla elementos en la pila sacar 1 y procesar
            int indiceVertAct = (int) cola.quitar();
            Vertice verticeActual = (Vertice) vertices.obtener(indiceVertAct);
            recorridoSalida.agregar(verticeActual.getInfo());
            //Los vertices adyacentes al nodo acabado de procesar y que no esten marcados, ponerlos en la pila y marcarlos.
            marcarVerticeAdyacenteAnchura(indiceVertAct, marcados, cola);
        }
        return recorridoSalida;
    }

    private void marcarVerticeAdyacenteAnchura(int indiceVerticeOrigen, ListaEstatica marcados, ColaEstatica cola){
        for(int cadaDestino = 0; cadaDestino < aristas.getColumnas(); cadaDestino++){
            Double flecha = (Double) aristas.obtener(indiceVerticeOrigen, cadaDestino);
            if (flecha != null && flecha > 0 && ((boolean) marcados.obtener(cadaDestino))== false){
                marcados.cambiar(cadaDestino, true);
                cola.poner(cadaDestino);
            }
        }
    }

    public ListaDinamica ordenacionTopologica(){
        // Ordenacion topologica

        ListaDinamica recorridoOrdTop = new ListaDinamica();
        ColaEstatica cola = new ColaEstatica(vertices.cantidad());
        ListaEstatica marcados = new ListaEstatica(vertices.cantidad());
        ListaEstatica incidencias = new ListaEstatica(vertices.cantidad());

        // Paso 0. No existencia de ciclos ESTE PASO SE DEBE DE EJECUTAR EN OTRO PROCESO ... AUN NO SE HACE

        // Paso 1. Inicializar incidencias
        incidenciasTodosVertices(incidencias);

        // Paso 2. Los vertices con incidencias en 0 se meten en la cola, se marcan
        marcados.rellenar(false, vertices.cantidad());
        encolarYMarcarVerticesIncidencias0(incidencias, marcados, cola);

        // Paso 3. Mientras haya elementos en la cola, sacar una y procesarlo
        while (!cola.vacia()){
            int indiceVerticeActual = (int) cola.quitar();
            Vertice verticeActual = (Vertice) vertices.obtener(indiceVerticeActual);
            recorridoOrdTop.agregar(verticeActual.getInfo());

            // Paso 4. Recalcular incidencias con base al paso 3
            recalcularIncidenciaVertices(incidencias, indiceVerticeActual, marcados);

            // Paso 5. Meter en la cola los vertices con incidencias en 0, y que no esten marcados, después meterlos
            encolarYMarcarVerticesIncidencias0(incidencias, marcados, cola);
        }

        return recorridoOrdTop;
    }

    // Paso 1. Inicializar incidencias

    private int incidenciasVertice(int indiceDestino){
        int numIncidencias = 0;
        for(int cadaFilaOrige = 0; cadaFilaOrige < aristas.getRenglones(); cadaFilaOrige++){
            Double flecha = (Double) aristas.obtener(cadaFilaOrige, indiceDestino);
            if(flecha != null && flecha > 0){
                numIncidencias++;
            }
        }
        return numIncidencias;
    }

    // Paso 1. Inicializar incidencias

    private void incidenciasTodosVertices(ListaEstatica incidencias){
        for(int cadaColumnaDestino = 0; cadaColumnaDestino < aristas.getColumnas(); cadaColumnaDestino++){
            int numIncidenciasCadaDestino = incidenciasVertice(cadaColumnaDestino);
            incidencias.agregar(numIncidenciasCadaDestino);
        }
    }

    // Paso 2 y 5. Los vertices con incidencias en 0 se meten en la cola, se marcan
    private void encolarYMarcarVerticesIncidencias0(ListaEstatica incidencias, ListaEstatica marcados, ColaEstatica cola){
        for(int cadaVertice = 0; cadaVertice < incidencias.cantidad(); cadaVertice++){
            if((int) incidencias.obtener(cadaVertice) == 0 && !((boolean) marcados.obtener(cadaVertice))){
                cola.poner(cadaVertice);
                marcados.cambiar(cadaVertice, true);
            }
        }
    }

    private void recalcularIncidenciaVertices(ListaEstatica incidencias, int indiceOrigen, ListaEstatica marcados){
        for(int cadaDestino = 0; cadaDestino < aristas.getColumnas(); cadaDestino++) {
            Double flecha = (Double) aristas.obtener(indiceOrigen, cadaDestino);
            if (flecha != null && flecha > 0 && !((boolean) marcados.obtener(cadaDestino))) { // hay adyacencia
                int incidenciaDestino = (int) incidencias.obtener(cadaDestino);
                incidencias.cambiar(cadaDestino, incidenciaDestino-1);
            }
        }
    }

    // Calculo de primero la ruta mas corta: Dijkstra
    public ListaEstatica rutaMasCortaDijkstra(Object origen){
        ListaEstatica etiquetasOptimas = new ListaEstatica(vertices.cantidad());

        // Paso 0. Determinar si el origen existe
        Integer indiceOrigen = (Integer) vertices.buscar(origen);
        if(indiceOrigen == -1){
            return null;
        }

        double infinito = 0.0;
        if(tipoOrden == TipoOrden.DEC){
            infinito = Double.MAX_VALUE;
        } else {
            infinito = Double.MIN_VALUE;
        }
        // Calculo de primero la ruta mas corta: Dijkstra
        // Paso 1. Inicializar las etiquetas. Iteracion 0
        inicializarEtiquetasOptimas(etiquetasOptimas, infinito, 0.0, -1, indiceOrigen, 0);
        etiquetasOptimas.imprimir();
        // Paso 2. Calcular la metica acumulada del vertice actual (el primer vertice actual es el origen) hacia cada vecino
        // no marcado, y si la metrica es mejor, se sobreescribe

        // Paso 3. Buscar el vertice con la mejor metrica, se marca y es el vertice actual
        return etiquetasOptimas;
    }

    // Paso 1
    private void inicializarEtiquetasOptimas(ListaEstatica etiquetasOptimas,
                                             Double metricaVertices,
                                             Double metricaOrigen,
                                             int verticeAnteriorVertices,
                                             int indiceVerticeOrigen,
                                             int iteracionInicial){
        for(int cadaVertice = 0; cadaVertice < etiquetasOptimas.getMAXIMO(); cadaVertice++){
            EtiquetaGrafo etiquetaNueva = new EtiquetaGrafo();

            etiquetaNueva.setIteracion(iteracionInicial);
            etiquetaNueva.setMetricaAcumulada(metricaVertices);
            etiquetaNueva.setVerticeAnterior(verticeAnteriorVertices);

            etiquetasOptimas.agregar(etiquetaNueva);
        }
        // Solo al origen se le cambia los valores propios
        EtiquetaGrafo etiquetaOrigen = (EtiquetaGrafo) etiquetasOptimas.obtener(indiceVerticeOrigen);
        etiquetaOrigen.setMetricaAcumulada(metricaOrigen);
    }
}
