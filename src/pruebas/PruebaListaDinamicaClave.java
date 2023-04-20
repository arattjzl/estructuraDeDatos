package pruebas;

import entradasalida.SalidaPorDefecto;
import estructurasLineales.ListaDinamica;
import estructurasLineales.ListaDinamicaClave;
import estructurasLineales.ListaDinamicaOrdenada;
import estructurasLineales.ListaEstatica;
import estructurasLineales.auxiliares.Nodo;
import estructurasNoLineales.Matriz2;

public class PruebaListaDinamicaClave {
    public static void main(String[] args) {
        ListaDinamicaClave ldc = new ListaDinamicaClave();

        ldc.agregar(1, "hola");
        ldc.agregar(2, "adios");
        ldc.agregar(3, "como estas");
        ldc.agregar(4, "999");

        ldc.aMatriz2().imprimirPorColumna();
    }
}
