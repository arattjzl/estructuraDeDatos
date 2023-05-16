package pruebas;

import estructurasNoLineales.GrafoDinamico;

public class PruebGrafoDinamico {
    public static void main(String[] args) {
        GrafoDinamico grafo = new GrafoDinamico();

        grafo.agregarVertice("A");
        grafo.agregarVertice("B");
        grafo.agregarVertice("C");
        grafo.agregarVertice("D");
        grafo.agregarVertice("E");

        grafo.agregarArista("A", "B",1);
        grafo.agregarArista("A", "C",3);

        grafo.agregarArista("B", "A",1);
        grafo.agregarArista("B", "C",4);
        grafo.agregarArista("B", "D",6);

        grafo.agregarArista("C", "A",3);
        grafo.agregarArista("C", "B",4);
        grafo.agregarArista("C", "D",4);
        grafo.agregarArista("C", "E",2);

        grafo.agregarArista("D", "B",6);
        grafo.agregarArista("D", "C",4);
        grafo.agregarArista("D", "E",5);

        grafo.agregarArista("E", "C",2);
        grafo.agregarArista("E", "D",5);

        grafo.imprimir();

        grafo.recorridoProfundidad("A").imprimir();
    }
}
