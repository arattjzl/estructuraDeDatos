package pruebas;

import entradasalida.SalidaPorDefecto;
import estructurasNoLineales.ArbolBinarioMonticulo;
import utils.commons.TipoOrden;

public class PruebaArbolMonticulo {
    public static void main(String[] args) {
        ArbolBinarioMonticulo monticulo = new ArbolBinarioMonticulo(TipoOrden.INC);

        monticulo.agregar(18);
        monticulo.agregar(20);
        monticulo.agregar(9);
        monticulo.agregar(19);
        monticulo.agregar(8);
//        monticulo.agregar(10);
//        monticulo.agregar(12);


    }
}
