package pruebas;

import entradasalida.SalidaPorDefecto;
import estructurasNoLineales.ArbolBinario;

public class PruebaAB {
    public static void main(String[] args) {
        ArbolBinario arbol = new ArbolBinario();

        arbol.crearArbol();

        arbol.posorden();
        SalidaPorDefecto.terminal("\n");
        arbol.postordenSinRecursion();
    }
}
