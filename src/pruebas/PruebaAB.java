package pruebas;

import entradasalida.SalidaPorDefecto;
import estructurasNoLineales.ArbolBinario;

public class PruebaAB {
    public static void main(String[] args) {
        ArbolBinario arbol = new ArbolBinario();

        arbol.crearArbol();

//        SalidaPorDefecto.terminal("Innorden\n");
//        arbol.innorden();
//        SalidaPorDefecto.terminal("\nPostorden\n");
        arbol.posorden();
//        SalidaPorDefecto.terminal("\nPreorden\n");
//        arbol.preorden();

//        arbol.recorridoAmplitud();
//        SalidaPorDefecto.terminal("\n");
//        arbol.recorridoAmplitudPila();

        SalidaPorDefecto.terminal("\n");
        arbol.postordenSinRecursion();
    }
}
