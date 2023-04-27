package pruebas;

import estructurasNoLineales.GrafoEstatico;

public class PruebaGrafoEst {
    public static void main(String[] args) {
        GrafoEstatico grafo = new GrafoEstatico(4,0.0);

        grafo.agregarVertice("A");
        grafo.agregarVertice("B");
        grafo.agregarVertice("C");
        grafo.agregarVertice("D");

        grafo.agregarArista("A","B");
        grafo.agregarArista("A","C");
        grafo.agregarArista("B","A");
        grafo.agregarArista("B","C");
        grafo.agregarArista("B","D");
        grafo.agregarArista("D","B");
        grafo.agregarArista("D","C");

        grafo.imprimir();
    }
}
