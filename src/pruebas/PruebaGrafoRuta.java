package pruebas;

import estructurasNoLineales.GrafoEstatico;
import utils.commons.TipoOrden;

public class PruebaGrafoRuta {
    public static void main(String[] args) {
        GrafoEstatico grafo = new GrafoEstatico(8, TipoOrden.DEC);

        grafo.agregarVertice("A");
        grafo.agregarVertice("B");
        grafo.agregarVertice("C");
        grafo.agregarVertice("D");
        grafo.agregarVertice("E");
        grafo.agregarVertice("F");
        grafo.agregarVertice("H");
        grafo.agregarVertice("M");

        grafo.agregarArista("A", "B",3.0);
        grafo.agregarArista("B", "A",3.0);

        grafo.agregarArista("A", "C",5.0);
        grafo.agregarArista("C", "A",5.0);

        grafo.agregarArista("C", "E",8.0);
        grafo.agregarArista("E", "C",8.0);

        grafo.agregarArista("B", "E",1.0);
        grafo.agregarArista("E", "B",1.0);

        grafo.agregarArista("C", "D",6.0);
        grafo.agregarArista("D", "C",6.0);

        grafo.agregarArista("E", "F",7.0);
        grafo.agregarArista("F", "E",7.0);

        grafo.agregarArista("B", "H",4.0);
        grafo.agregarArista("H", "B",4.0);

        grafo.agregarArista("H", "F",6.0);
        grafo.agregarArista("F", "H",6.0);

        grafo.agregarArista("F", "D",2.0);
        grafo.agregarArista("D", "F",2.0);

        grafo.agregarArista("D", "M",6.0);
        grafo.agregarArista("M", "D",6.0);

        grafo.agregarArista("M", "H",9.0);
        grafo.agregarArista("H", "M",9.0);

        grafo.imprimir();
        grafo.rutaMasCortaDijkstra("A");
    }
}
