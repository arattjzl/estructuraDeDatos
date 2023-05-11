package pruebas;

import entradasalida.SalidaPorDefecto;
import estructurasNoLineales.BusquedaTablasDatos;

import java.io.IOException;

public class PruebaBusquedaTablasDatos {
    public static void main(String[] args) throws IOException {
        BusquedaTablasDatos arbol = new BusquedaTablasDatos();
        arbol.abrirArchivoArbol1("C:\\Users\\aratt\\workspace\\escuela\\datos_ordenes\\product_information.txt", 0);
        arbol.primerArbolInnorden();
        SalidaPorDefecto.terminal("\n\n");

        arbol.abrirArchivoArbol2("C:\\Users\\aratt\\workspace\\escuela\\datos_ordenes\\categories_tab.txt", 3,2);
        arbol.segundoArbolInnorden();
    }
}
