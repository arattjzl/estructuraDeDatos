package estructurasNoLineales;

import entradasalida.SalidaPorDefecto;
import estructurasLineales.ColaEstatica;
import estructurasLineales.ListaDinamica;
import estructurasLineales.ListaEstatica;
import estructurasLineales.PilaEstatica;
import estructurasNoLineales.auxiliares.Vertice;
import registros.commons.EtiquetaGrafo;
import utils.commons.Comparador;
import utils.commons.TipoOrden;

/**
 * Clase que contiene los métodos del TDA grafo estático.
 * @author Aratt
 * @version 1.0
 */
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

    public Matriz2Numerica getAristas() {
        return aristas;
    }

    public void setAristas(Matriz2Numerica aristas) {
        this.aristas = aristas;
    }

    public ListaEstatica getVertices() {
        return vertices;
    }

    public void setVertices(ListaEstatica vertices) {
        this.vertices = vertices;
    }

    public TipoOrden getTipoOrden() {
        return tipoOrden;
    }

    public void setTipoOrden(TipoOrden tipoOrden) {
        this.tipoOrden = tipoOrden;
    }

    /**
     * Agrega un vértice.
     * @param info Información que contrendrá el vértice.
     * @return Regresa true si se agregó o false si no.
     */
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

    /**
     * Agrega una arista en la posición (origen, destino).
     * @param origen Vértice origen.
     * @param destino Vértice destino.
     * @return Regresa true si se agregó o false si no.
     */
    public boolean agregarArista(Object origen, Object destino){
        return agregarArista(origen,destino,1);
    }

    /**
     * Agrega una arista en la posición (origen, destino).
     * @param origen Vértice origen.
     * @param destino Vértice destino.
     * @param peso Peso que tiene la arista.
     * @return Regresa true si se agregó o false si no.
     */
    public boolean agregarArista(Object origen, Object destino, double peso){
        int indiceOrigen = (int) vertices.buscar(origen);
        int indiceDestino = (int) vertices.buscar(destino);

        if(indiceOrigen != -1 && indiceDestino != -1){
            return aristas.cambiar(indiceOrigen,indiceDestino,peso);
        } else {
            return false;
        }
    }

    /**
     * Imprime los vértices y las aristas.
     */
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

    public Double metricaRutaOptima(Object origen, Object destino){
        Integer indiceDestino = (Integer) vertices.buscar(destino);
        ListaEstatica etiquetasOptimas = rutaMasCortaDijkstra(origen);
        if(indiceDestino != -1 && etiquetasOptimas != null){
            // destino y origen si existen
            EtiquetaGrafo etiquetaDestinoPedido = (EtiquetaGrafo) etiquetasOptimas.obtener(indiceDestino);
            return etiquetaDestinoPedido.getMetricaAcumulada();
        }
        return null;
    }

    public ListaDinamica rutaOptima(Object origen, Object destino){
        Integer indiceDestino = (Integer) vertices.buscar(destino);
        ListaEstatica etiquetasOptimas = rutaMasCortaDijkstra(origen);
        ListaDinamica ruta = new ListaDinamica();
        if(indiceDestino != -1 && etiquetasOptimas != null) {
            int indiceActual = indiceDestino;
            do {
                Vertice vertice = (Vertice) vertices.obtener(indiceActual);
                ruta.agregarPrincipio(vertice.getInfo());
                EtiquetaGrafo etiquetaActual = (EtiquetaGrafo) etiquetasOptimas.obtener(indiceActual);
                indiceActual = etiquetaActual.getVerticeAnterior();
            } while (indiceActual != -1);
        }
        return ruta;
    }

    // Calculo de primero la ruta mas corta: Dijkstra
    private ListaEstatica rutaMasCortaDijkstra(Object origen){
        ListaEstatica etiquetasOptimas = new ListaEstatica(vertices.cantidad());
        ListaEstatica marcados = new ListaEstatica(vertices.cantidad());

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
        marcados.rellenar(false, vertices.cantidad());
        marcados.cambiar(indiceOrigen, true);

        int indiceActual = indiceOrigen;

        for(int iteracion = 1; iteracion < vertices.cantidad(); iteracion++){
            // Paso 2. Calcular la metica acumulada del vertice actual (el primer vertice actual es el origen) hacia cada vecino
            // no marcado, y si la metrica es mejor, se sobreescribe
            calcularMetricasAcumuladasVecino(etiquetasOptimas, indiceActual, marcados, infinito, iteracion);

            // Paso 3. Buscar el vertice con la mejor metrica, se marca y es el vertice actual
            indiceActual = actualizarVerticesActual(etiquetasOptimas, marcados, infinito);
            marcados.cambiar(indiceActual, true);
        }

        return etiquetasOptimas;
    }

    // Paso 1 Ruta mas corta Dijkstra
    private void inicializarEtiquetasOptimas(ListaEstatica etiquetasOptimas, Double metricaVertices,
                                             Double metricaOrigen, int verticeAnteriorVertices,
                                             int indiceVerticeOrigen, int iteracionInicial){
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

    // Paso 2. Ruta mas corta Dijkstra
    private void calcularMetricasAcumuladasVecino(ListaEstatica etiquetasOptimas, int indiceActual,
                                                  ListaEstatica marcados, double infinito, int iteracion){
        for(int cadaDestinoCol = 0; cadaDestinoCol < aristas.getColumnas(); cadaDestinoCol++){
            Double flechaAdyacente = (Double) aristas.obtener(indiceActual, cadaDestinoCol);

            if(flechaAdyacente != null && flechaAdyacente != 0 && flechaAdyacente != infinito && !((boolean) marcados.obtener(cadaDestinoCol))){
                EtiquetaGrafo etiquetaVerticeActual = (EtiquetaGrafo) etiquetasOptimas.obtener(indiceActual);
                double metricaVerticeActual = etiquetaVerticeActual.getMetricaAcumulada();
                double metricaAcumuladaOrigenDestino = metricaVerticeActual + flechaAdyacente;

                EtiquetaGrafo etiquetaDestino = (EtiquetaGrafo) etiquetasOptimas.obtener(cadaDestinoCol);

                boolean banderaSubstitucion = false;
                if(tipoOrden == TipoOrden.DEC){
                    if(metricaAcumuladaOrigenDestino < etiquetaDestino.getMetricaAcumulada()){

                        banderaSubstitucion = true;
                    }
                } else {
                    if(metricaAcumuladaOrigenDestino > etiquetaDestino.getMetricaAcumulada()){

                        banderaSubstitucion = true;
                    }
                }
                if(banderaSubstitucion){
                    etiquetaDestino.setMetricaAcumulada(metricaAcumuladaOrigenDestino);
                    etiquetaDestino.setIteracion(iteracion);
                    etiquetaDestino.setVerticeAnterior(indiceActual);
                }
            }
        }
    }

    // Paso 3. Ruta mas corta dijkstra
    private int actualizarVerticesActual(ListaEstatica etiquetasOptimas, ListaEstatica marcados, double infinito){
        double mejor = infinito;
        int indiceVerticeMejor = -1;

        for(int cadaVerticeCandidato = 0; cadaVerticeCandidato < etiquetasOptimas.cantidad(); cadaVerticeCandidato++){
            if(!(boolean) marcados.obtener(cadaVerticeCandidato)){
                EtiquetaGrafo etiquetaCandidato = (EtiquetaGrafo) etiquetasOptimas.obtener(cadaVerticeCandidato);
                if(tipoOrden == TipoOrden.DEC){// mas pequenio es mejor
                    if(etiquetaCandidato.getMetricaAcumulada() < mejor){
                        mejor = etiquetaCandidato.getMetricaAcumulada();
                        indiceVerticeMejor = cadaVerticeCandidato;
                    }
                } else { // mas grande es mejor
                    if(etiquetaCandidato.getMetricaAcumulada() > mejor){
                        mejor = etiquetaCandidato.getMetricaAcumulada();
                        indiceVerticeMejor = cadaVerticeCandidato;
                    }
                }
            }
        }
        return indiceVerticeMejor;
    }

    /**
     * Elimina el vertice indicado y todos los procesos que conlleva.
     * @param info Información por eliminar.
     */
    public Object eliminarVertice(Object info){
        Object respaldo = null;
        int posicion = (int) vertices.buscar(info);
        if(posicion > -1){
            aristas.eliminarRenglon(posicion);
            aristas.eliminarColumna(posicion);
            aristas.redefinir(nuevaMatriz(posicion));
            respaldo = vertices.eliminar(posicion);
            vertices.redimensionar(vertices.getMAXIMO()-1);
        }
        return respaldo;
    }

    /**
     * Crea una nueva matriz para cuando se quiere eliminar un vértice y sus aristas.
     * @param pos Posición que se eliminará de la matriz.
     * @return Regresa la matriz nueva.
     */
    private Matriz2Numerica nuevaMatriz(int pos){
        Matriz2Numerica matriz = new Matriz2Numerica(vertices.getTope(), vertices.getTope(), null);
        int nuevoReng = 0;
        for(int cadaReng = 0; cadaReng < aristas.getRenglones(); cadaReng++){
            ListaEstatica renglon = new ListaEstatica(matriz.getRenglones());
            for(int cadaCol = 0; cadaCol < aristas.getColumnas(); cadaCol++){
                Object espacioMatriz = aristas.obtener(cadaReng, cadaCol);
                if(espacioMatriz != null){
                    renglon.agregar(espacioMatriz);
                }
            }
            if(cadaReng != pos){
                matriz.agregarRenglon(renglon, nuevoReng);
                nuevoReng++;
            }
        }
        return matriz;
    }

    /**
     * Indica si hay adyacencia entre dos vértices proporcionados como argumento.
     * @param origen Primer vértice (origen).
     * @param destino Segundo vértice (destino).
     * @return Regresa <b>true</b> si hay adyacencia o <b>false</b> si no.
     */
    public boolean esAdyacente(Object origen, Object destino){
        int indiceOrigen = (int) vertices.buscar(origen);
        int indiceDestino = (int) vertices.buscar(destino);

        if(indiceOrigen >= 0 && indiceDestino >= 0){
            if((double) aristas.obtener(indiceOrigen, indiceDestino) > 0.0){
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    /**
     * Elimina una arista entre un par de nodos proporcionados.
     * @param origen Primer vértice (origen).
     * @param destino Segundo vértice (destino).
     * @return Regresa <b>true</b> si se elimino o <b>false</b> si no.
     */
    public boolean eliminarArista(Object origen, Object destino){
        int indiceOrigen = (int) vertices.buscar(origen);
        int indiceDestino = (int) vertices.buscar(destino);
        if(indiceOrigen >= 0 && indiceDestino >= 0){
            aristas.cambiar(indiceOrigen, indiceDestino, 0.0);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Busque un nodo en un grafo.
     * @param vertice Vértice por buscar.
     * @return Si existe debe regresar la información en cuestión, en caso contrario null.
     */
    public Object buscarVertice(Object vertice){
        int indice = (int) vertices.buscar(vertice);
        if(indice > -1){
            return vertices.obtener(indice);
        } else {
            return null;
        }
    }

    /**
     * Regresa verdadero si el grafo que tiene lazos o bucles.
     * @return Regresa <b>true</b> si el grafo que tiene lazos o bucles o <b>false</b> si no.
     */
    public boolean esPseudografo(){
        for(int cadaColReng = 0; cadaColReng < vertices.getMAXIMO(); cadaColReng++){
            if((double) aristas.obtener(cadaColReng, cadaColReng) > 0.0){
                return true;
            }
        }
        return false;
    }

    /**
     * Regresa verdadero si al menos dos de sus vértices están conectados entre sí por medio de dos aristas (aristas múltiples o paralelas).
     * @return Regresa <b>true</b> si es verdadero o <b>false</b> si no.
     */
    public boolean esMultigrafo(){
        for(int cadaReng = 0; cadaReng < vertices.getMAXIMO(); cadaReng++){
            for(int cadaCol =0; cadaCol < vertices.getMAXIMO(); cadaCol++){
                 if((double) aristas.obtener(cadaReng, cadaCol) > 0.0
                         && (double) aristas.obtener(cadaCol, cadaReng) > 0.0){
                     return true;
                 }
            }
        }
        return false;
    }

    /**
     * Regresa el número de aristas que contiene el vértice. Si es 0, es nodo aislado.
     * @return Regresa el número de aristas.
     */
    public Integer gradoVertice(Object vertice){
        int indiceVertice = (int) vertices.buscar(vertice);
        if(indiceVertice > -1){
            int sumatoria = 0;
            for(int cadaCol = 0; cadaCol < vertices.getMAXIMO(); cadaCol++){
                if((double) aristas.obtener(indiceVertice, cadaCol) > 0){
                    sumatoria++;
                }
            }
            return sumatoria;
        } else {
            return null;
        }
    }

    /**
     * Determinar si existe un camino válido entre dos vértices proporcionados como argumentos.
     * @param origen Vértice origen.
     * @param destino Vértice destino.
     * @return Regresa <b>true</b> si se pudo alcanzar el destino y <b>false</b> si no.
     */
    public boolean hayRuta(Object origen, Object destino){
        ListaDinamica ruta = rutaOptima(origen, destino);
        if((int) Comparador.comparar(origen, ruta.getPrimero()) == 0
                && (int) Comparador.comparar(destino, ruta.verUltimo()) == 0){
            return true;
        } else {
            return false;
        }
    }

    /**
     * Es conexo si desde cualquier vértice existe un camino hasta cualquier otro vértice del grafo.
     * @return Regresa <b>true</b> si es conexo o <b>false</b> si no.
     */
    public boolean esConexo(){
        for(int cadaReng = 0; cadaReng <= vertices.getTope(); cadaReng++){
            for(int cadaCol = 0; cadaCol <= vertices.getTope(); cadaCol++){
                if(cadaReng != cadaCol){
                    double arista = (double) aristas.obtener(cadaReng, cadaCol);
                    if(arista == 0.0){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    /**
     * Determina si el grafo tiene ciclos e indica si el primero y último vértice son iguales en un camino o ruta definido.
     * @param origen Vértice origen del grafo.
     * @return Regresa <b>true</b> si tiene hay caminos cerrados o <b>false</b> si no.
     */
    public boolean hayCaminoCerrado(Object origen){
        //todo
        return false;
    }

    /**
     * Indica si el camino es simple, es decir, si todos sus nodos son distintos, excepto el primero y último, que pueden ser iguales.
     * @param origen Vértice origen del grafo.
     * @param destino Vértice destino del grafo.
     * @return Regresa <b>true</b> si es camino simple o <b>false</b> si no.
     */
    public boolean esCaminoSimple(Object origen, Object destino){
        //todo
        return false;
    }

    /**
     * Este método indica si el grafo es dirigido o no dirigido. Las aristas (x,y) y (y,x) no son equivalentes es grafo dirigido.
     * @return Regresa <b>true</b> si es dirigido o <b>false</b> si no.
     */
    public boolean esDirigido(){
        for(int cadaReng = 0; cadaReng < vertices.getMAXIMO(); cadaReng++){
            for(int cadaCol = 0; cadaCol < vertices.getMAXIMO(); cadaCol++){
                double peso = (double) aristas.obtener(cadaReng, cadaCol);
                double pesoInverso = (double) aristas.obtener(cadaCol, cadaReng);
                if(peso > 0){
                    if(peso == pesoInverso){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    /**
     * Se dice que un grafo no dirigido es un árbol si es conexo, acíclico y donde cada vértice solo debe tener un padre.
     * @return Regresa <b>true</b> si es árbol o <b>false</b> si no.
     */
    public boolean esArbol(){
        //todo
        return false;
    }

    /**
     * Muestra en el formato (origen, destino, peso), un listado de todas las aristas que tiene un grafo.
     */
    public ListaDinamica listarAristas(){
        ListaDinamica lista = new ListaDinamica();
        for(int cadaReng = 0; cadaReng < vertices.getMAXIMO(); cadaReng++){
            Object origen = vertices.obtener(cadaReng);
            for(int cadaCol = 0; cadaCol < vertices.getMAXIMO(); cadaCol++){
                Object destino = vertices.obtener(cadaCol);
                double peso = (double) aristas.obtener(cadaReng, cadaCol);
                if(peso > 0.0){
                    lista.agregar("[" + origen + "," + destino + "," + peso + "]");
                }
            }
        }
        return lista;
    }

    /**
     * Lista las aristas del vértice proporcionado.
     * @param vertice Vértice del cual se mostraran las aristas.
     */
    public ListaDinamica listarAristas(Object vertice){
        int indiceVertice = (int) vertices.buscar(vertice);
        ListaDinamica lista = new ListaDinamica();

        for(int cadaCol = 0; cadaCol < vertices.getMAXIMO(); cadaCol++){
            Object verticeDestino = vertices.obtener(cadaCol);
            double peso = (double) aristas.obtener(indiceVertice, cadaCol);
            if(peso > 0){
                lista.agregar("[" + vertice + "," + verticeDestino + "," + peso + "]");
            }
        }
        return lista;
    }

    /**
     * Muestra los vértices del grafo.
     */
    public void listarVertices(){
        vertices.imprimir();
    }
}
