package estructurasNoLineales;

import entradasalida.SalidaPorDefecto;
import estructurasLineales.ColaEstatica;
import estructurasLineales.ListaDinamica;
import estructurasLineales.ListaEstatica;
import estructurasLineales.PilaEstatica;
import estructurasNoLineales.auxiliares.Vertice;

public class GrafoEstatico {
    protected Matriz2 aristas;
    protected ListaEstatica vertices;

    public GrafoEstatico(int numVertices){
        aristas = new Matriz2(numVertices,numVertices);
        vertices = new ListaEstatica(numVertices);
    }

    public GrafoEstatico(int numVeces, Object inicializador){
        aristas = new Matriz2(numVeces,numVeces,inicializador);
        vertices = new ListaEstatica(numVeces);
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
            // Paso 4. Recalcular incidencias con base al paso 3
            // Paso 5. Meter en la cola los vertices con incidencias en 0, y que no esten marcados, después meterlos
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
}
