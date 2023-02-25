package arreglosUnidimensionales;

import estructurasLineales.ListaEstatica;

public class EmpresaCampesinos implements IEmpresaCampesinos{

    protected Campesino campesino1;
    protected Campesino campesino2;

    public EmpresaCampesinos(Campesino campesino1, Campesino campesino2){
        this.campesino1 = campesino1;
        this.campesino2 = campesino2;
    }
    @Override
    public ListaEstatica peoresAnios(Campesino campesino1, Campesino campesino2) {
        ListaEstatica peores = new ListaEstatica(4);
        if(campesino1.obtenerPromedioAnio(campesino1.getAnio1()) > campesino2.obtenerPromedioAnio(campesino2.getAnio1())){
            peores.agregar(campesino2.getNombre());
        }else{
            peores.agregar(campesino1.getNombre());
        }
        if(campesino1.obtenerPromedioAnio(campesino1.getAnio2()) > campesino2.obtenerPromedioAnio(campesino2.getAnio2())){
            peores.agregar(campesino2.getNombre());
        }else{
            peores.agregar(campesino1.getNombre());
        }
        if(campesino1.obtenerPromedioAnio(campesino1.getAnio3()) > campesino2.obtenerPromedioAnio(campesino2.getAnio3())){
            peores.agregar(campesino2.getNombre());
        }else{
            peores.agregar(campesino1.getNombre());
        }
        if(campesino1.obtenerPromedioAnio(campesino1.getAnio4()) > campesino2.obtenerPromedioAnio(campesino2.getAnio4())){
            peores.agregar(campesino2.getNombre());
        }else{
            peores.agregar(campesino1.getNombre());
        }
        return peores;
    }

    @Override
    public double gananciaLimites(int inferior, int superior, ListaEstatica listaEstatica1, ListaEstatica listaEstatica2) {
        double ganancia = 0.0;
        for(int mes = inferior; mes <= superior; mes++){
            ganancia += (double) listaEstatica1.obtener(mes);
            ganancia += (double) listaEstatica2.obtener(mes);
        }
        return ganancia;
    }

    @Override
    public double gananciaPrimavera(ListaEstatica listaEstatica, ListaEstatica listaEstatica2) {
        return gananciaLimites(3,5, listaEstatica, listaEstatica2);
    }

    @Override
    public double gananciaVerano(ListaEstatica listaEstatica, ListaEstatica listaEstatica2) {
        return gananciaLimites(6,8, listaEstatica, listaEstatica2);
    }

    @Override
    public double gananciaOtonio(ListaEstatica listaEstatica, ListaEstatica listaEstatica2) {
        return gananciaLimites(9,11, listaEstatica, listaEstatica2);
    }

    @Override
    public double gananciaInvierno(ListaEstatica listaEstatica, ListaEstatica listaEstatica2) {
        return gananciaLimites(0,2, listaEstatica, listaEstatica2);
    }

    @Override
    public String mayorGanancia(ListaEstatica listaEstatica, ListaEstatica listaEstatica2) {
        ListaEstatica estaciones = new ListaEstatica(4);
        double invierno = gananciaInvierno(listaEstatica, listaEstatica2);
        double otonio = gananciaOtonio(listaEstatica, listaEstatica2);
        double primavera = gananciaPrimavera(listaEstatica, listaEstatica2);
        double verano = gananciaVerano(listaEstatica, listaEstatica2);
        estaciones.agregar(invierno);
        estaciones.agregar(primavera);
        estaciones.agregar(verano);
        estaciones.agregar(otonio);
        double mayor = 0.0;
        for(int estacion = 0; estacion < estaciones.cantidad(); estacion++){
            if((double) estaciones.obtener(estacion)> mayor){
                mayor = (double) estaciones.obtener(estacion);
            }
        }
        int numEstacion = (int)estaciones.buscar(mayor);
        String estacionFinal = switch (numEstacion) {
            case 0 -> "Invierno";
            case 1 -> "Primavera";
            case 2 -> "Verano";
            case 3 -> "Otoño";
            default -> "";
        };
        return estacionFinal;
    }

    @Override
    public int mayorDividendo() {
        ListaEstatica dividendos = new ListaEstatica(12);
        for(int mes = 0; mes < 12; mes++){
            double dividendoMes = 0.0;
            dividendoMes += (double) campesino1.anio1.obtener(mes);
            dividendoMes += (double) campesino1.anio2.obtener(mes);
            dividendoMes += (double) campesino1.anio3.obtener(mes);
            dividendoMes += (double) campesino1.anio4.obtener(mes);
            dividendoMes += (double) campesino2.anio1.obtener(mes);
            dividendoMes += (double) campesino2.anio2.obtener(mes);
            dividendoMes += (double) campesino2.anio3.obtener(mes);
            dividendoMes += (double) campesino2.anio4.obtener(mes);
            dividendos.agregar(dividendoMes);
        }
        double dividendoMayor = 0;
        for(int mes = 0; mes <12; mes++){
            if((double) dividendos.obtener(mes) > dividendoMayor){
                dividendoMayor = (double)dividendos.obtener(mes);
            }
        }
        return (int) dividendos.buscar(dividendoMayor) + 1;
    }

}
