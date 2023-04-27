package estructurasNoLineales;

import entradasalida.SalidaPorDefecto;
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

        int indiceOrigen = (int) vertices.buscar(origen);
        if(indiceOrigen == -1){
            return null;
        }
        pila.poner(indiceOrigen);
        marcados.rellenar(false, marcados.cantidad());

        // 2. Mientras la pila no este vacia, sacar un elemento y procesarlo
        while (!pila.vacia()){
            int indiceVertAct = (int) pila.quitar();
            Vertice verticeActual = (Vertice) vertices.obtener(indiceVertAct);
            recorrido.agregar(verticeActual.getInfo());

            // 3. Los vertices adyacentes a este vertices sacado, mientras no esten marcados, ponerlos en la pila y marcarlos
            
        }
        return recorrido;
    }
}
