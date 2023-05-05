package pruebas;

import entradasalida.SalidaPorDefecto;
import estructurasNoLineales.ArbolBinario;
import estructurasNoLineales.ArbolBinarioBusqueda;

public class PruebaAB {
    public static void main(String[] args) {
        ArbolBinarioBusqueda arbol = new ArbolBinarioBusqueda();

        arbol.agregar(20);
        arbol.agregar(10);
        arbol.agregar(23);
        arbol.agregar(7);
        arbol.agregar(9);
        arbol.agregar(4);

        arbol.recorridoAmplitud();
        SalidaPorDefecto.terminal("\n");
        arbol.innorden();
    }
}
