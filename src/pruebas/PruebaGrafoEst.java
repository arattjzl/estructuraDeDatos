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
        grafo.agregarArista("A","C");
        grafo.agregarArista("B","A");
        grafo.agregarArista("C","A");

        SalidaPorDefecto.terminal("\n");
        //grafo.imprimir();
        SalidaPorDefecto.terminal(grafo.buscarVertice("C")
                + " - " + grafo.buscarVertice("E"));
    }
}
