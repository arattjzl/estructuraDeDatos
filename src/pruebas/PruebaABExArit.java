package pruebas;

import entradasalida.SalidaPorDefecto;
import estructurasNoLineales.ArbolExArit;

public class PruebaABExArit {
    public static void main(String[] args) {
        ArbolExArit arbol = new ArbolExArit();

        arbol.crearArbol();
        arbol.innorden();
        arbol.aListas();

    }
}
