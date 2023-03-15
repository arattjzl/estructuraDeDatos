package pruebas;

import entradasalida.SalidaPorDefecto;
import estructurasLineales.ColaEstaticaPrioridad;
import utils.commons.TipoPrioridad;

public class PruebaColaPrioridad {
    public static void main(String[] args) {
        ColaEstaticaPrioridad cola = new ColaEstaticaPrioridad(5, TipoPrioridad.MENOR_MAYOR);
        cola.agregar("?", 10);
        cola.agregar("hola", 1);
        cola.agregar("estas", 3);
        cola.agregar("como", 2);
        cola.agregar("!", 6);

        cola.imprimir();
        cola.quitar();
        SalidaPorDefecto.terminal("\n");
        cola.imprimir();
        cola.quitar();
        SalidaPorDefecto.terminal("\n");
        cola.imprimir();
    }
}
