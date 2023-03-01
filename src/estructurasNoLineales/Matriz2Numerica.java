package estructurasNoLineales;

import entradasalida.SalidaPorDefecto;
import estructurasLineales.ListaEstaticaNumerica;
import utils.commons.Comparador;
import utils.commons.TipoLogaritmo;

public class Matriz2Numerica extends Matriz2 {

    /**
     * Crea un objeto de matriz bidimensional numérica y rellena los valores en 0.
     *
     * @param renglones Número de renglones.
     * @param columnas  Número de columnas.
     */
    public Matriz2Numerica(int renglones, int columnas) {
        super(renglones, columnas);
        rellenar(0);
    }

    /**
     * Crea un objeto de matriz bidimensional numérica y rellena con valores dados.
     *
     * @param renglones Número de renglones
     * @param columnas  Número de columnas.
     * @param info      Número con el cual se rellenará la matriz.
     */
    public Matriz2Numerica(int renglones, int columnas, Object info) {
        super(renglones, columnas);
        rellenar(info);
    }

    public Matriz2Numerica clonar(){
        Matriz2Numerica nuevaMatriz = new Matriz2Numerica(getRenglones(), getColumnas());
        for(int cadaRenglon = 0; cadaRenglon < getRenglones(); cadaRenglon++){
            for(int cadaColumna = 0; cadaColumna < getColumnas(); cadaColumna++){
                nuevaMatriz.cambiar(cadaRenglon, cadaColumna, informacion[cadaRenglon][cadaColumna]);
            }
        }
        return nuevaMatriz;
    }

    /**
     * Valida si el objeto es un número.
     *
     * @param info Información por validar.
     * @return Regresa <b>true</b> si es un número y <b>false</b> si no lo es.
     */
    public boolean validarNumero(Object info) {
        return info instanceof Number;
    }

    /**
     * Verifica que no haya valores 0 en la matriz.
     * @return Regresa <b>true</b> si un valor es 0 y <b>false</b> si ninguno lo es.
     */
    public boolean existeValorCero(){
        for(int cadaRenglon = 0; cadaRenglon < getRenglones(); cadaRenglon++){
            for(int cadaColumna = 0; cadaColumna < getColumnas(); cadaColumna++){
                if(((Number)obtener(cadaRenglon, cadaColumna)).doubleValue() == 0){
                    return true;
                }
            }
        }
        return false;
    }
    /**
     * Rellena la matriz con el valor parámetro.
     *
     * @param info Es el valor con el cual llenará la matriz.
     */
    @Override
    public void rellenar(Object info) {
        if (validarNumero(info)) {
            super.rellenar(info);
        }
    }

    /**
     * Multiplica la matriz por el valor escalar dado.
     *
     * @param escalar Es el valor por el que se multiplicará la matriz.
     * @return Regresa <b>true</b> cuando termina de multiplicar.
     */
    public boolean porEscalar(Number escalar) {
        for (int cadaRenglon = 0; cadaRenglon <= getRenglones(); cadaRenglon++) {
            for (int cadaColumna = 0; cadaColumna <= getColumnas(); cadaColumna++) {
                if (obtener(cadaRenglon, cadaColumna) != null) {
                    cambiar(cadaRenglon, cadaColumna, ((Number) obtener(cadaRenglon, cadaColumna)).doubleValue() * escalar.doubleValue());
                }
            }
        }
        return true;
    }

    /**
     * Multiplica cada valor de las columnas por el valor del mismo índice de la lista estática numérica.
     * @param escalares Lista estática numérica con los valores de escalares.
     * @return Regresa <b>true</b> cuando multiplica todos y <b>false</b> si el rango no es válido.
     */
    public boolean porEscalar(ListaEstaticaNumerica escalares) {
        if (validarRango(getColumnas(), escalares.getMAXIMO())) {
            for (int cadaRenglon = 0; cadaRenglon < getRenglones(); cadaRenglon++) {
                for (int cadaColumna = 0; cadaColumna < getColumnas(); cadaColumna++) {
                    if (obtener(cadaRenglon, cadaColumna) != null) {
                        cambiar(cadaRenglon, cadaColumna, ((Number) obtener(cadaRenglon, cadaColumna)).doubleValue()
                                * ((Number) escalares.obtener(cadaColumna)).doubleValue());
                    }
                }
            }
            return true;
        }
        return false;
    }

    /**
     * Suma cada posición de la matriz con el valor del escalar.
     * @param escalar Es el valor a sumar
     * @return Regresa <b>true</b> al sumar todos.
     */
    public boolean sumarEscalar(Number escalar){
        for(int cadaRenglon = 0; cadaRenglon < getRenglones(); cadaRenglon++){
            for(int cadaColumna = 0; cadaColumna < getColumnas(); cadaColumna++){
                cambiar(cadaRenglon, cadaColumna, ((Number)obtener(cadaRenglon,cadaColumna)).doubleValue() + escalar.doubleValue());
            }
        }
        return true;
    }

    /**
     * Suma cada valor de las columnas por el valor del mismo índice de la lista estática numérica.
     * @param escalares Lista estática numérica con los valores de escalares.
     * @return Regresa <b>true</b> cuando suma todos y <b>false</b> si el rango no es válido.
     */
    public boolean sumarEscalares(ListaEstaticaNumerica escalares){
        if (validarRango(getColumnas(), escalares.getMAXIMO())) {
            for (int cadaRenglon = 0; cadaRenglon < getRenglones(); cadaRenglon++) {
                for (int cadaColumna = 0; cadaColumna < getColumnas(); cadaColumna++) {
                    if (obtener(cadaRenglon, cadaColumna) != null) {
                        cambiar(cadaRenglon, cadaColumna, ((Number) obtener(cadaRenglon, cadaColumna)).doubleValue()
                                + ((Number) escalares.obtener(cadaColumna)).doubleValue());
                    }
                }
            }
            return true;
        }
        return false;
    }

    /**
     * Multiplica la matriz actual por la matriz parámetro.
     * @param matriz Es la matriz por la cual se multiplicará la actual.
     * @return Regresa <b>true</b> si se pudo multiplicar y <b>false</b> si no.
     */
    public Matriz2 multiplicar(Matriz2Numerica matriz){
        double sumaMultiplicaciones = 0;
        Matriz2 matrizMultiplicada = new Matriz2(getRenglones(), matriz.getColumnas());
        if((int)Comparador.comparar(getColumnas(),matriz.getRenglones())==0){
            for (int cadaRenglon = 0; cadaRenglon < getRenglones(); cadaRenglon++){
                for (int cadaOtraColumna = 0; cadaOtraColumna < matriz.getColumnas(); cadaOtraColumna++){
                    for (int cadaRenglonColumna = 0; cadaRenglonColumna < getColumnas(); cadaRenglonColumna++){
                        sumaMultiplicaciones += ((Number)obtener(cadaRenglon,cadaRenglonColumna)).doubleValue() * ((Number) matriz.obtener(cadaRenglonColumna,cadaOtraColumna)).doubleValue();
                    }
                    matrizMultiplicada.cambiar(cadaRenglon,cadaOtraColumna,sumaMultiplicaciones);
                    sumaMultiplicaciones=0;
                }
            }
            return matrizMultiplicada;
        }
        return null;
    }

    /**
     * Suma la matriz actual con la matriz parámetro.
     * @param matriz Es la matriz con la cual se sumará la actual.
     * @return Regresa <b>true</b> si se pudo sumar y <b>false</b> si no.
     */
    public boolean sumar(Matriz2Numerica matriz){
        if((int)Comparador.comparar(getColumnas(),matriz.getColumnas())==0  && (int)Comparador.comparar(getRenglones(),matriz.getRenglones())==0){
            for(int cadaRenglon = 0; cadaRenglon < matriz.getRenglones(); cadaRenglon++){
                for(int cadaColumna = 0; cadaColumna < matriz.getColumnas(); cadaColumna++){
                    if(obtener(cadaRenglon,cadaColumna) != null) {
                        cambiar(cadaRenglon, cadaColumna, (((Number) obtener(cadaRenglon, cadaColumna)).doubleValue() + ((Number) matriz.obtener(cadaRenglon, cadaColumna)).doubleValue()));
                    }
                }
            }
            return true;
        }
        return false;

    }

    /**
     * Aplica la potencia a cada valor de la matriz con el escalar.
     * @param escalar Es el valor por el cual elevaremos cada valor de la matriz.
     * @return Regresa <b>true</b> si se pudo aplicar la potencia y <b>false</b> si no.
     */
    public boolean aplicarPotencia(Number escalar){
        for(int cadaRenglon = 0; cadaRenglon < getRenglones(); cadaRenglon++){
            for(int cadaColumna = 0; cadaColumna < getColumnas(); cadaColumna++){
                if(obtener(cadaRenglon,cadaColumna) != null) {
                    cambiar(cadaRenglon, cadaColumna, Math.pow((double) obtener(cadaRenglon, cadaColumna), escalar.doubleValue()));
                }
            }
        }
        return true;
    }

    /**
     * Aplica el logaritmo que seleccione a la matriz.
     * @param tipoLogaritmo Tipo de logaritmo que utilizará la matriz.
     * @return Regresa <b>true</b> si se aplicaron los logaritmos y <b>false</b> si no.
     */
    public boolean aplicarLogaritmo(TipoLogaritmo tipoLogaritmo){
        if(!existeValorCero()){
            for(int cadaRenglon = 0; cadaRenglon < getRenglones(); cadaRenglon++){
                for(int cadaColumna = 0; cadaColumna < getColumnas(); cadaColumna++){
                    double info = ((Number)obtener(cadaRenglon, cadaColumna)).doubleValue();
                    if(tipoLogaritmo == TipoLogaritmo.BASE10){
                        cambiar(cadaRenglon, cadaColumna, Math.log10(info));
                    } else if(tipoLogaritmo == TipoLogaritmo.NATURAL){
                        cambiar(cadaRenglon, cadaColumna, Math.log(info));
                    } else if(tipoLogaritmo == TipoLogaritmo.BASE2){
                        cambiar(cadaRenglon, cadaColumna, (Math.log(info) / Math.log(2)));
                    }
                }
            }
            return true;
        }
        return false;
    }

    /**
     * Convierte la matriz en una matriz diagonal.
     * @param contenido Es el valor con el cual se creará la diagonal
     * @return Regresa <b>true</b> si se realizó la matriz y <b>false</b> si no.
     */
    public boolean matrizDiagonal(Number contenido){
        if((int)Comparador.comparar(getRenglones(), getColumnas()) == 0){
            rellenar(0);
            for(int cadaRenglon = 0; cadaRenglon < getRenglones(); cadaRenglon++){
                for(int cadaColumna = 0; cadaColumna < getColumnas(); cadaColumna++){
                    if(cadaColumna == cadaRenglon){
                        cambiar(cadaRenglon,cadaColumna, contenido);
                    }
                }
            }
            return true;
        }
        return false;
    }

    /**
     * Determina si la matriz es una matriz diagonal superior.
     * @return Regresa <b>true</b> si es diagonal superior y <b>false</b> si no.
     */
    public boolean esDiagonalSuperior(){
        if((int)Comparador.comparar(getRenglones(), getColumnas()) == 0){
            for(int cadaRenglon = 0; cadaRenglon < getRenglones(); cadaRenglon++){
                for(int cadaColumna = 0; cadaColumna <= cadaRenglon; cadaColumna++){
                    if(cadaRenglon == cadaColumna){
                        if(((Number)obtener(cadaRenglon, cadaColumna)).doubleValue() == 0){
                            return false;
                        }
                    } else if((int)obtener(cadaRenglon, cadaColumna) != 0){
                        return false;
                    }
                }
            }
            return true;
        }
        return false;
    }

    /**
     * Determina si la matriz es una matriz diagonal inferior.
     * @return Regresa <b>true</b> si es diagonal inferior y <b>false</b> si no.
     */
    public boolean esDiagonalInferior(){
        if((int)Comparador.comparar(getRenglones(), getColumnas()) == 0){
            for(int cadaRenglon = 0; cadaRenglon < getRenglones(); cadaRenglon++){
                for(int cadaColumna = cadaRenglon; cadaColumna < getColumnas(); cadaColumna++){
                    if(cadaRenglon == cadaColumna){
                        if(((Number) obtener(cadaRenglon, cadaColumna)).doubleValue() == 0){
                            return false;
                        }
                    } else if((int) obtener(cadaRenglon, cadaColumna) != 0){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    /**
     *
     * @param exponente
     * @return
     */
    public boolean potencia(int exponente){
        Matriz2Numerica matrizAuxiliar = clonar();
        matrizAuxiliar.imprimirPorColumna();
        if(getRenglones() == getColumnas()){
            for(int cadaExponente = 1; cadaExponente < exponente; cadaExponente++){
                multiplicar(matrizAuxiliar);
            }
            return true;
        }
        return false;
    }

}
