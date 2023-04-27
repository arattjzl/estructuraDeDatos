package pruebas;

import entradasalida.SalidaPorDefecto;
import estructurasNoLineales.ArbolBinarioBusqueda;

public class PruebABB {
    public static void main(String[] args) {
        ArbolBinarioBusqueda arbol = new ArbolBinarioBusqueda();


        arbol.agregar(5);
        arbol.agregar(11);
        arbol.agregar(4);
        arbol.agregar(9);
        arbol.agregar(10);
        arbol.agregar(3);
        arbol.agregar(2);
        arbol.agregar(1);

        arbol.innorden();

        arbol.eliminar(10);

        SalidaPorDefecto.terminal("--------------\n");
        arbol.innorden();
    }
}
