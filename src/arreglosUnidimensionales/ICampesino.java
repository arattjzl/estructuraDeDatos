package arreglosUnidimensionales;

import estructurasLineales.ListaEstatica;

/**
 * Esta clase contiene los métodos necesarios para poder realizar las operaciones para
 */
public interface ICampesino {

    /**
     * Genera el promedio de toneladas recolectadas ese año.
     * @param listaEstatica Recibe una lista que es el año que se quiere obtener el promedio.
     * @return Regresa un double que es el promedio de toneladas.
     */
    public double obtenerPromedioAnio(ListaEstatica listaEstatica);

    /**
     * Obtenemos cuantos meses tuvieron toneladas mayores al promedio del año.
     * @param listaEstatica Recibe una lista que hace referencia a las toneladas de todo el año.
     * @return Regresa un entero que son los meses con toneladas mayores al promedio.
     */
    public int mayoresPromedioAnual(ListaEstatica listaEstatica);

    /**
     * Obtenemos el índice del mes con menos toneladas obtenidas del año.
     * @param listaEstatica Recibe una lista que hace referencia a las toneladas de todo el año.
     * @return Regresa un entero que hace referencia al índice de la lista.
     */
    public int elMenor(ListaEstatica listaEstatica);

    /**
     * Obtenemos todos los índices de los meses con menos toneladas de todos los años.
     * @return Regresa una lista con los índices de los meses con menos toneladas recolectadas.
     */
    public ListaEstatica menosToneladas();

    /**
     * Obtenemos las toneladas del último mes del año.
     * @param listaEstatica Recibe una lista que hace referencia a las toneladas de todo el año.
     * @return Regresa las toneladas.
     */
    public double toneladasUltimoMes(ListaEstatica listaEstatica);

    /**
     * Generamos una lista para almacenar todas las toneladas del último mes de los años.
     * @return Regresamos una lista con las toneladas del último mes de todos los años.
     */
    public ListaEstatica tonUltMes();

    /**
     * Obtenemos las toneladas del segundo trimestre del año.
     * @param listaEstatica Recibe una lista que hace referencia a las toneladas de todo el año.
     * @return Regresa las toneladas del segundo trimestre.
     */
    public double tonTrim(ListaEstatica listaEstatica);

    /**
     * Obtenemos una lista con las toneladas del segundo trimestre de todos los años.
     * @return Regresa una lista con las toneladas de los años.
     */
    public ListaEstatica tonTrimestresAnios();

}
