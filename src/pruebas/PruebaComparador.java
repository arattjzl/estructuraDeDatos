package pruebas;

import arreglosUnidimensionales.Campesino;
import entradasalida.SalidaPorDefecto;
import registros.empresas.Empleado;
import utils.commons.Comparador;

public class PruebaComparador {
    public static void main(String[] args) {
        Empleado em1 = new Empleado(101,"Aratt",20);
        Empleado em2 = new Empleado(201,"Diego",19);
        SalidaPorDefecto.terminal(Comparador.comparar(em1, em2) + "\n");
        SalidaPorDefecto.terminal(Comparador.comparar("a", "z") + "\n");
        SalidaPorDefecto.terminal(Comparador.comparar("a", 2) + "\n");
        SalidaPorDefecto.terminal(Comparador.comparar("c", "a") + "\n");
        SalidaPorDefecto.terminal(Comparador.comparar("a", "a") + "\n");
        SalidaPorDefecto.terminal(Comparador.comparar(4,5) + "\n");
        SalidaPorDefecto.terminal(Comparador.comparar(5,5) + "\n");
    }
}
