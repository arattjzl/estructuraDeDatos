package pruebas;

import entradasalida.SalidaPorDefecto;
import estructurasLineales.Conjunto;
import estructurasLineales.ListaDinamica;
import estructurasLineales.ListaEstatica;
import utils.commons.TipoCopia;

public class PruebaConjunto {
    public static void main(String[] args) {
        ListaDinamica lista = new ListaDinamica();
        lista.agregar(2);
        lista.agregar(3);
        lista.agregar(7);
        lista.agregar(1);

        ListaDinamica nuevaLista = new ListaDinamica();
        nuevaLista.agregar(5);
        nuevaLista.agregar(1);
        nuevaLista.agregar(7);
        nuevaLista.agregar(8);

        ListaEstatica listaEstatica = new ListaEstatica(4);
        listaEstatica.agregar(5);
        listaEstatica.agregar(1);
        listaEstatica.agregar(9);
        listaEstatica.agregar(8);

        Conjunto conjunto = new Conjunto(lista);
        Conjunto nuevoConj = new Conjunto(nuevaLista);
        conjunto.copiar(1,2, TipoCopia.PRINCIPIO, nuevoConj);
        nuevoConj.imprimir();
    }
}
