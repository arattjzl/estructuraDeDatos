package pruebas;

import entradasalida.SalidaPorDefecto;
import estructurasNoLineales.GrafoEstatico;

public class PruebaGrafoEst {
    public static void main(String[] args) {
        GrafoEstatico grafo = new GrafoEstatico(3,0.0);

        grafo.agregarVertice("A");
        grafo.agregarVertice("B");
        grafo.agregarVertice("C");

        grafo.agregarArista("A","B");
        grafo.agregarArista("B","C");
        grafo.agregarArista("B","A");
        grafo.agregarArista("C","B");
        grafo.agregarArista("C","A");

        //grafo.imprimir();
        SalidaPorDefecto.terminal("\n");
        grafo.listarVertices();
    }
}
