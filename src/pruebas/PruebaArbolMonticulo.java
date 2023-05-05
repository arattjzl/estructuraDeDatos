package pruebas;

import entradasalida.SalidaPorDefecto;
import estructurasNoLineales.Monticulo;
import utils.commons.TipoOrden;

public class PruebaArbolMonticulo {
    public static void main(String[] args) {
        Monticulo monticulo = new Monticulo(TipoOrden.INC);

        monticulo.agregar(18);
        monticulo.agregar(20);
        monticulo.agregar(9);
        monticulo.agregar(8);
        monticulo.agregar(10);
        monticulo.agregar(12);

        monticulo.recorridoAmplitud();
        SalidaPorDefecto.terminal("\n");
        monticulo.eliminar();
        monticulo.recorridoAmplitud();
    }
}
