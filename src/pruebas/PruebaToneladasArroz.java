package pruebas;

import arreglosUnidimensionales.Campesino;
import arreglosUnidimensionales.EmpresaCampesinos;
import entradasalida.SalidaPorDefecto;
import estructurasLineales.ListaEstatica;

public class PruebaToneladasArroz {
    public static void main(String[] args) {


        ListaEstatica anio1 = new ListaEstatica(12);
        ListaEstatica anio2 = new ListaEstatica(12);
        ListaEstatica anio3 = new ListaEstatica(12);
        ListaEstatica anio4 = new ListaEstatica(12);

        anio1.agregar(872.3);
        anio1.agregar(784.8);
        anio1.agregar(345.2);
        anio1.agregar(342.4);
        anio1.agregar(234.1);
        anio1.agregar(123.24);
        anio1.agregar(678.2);
        anio1.agregar(890.4);
        anio1.agregar(893.2);
        anio1.agregar(872.3);
        anio1.agregar(894.2);
        anio1.agregar(674.1);

        anio2.agregar(856.2);
        anio2.agregar(789.2);
        anio2.agregar(345.2);
        anio2.agregar(893.2);
        anio2.agregar(234.1);
        anio2.agregar(123.24);
        anio2.agregar(734.1);
        anio2.agregar(673.1);
        anio2.agregar(674.6);
        anio2.agregar(872.3);
        anio2.agregar(980.3);
        anio2.agregar(653.3);

        anio3.agregar(784.2);
        anio3.agregar(443.2);
        anio3.agregar(546.3);
        anio3.agregar(763.2);
        anio3.agregar(123.2);
        anio3.agregar(564.2);
        anio3.agregar(783.9);
        anio3.agregar(674.2);
        anio3.agregar(893.5);
        anio3.agregar(456.3);
        anio3.agregar(645.3);
        anio3.agregar(234.5);

        anio4.agregar(673.2);
        anio4.agregar(783.3);
        anio4.agregar(645.3);
        anio4.agregar(674.2);
        anio4.agregar(564.3);
        anio4.agregar(743.3);
        anio4.agregar(894.2);
        anio4.agregar(893.2);
        anio4.agregar(234.0);
        anio4.agregar(124.2);
        anio4.agregar(231.2);
        anio4.agregar(733.6);

        Campesino campesino1 = new Campesino("Juan", anio1, anio2,anio3,anio4);

        ListaEstatica anio5 = new ListaEstatica(12);
        ListaEstatica anio6 = new ListaEstatica(12);
        ListaEstatica anio7 = new ListaEstatica(12);
        ListaEstatica anio8 = new ListaEstatica(12);

        anio5.agregar(389.9);
        anio5.agregar(457.9);
        anio5.agregar(745.3);
        anio5.agregar(674.2);
        anio5.agregar(674.2);
        anio5.agregar(983.1);
        anio5.agregar(892.3);
        anio5.agregar(456.4);
        anio5.agregar(890.2);
        anio5.agregar(124.2);
        anio5.agregar(788.0);
        anio5.agregar(733.6);

        anio6.agregar(892.2);
        anio6.agregar(12.4);
        anio6.agregar(367.2);
        anio6.agregar(34.2);
        anio6.agregar(564.3);
        anio6.agregar(235.2);
        anio6.agregar(893.1);
        anio6.agregar(1200.3);
        anio6.agregar(672.2);
        anio6.agregar(124.2);
        anio6.agregar(782.1);
        anio6.agregar(80.2);

        anio7.agregar(783.2);
        anio7.agregar(734.3);
        anio7.agregar(783.2);
        anio7.agregar(673.2);
        anio7.agregar(73.4);
        anio7.agregar(783.2);
        anio7.agregar(653.2);
        anio7.agregar(34.5);
        anio7.agregar(1300.2);
        anio7.agregar(278.4);
        anio7.agregar(231.2);
        anio7.agregar(782.4);

        anio8.agregar(673.5);
        anio8.agregar(0.0);
        anio8.agregar(892.3);
        anio8.agregar(645.3);
        anio8.agregar(634.2);
        anio8.agregar(634.5);
        anio8.agregar(673.4);
        anio8.agregar(289.5);
        anio8.agregar(892.2);
        anio8.agregar(734.2);
        anio8.agregar(762.4);
        anio8.agregar(450.2);

        Campesino campesino2 = new Campesino("Patricio", anio5, anio6,anio7,anio8);

        EmpresaCampesinos empresa = new EmpresaCampesinos(campesino1, campesino2);

        empresa.peoresAnios(campesino1,campesino2).imprimirOI();

    }


}
