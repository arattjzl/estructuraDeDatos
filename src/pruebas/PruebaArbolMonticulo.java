package pruebas;

import entradasalida.SalidaPorDefecto;
import estructurasNoLineales.ArbolBinarioMonticulo;
import utils.commons.TipoOrden;

public class PruebaArbolMonticulo {
    public static void main(String[] args) {
        ArbolBinarioMonticulo monticulo = new ArbolBinarioMonticulo(TipoOrden.INC);


        monticulo.agregar(20);
        monticulo.agregar(18);
        monticulo.agregar(9);
        monticulo.agregar(8);
        monticulo.agregar(10);
        monticulo.agregar(12);

        monticulo.recorridoAmplitud();
        SalidaPorDefecto.terminal("\n");

        ArbolBinarioMonticulo otro = new ArbolBinarioMonticulo(TipoOrden.DEC);


        otro.agregar(20);
        otro.agregar(18);
        otro.agregar(9);
        otro.agregar(8);
        otro.agregar(10);
        otro.agregar(12);

        otro.recorridoAmplitud();
    }
}
