package pruebas;

import entradasalida.SalidaPorDefecto;
import estructurasLineales.ListaEstaticaNumerica;
import estructurasNoLineales.Matriz2Numerica;
import utils.commons.TipoLogaritmo;

public class PruebaMatriz2Numerica {
    public static void main(String[] args) {
        Matriz2Numerica matriz = new Matriz2Numerica(5,4);

        matriz.cambiar(0,0,4);
        matriz.cambiar(0,1,6);
        matriz.cambiar(0,2,4);
        matriz.cambiar(0,3,3);
        matriz.cambiar(1,0,1);
        matriz.cambiar(1,1,2);
        matriz.cambiar(1,2,2);
        matriz.cambiar(1,3,4);
        matriz.cambiar(2,0,5);
        matriz.cambiar(2,1,3);
        matriz.cambiar(2,2,2);
        matriz.cambiar(2,3,1);
        matriz.cambiar(3,0,0);
        matriz.cambiar(3,1,8);
        matriz.cambiar(3,2,7);
        matriz.cambiar(3,3,3);
        matriz.cambiar(4,0,6);
        matriz.cambiar(4,1,4);
        matriz.cambiar(4,2,2);
        matriz.cambiar(4,3,1);


        matriz.imprimirPorColumna();
        SalidaPorDefecto.terminal("\n");
        matriz.transpuesta();
        matriz.imprimirPorColumna();
    }
}
