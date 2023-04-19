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


        Matriz2 matriz = new Matriz2(3, 2);

        matriz.cambiar(0,0, 4);
        matriz.cambiar(0,1, "sisisi");
        matriz.cambiar(1,0, 5);
        matriz.cambiar(1,1, "nonono");
        matriz.cambiar(2,0, 2);
        matriz.cambiar(2,1, "jajajaj");

        matriz.imprimirPorColumna();
        SalidaPorDefecto.terminal("\n");
        ldc.agregarMatriz2(matriz);
        ldc.imprimir();
    }
}
