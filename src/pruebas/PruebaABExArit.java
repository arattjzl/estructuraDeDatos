package pruebas;

import entradasalida.SalidaPorDefecto;
import estructurasNoLineales.ArbolExArit;

public class PruebaABExArit {
    public static void main(String[] args) {
        ArbolExArit arbol = new ArbolExArit();

        arbol.crearArbolPrefija("-+ab/*53^42");

        SalidaPorDefecto.terminal("Recorridos:\nInnorden:\n");
        arbol.innorden();
        SalidaPorDefecto.terminal("\nPreorden:\n");
        arbol.preorden();
        SalidaPorDefecto.terminal("\nPostorden:\n");
        arbol.posorden();
    }
}
