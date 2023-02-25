package arreglosUnidimensionales;

import estructurasLineales.ListaEstatica;

/**
 * Esta clase contiene los métodos para hacer conparaciones entre dos campesinos
 * @author Aratt
 * @version 1.0
 */
public interface IEmpresaCampesinos {

    /**
     * Compara dos campesinos para ver quien de los dos realizo el peor trabajo en el año.
     * @param campesino1 Es el primer campesino a comparar.
     * @param campesino2 Es el segundo campesino a comparar.
     * @return Regresa una lista con los nombres de los campesinos que realizaron el peor trabajo del año.
     */
    public ListaEstatica peoresAnios(Campesino campesino1, Campesino campesino2);

    /**
     * Obtiene las ganancias dentro de los límites que se le pongan en cierto año.
     * @param inferior Limite inferior para buscar.
     * @param superior Limite mayor para buscar.
     * @param listaEstatica La lista del año del primer campesino.
     * @param listaEstatica2 La lista del año del segundo campesino.
     * @return Regresa las toneladas que se generan en esos límites.
     */
    public double gananciaLimites(int inferior, int superior, ListaEstatica listaEstatica, ListaEstatica listaEstatica2);

    /**
     * Obtiene las ganancias de la primavera.
     * @param listaEstatica Es la lista del año del primer campesino.
     * @param listaEstatica2 Es la lista del año del segundo campesino.
     * @return Regresa las toneladas de la primavera.
     */
    public double gananciaPrimavera(ListaEstatica listaEstatica, ListaEstatica listaEstatica2);
    /**
     * Obtiene las ganancias del verano.
     * @param listaEstatica Es la lista del año del primer campesino.
     * @param listaEstatica2 Es la lista del año del segundo campesino.
     * @return Regresa las toneladas del verano.
     */
    public double gananciaVerano(ListaEstatica listaEstatica, ListaEstatica listaEstatica2);

    /**
     * Obtiene las ganancias del otoño.
     * @param listaEstatica Es la lista del año del primer campesino.
     * @param listaEstatica2 Es la lista del año del segundo campesino.
     * @return Regresa las toneladas del otoño.
     */
    public double gananciaOtonio(ListaEstatica listaEstatica, ListaEstatica listaEstatica2);

    /**
     * Obtiene las ganancias del invierno.
     * @param listaEstatica Es la lista del año del primer campesino.
     * @param listaEstatica2 Es la lista del año del segundo campesino.
     * @return Regresa las toneladas del invierno.
     */
    public double gananciaInvierno(ListaEstatica listaEstatica, ListaEstatica listaEstatica2);

    /**
     * Obtiene la mayor ganancia de todas las estaciones.
     * @param listaEstatica Es la lista del año del primer campesino.
     * @param listaEstatica2 Es la lista del año del segundo campesino.
     * @return Regresa la estación con más toneladas.
     */
    public String mayorGanancia(ListaEstatica listaEstatica, ListaEstatica listaEstatica2);
    public int mayorDividendo();
}
