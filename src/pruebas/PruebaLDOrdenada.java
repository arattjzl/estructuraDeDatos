package pruebas;

import entradasalida.SalidaPorDefecto;
import estructurasLineales.ListaDinamica;
import estructurasLineales.ListaDinamicaOrdenada;
import estructurasLineales.ListaEstatica;
import estructurasLineales.ListaEstaticaNumerica;
import estructurasNoLineales.Matriz2;
import utils.commons.TipoOrden;

public class PruebaLDOrdenada {
    public static void main(String[] args) {
        ListaDinamicaOrdenada lista = new ListaDinamicaOrdenada(TipoOrden.INC);
        Matriz2 matriz = new Matriz2(2,2);

        lista.agregar(1);
        lista.agregar(7);
        lista.agregar(5);
        lista.agregar(3);
        lista.agregar(9);

        matriz.cambiar(0,0,1);
        matriz.cambiar(0,1,3);
        matriz.cambiar(1,0,7);
        matriz.cambiar(1,1,9);

        lista.imprimir();
        SalidaPorDefecto.terminal("\n");
        matriz.imprimirPorColumna();
        lista.eliminarMatriz(matriz);
        lista.imprimir();
    }
}
