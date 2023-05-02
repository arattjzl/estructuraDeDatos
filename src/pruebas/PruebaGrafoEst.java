package pruebas;

import entradasalida.SalidaPorDefecto;
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

        GrafoEstatico nuevografo = new GrafoEstatico(5,0.0);

        nuevografo.agregarVertice("A");
        nuevografo.agregarVertice("B");
        nuevografo.agregarVertice("C");
        nuevografo.agregarVertice("D");
        nuevografo.agregarVertice("E");

        nuevografo.agregarArista("A", "B");
        nuevografo.agregarArista("B", "C");
        nuevografo.agregarArista("B", "D");
        nuevografo.agregarArista("C", "A");
        nuevografo.agregarArista("D", "c");
        nuevografo.agregarArista("D", "E");
        nuevografo.agregarArista("D", "A");
        nuevografo.agregarArista("E", "C");

        nuevografo.imprimir();
        nuevografo.recorridoProfundidad("A").imprimir();
        SalidaPorDefecto.terminal("\n");
        nuevografo.recorridoAnchura("A").imprimir();

    }
}
