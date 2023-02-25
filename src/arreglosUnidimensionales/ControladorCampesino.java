package arreglosUnidimensionales;

import entradasalida.EntradaPorDefecto;
import entradasalida.SalidaPorDefecto;
import estructurasLineales.ListaEstatica;

public class ControladorCampesino {


    public static void main(String[] args) {
        String opcionesMenu = """
                a. Promedio anual de toneladas\s
                b. Meses con toneladas mayores al promedio\s
                c. Mes con menos toneladas de cada año\s
                d. Toneladas obtenidas el último mes de los años\s
                e. Toneladas obtenidas el segundo trimestre de cada año\s
                f. Campesino con peores años\s
                g. Mes con mayores dividendos a los campesino
                h. Época del año que genera mayor ganancia\s
                q. Salir\s""";

        String opcionesCampesino= """
                a. Campesino 1\s
                b. Campesino 2\s""";

        String opcionesAnio = """
                a. Año 1\s
                b. Año 2\s
                c. Año 3\s
                d. Año 4\s""";

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
        Campesino campesino2 = new Campesino("Patricio", anio5, anio6, anio7, anio8);

        EmpresaCampesinos empresa = new EmpresaCampesinos(campesino1, campesino2);

        SalidaPorDefecto.terminal(opcionesMenu);
        String opcion = "";
        do{
            opcion = EntradaPorDefecto.consolaCadenas();
            switch (opcion){
                case "a":
                    SalidaPorDefecto.terminal("El promedio es de: " + campesino1.obtenerPromedioAnio(anio1));
                    break;
                case "b":
                    SalidaPorDefecto.terminal("Los meses con toneladas mayores al promedio anual son: " + campesino2.mayoresPromedioAnual(anio7));
                    break;
                case "c":
                    SalidaPorDefecto.terminal("Mes con menos toneladas de cada año: \n");
                    campesino1.menosToneladas().imprimirOI();
                    break;
                case "d":
                    SalidaPorDefecto.terminal("Las toneladas del ultimo mes de cada año son: \n");
                    campesino2.tonUltMes().imprimirOI();
                    break;
                case "e":
                    SalidaPorDefecto.terminal("Las toneladas del segundo trimestre de cada año son: \n");
                    campesino1.tonTrimestresAnios().imprimirOI();
                    break;
                case "f":
                    SalidaPorDefecto.terminal("Los peores años fueron para: \n");
                    empresa.peoresAnios(campesino1, campesino2).imprimirOI();
                    break;
                case "g":
                    SalidaPorDefecto.terminal("El mes que produce mayores dividendos es: " + empresa.mayorDividendo());
                    break;
                case "h":
                    SalidaPorDefecto.terminal("La epoca del año que genera mayor ganancia es: " + empresa.mayorGanancia(campesino1.getAnio1(), campesino2.getAnio1()));
                    break;
            }

        } while(!opcion.equals("q"));
    }
}
