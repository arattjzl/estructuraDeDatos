package pruebas;

import estructurasNoLineales.ArbolBinarioMonticulo;
import utils.commons.TipoOrden;

public class PruebaArbolMonticulo {
    public static void main(String[] args) {
        ArbolBinarioMonticulo monticulo = new ArbolBinarioMonticulo(TipoOrden.INC);

        monticulo.agregar("A");
        monticulo.agregar("B");
        monticulo.agregar("C");
        monticulo.agregar("D");
        monticulo.agregar("E");
        monticulo.agregar("F");

        monticulo.recorridoAmplitud();
        monticulo.innorden();
    }
}
