package pruebas;

import entradasalida.SalidaPorDefecto;
import estructurasLineales.ListaEstatica;
import estructurasNoLineales.Matriz2;
import utils.commons.TipoColumna;
import utils.commons.TipoRenglon;

public class PruebaMatriz2 {
    public static void main(String[] args) {
        Matriz2 matriz = new Matriz2(3,3, 0);
        Matriz2 matriz2 = new Matriz2(3,3, 1);

        matriz.cambiar(0,2,90);
        matriz.cambiar(1,2,999);
        matriz.cambiar(2,2,777);

        matriz.imprimirPorColumna();
        matriz.transpuesta();
        matriz.imprimirPorColumna();
    }
}
