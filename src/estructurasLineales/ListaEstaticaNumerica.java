package estructurasLineales;

import utils.commons.Comparador;

/**
 * Esta clase contiene los métodos para realizar acciones con listas que tengan objetos de tipo número.
 * @author Aratt
 * @version 1.0
 */
public class ListaEstaticaNumerica extends ListaEstatica{
    public ListaEstaticaNumerica(int tamanio) {
        super(tamanio);
    }

    @Override
    public int agregar(Object info) {
        if(validarNumero(info)){
            return super.agregar(info);
        }
        return -1;
    }

    @Override
    public boolean cambiar(int indice, Object info){
        if(validarNumero(info)){
            return super.cambiar(indice,info);
        }
        return false;
    }

    /**
     * Valida si la información que se le pasa es un número.
     * @param info Es la información que le pasaremos.
     * @return Regresa <b>true</b> si la información es número y <b>false</b> si no.
     */
    public boolean validarNumero(Object info){
        return info instanceof Number;
    }

    /**
     * Valida si la lista tiene el mismo número de datos que la lista actual.
     * @param lista2 Es la lista que queremos saber si tiene el mismo número de valores que la actual.
     * @return Regresa <b>true</b> si tiene el mismo número de valores y <b>false</b> si no.
     */
    public boolean validarDimensiones(ListaEstaticaNumerica lista2){
        return (int) Comparador.comparar(getTope(), lista2.getTope()) == 0;
    }

    /**
     * Multiplicar el escalar dado por cada posición del arreglo numérico.
     * @param escalar Es el número por el que multiplicaremos la lista actual.
     * @return Regresa <b>falso</b> si la lista esta vacía.
     */
    public boolean porEscalar(Number escalar){
        if(!vacia()){
            for(int cadaValor = 0; cadaValor <= getTope(); cadaValor++){
                informacion[cadaValor] = ((Number) obtener(cadaValor)).doubleValue() * escalar.doubleValue();
            }
        }
        return false;
    }

    /**
     * Suma el escalar dado a cada posición del arreglo numérico.
     * @param escalar Es el número que le sumaremos a la lista actual.
     * @return Regresa <b>falso</b> si la lista esta vacía.
     */
    public boolean sumarEscalar(Number escalar){
        if(!vacia()){
            for(int cadaValor = 0; cadaValor <= getTope(); cadaValor++){
                informacion[cadaValor] = ((Number)obtener(cadaValor)).doubleValue() + escalar.doubleValue();
            }
            return true;
        }
        return false;
    }

    /**
     * Suma la posición 1 del arreglo actual con la posición 1 de arreglo2, y así sucesivamente.
     * @param lista2 Es la lista con la cual sumaremos la lista actual.
     * @return Regresa <b>false</b> si las dimensiones del arreglo son diferentes.
     */
    public boolean sumar(ListaEstaticaNumerica lista2){
        if(validarDimensiones(lista2)){
            for(int valoresLista = 0; valoresLista <= getTope(); valoresLista++){
                informacion[valoresLista] = ((Number) obtener(valoresLista)).doubleValue() + ((Number) lista2.obtener(valoresLista)).doubleValue();
            }
            return true;
        }
        return false;
    }

    /**
     * Multiplica la posición 1 del arreglo actual con la posición 1 de arreglo2, y así sucesivamente.
     * @param lista2 Es la lista con la cual sumaremos la lista actual.
     * @return Regresa <b>false</b> si el arreglo actual esta vacío.
     */
    public boolean multiplicar(ListaEstaticaNumerica lista2){
        if(!vacia()){
            if((int) Comparador.comparar(getTope(), lista2.getTope()) == 0){
                for(int valoresLista = 0; valoresLista <= getTope(); valoresLista++){
                    informacion[valoresLista] = ((Number) obtener(valoresLista)).doubleValue() * ((Number) lista2.obtener(valoresLista)).doubleValue();
                }
                return true;
            }
        }
        return false;
    }

    /**
     * Realiza la operación de potencia de cada elemento del arreglo actual por el exponente pasado como escalar.
     * @param escalar Es el número que usaremos para realizar el exponente en la lista actual.
     * @return Regresa <b>false</b> si el arreglo actual esta vacío.
     */
    public boolean aplicarPotencia(Number escalar){
        if(!vacia()){
            for(int cadaValor = 0; cadaValor <= getTope(); cadaValor++){
                int valorAuxiliar = (int) informacion[cadaValor];
                for(int exponente = 1; exponente < escalar.intValue(); exponente++){
                    informacion[cadaValor] = ((Number)obtener(cadaValor)).doubleValue() * valorAuxiliar;
                }
            }
            return true;
        }
        return false;
    }

    /**
     * Realiza la operación de potencia de cada elemento del arreglo actual por el elemento de la lista pasada como parámetro en la misma posición.
     * @param listaEscalares Es la lista que utilizaremos para sacar los valores de los exponentes.
     * @return Regresa <b>false</b> si las dimensiones del arreglo son diferentes.
     */
    public boolean aplicarPotencia(ListaEstaticaNumerica listaEscalares){
        if(validarDimensiones(listaEscalares)){
            for(int cadaValor = 0; cadaValor <= getTope(); cadaValor++){
                int valorAuxiliar = (int) informacion[cadaValor];
                for(int exponente = 1; exponente < (int)listaEscalares.obtener(cadaValor); exponente++){
                    informacion[cadaValor] = ((Number)obtener(cadaValor)).doubleValue() * valorAuxiliar;
                }
            }
            return true;
        }
        return false;
    }

    /**
     * Realiza la suma de las multiplicaciones de las dos listas en el mismo índice.
     * @param lista2 Es la lista que le pasamos para realizar el producto escalar.
     * @return Regresa el valor de esta suma
     */
    public double productoEscalar(ListaEstaticaNumerica lista2){
        double transformada = 0.0;
        if(validarDimensiones(lista2) && !vacia()){
            for(int valoresLista = 0; valoresLista <= getTope(); valoresLista++){
                transformada += ((Number) obtener(valoresLista)).doubleValue() * ((Number) lista2.obtener(valoresLista)).doubleValue();
            }
            return transformada;
        }
        return transformada;
    }

    /**
     * Realiza la norma de la lista actual.
     * @return Regresa el valor de la norma.
     */
    public double norma(){
        double norma = 0.0;
        for(int cadaValor = 0; cadaValor <= getTope(); cadaValor++){
             norma += ((Number) obtener(cadaValor)).doubleValue() * ((Number) obtener(cadaValor)).doubleValue();
        }
        return Math.sqrt(norma);
    }

    /**
     * Realiza la norma euclidiana con los valores de la lista actual y la lista pasada como argumento.
     * @param lista2 Es la lista que representa el vector B en la norma euclidiana.
     * @return Regresa el valor de la norma euclidiana.
     */
    public double normaEuclidiana(ListaEstaticaNumerica lista2){
        double norma = 0.0;
        if(!vacia() && validarDimensiones(lista2)){
            for(int cadaValor = 0; cadaValor <= getTope(); cadaValor++){
                norma += (((Number) lista2.obtener(cadaValor)).doubleValue() - ((Number) obtener(cadaValor)).doubleValue()) * (((Number) lista2.obtener(cadaValor)).doubleValue() - ((Number) obtener(cadaValor)).doubleValue());
            }
            return Math.sqrt(norma);
        }
        return norma;
    }

    /**
     * Debe sumar de uno por uno un conjunto de arreglos de la lista parámetro almacenados en la variable listas al arreglo actual.
     * @param listas Es la lista que contendrá otras listas numéricas
     * @return
     */
    public double sumarListaEstatica(ListaEstatica listas){
        if(!vacia()){
            for(int indiceListas = 0; indiceListas <= listas.getTope(); indiceListas++){
                if(listas.obtener(indiceListas) instanceof ListaEstaticaNumerica){
                    for(int numEscalar = 0; numEscalar <= ((ListaEstaticaNumerica) listas.obtener(indiceListas)).getTope(); numEscalar++){
                        for(int valListaActual = 0; valListaActual <= getTope(); valListaActual++){
                            informacion[valListaActual] = ((Number)informacion[valListaActual]).doubleValue() + ((Number)((ListaEstaticaNumerica) listas.obtener(indiceListas)).obtener(numEscalar)).doubleValue();
                        }
                    }
                }
            }
            return 1.0;
        }
        return 0.0;
    }

    /**
     * Suma de uno por uno un conjunto de escalares almacenados en la variable escalares al arreglo actual.
     * @param escalares  Es una lista con valores numéricos.
     * @return Regresa <b>1</b> si se realizo el cambio o <b>0</b> si no se realizo.
     */
    public double sumarEscalares(ListaEstaticaNumerica escalares){
        if(!vacia() && validarDimensiones(escalares)){
            for(int numEscalar = 0; numEscalar <= escalares.getTope(); numEscalar++){
                for(int valListaActual = 0; valListaActual <= getTope(); valListaActual++){
                    informacion[valListaActual] = ((Number)informacion[valListaActual]).doubleValue() + ((Number) escalares.obtener(numEscalar)).doubleValue();
                }
            }
            return 1.0;
        }
        return 0.0;
    }

    /**
     * Realiza la suma de la información que recopila con los índices que tiene la lista parámetro.
     * @param listaIndices Lista con los índices con los que hará la suma.
     * @return Regresa la suma de la información.
     */
    public double sumarIndices(ListaEstaticaNumerica listaIndices){
        double sumaIndices = 0.0;
        if(!vacia()){
            for(int indiceLista = 0; indiceLista <= listaIndices.getTope(); indiceLista++){
                if(obtener((int) listaIndices.obtener(indiceLista)) != null){
                    sumaIndices += ((Number) obtener((int)listaIndices.obtener(indiceLista))).doubleValue();
                }
            }
            return sumaIndices;
        }
        return sumaIndices;
    }

    /**
     * Debe regresar un arreglo conteniendo los elementos del arreglo actual que se obtienen del arreglo pasado como parámetro.
     * @param listaIndices Es una lista valores numéricos.
     * @return Regresa una lista con la información que se encuentra en los índices que tienen los valores de la lista parámetro.
     */
    @Override
    public ListaEstatica subLista(ListaEstaticaNumerica listaIndices) {
        ListaEstaticaNumerica listaNueva = new ListaEstaticaNumerica(listaIndices.getTope()+1);
        if(!vacia()){
            for(int indiceLista = 0; indiceLista <= listaIndices.getTope(); indiceLista++){
                if(obtener((int) listaIndices.obtener(indiceLista)) != null){
                    if(obtener((int)listaIndices.obtener(indiceLista)) instanceof Number) {
                        Number objeto = ((Number) obtener((int) listaIndices.obtener(indiceLista))).doubleValue();
                        listaNueva.agregar(objeto);
                    }
                }
            }
            return listaNueva;
        }
        return listaNueva;
    }

    /**
     * Verifica si las listas son linealmente independientes.
     * @param listaVectores Es la lista con la cual comparará si son linealmente dependientes.
     * @return Regresa <b>true</b> si las listas son linealmente dependientes y <b>false</b> si no lo son.
     */
    public boolean sonLinealmenteDependientes(ListaEstatica listaVectores){
        if(listaVectores instanceof ListaEstaticaNumerica){
            ListaEstaticaNumerica listaAuxiliar = new ListaEstaticaNumerica(getTope()+1);
            for(int indiceLista = 0; indiceLista <= getTope(); indiceLista++){
                listaAuxiliar.agregar(((Number)obtener(indiceLista)).doubleValue());
            }
            listaAuxiliar.multiplicar((ListaEstaticaNumerica) listaVectores);
            double valorFinal = 0.0;
            for(int indiceNuevaLista = 0; indiceNuevaLista <= listaAuxiliar.getTope(); indiceNuevaLista++){
                valorFinal += ((Number)listaAuxiliar.obtener(indiceNuevaLista)).doubleValue();
            }
            return (valorFinal == 0.0);
        }
        return false;
    }

    /**
     * Verifica si las listas son linealmente independientes.
     * @param listaVectores Es la lista con la cual comparará si son linealmente independientes.
     * @return Regresa <b>true</b> si las listas son linealmente independientes y <b>false</b> si no lo son.
     */
    public boolean sonLinealmenteIndependientes(ListaEstatica listaVectores){
        if(listaVectores instanceof ListaEstaticaNumerica){
            for(int indiceLista = 0; indiceLista <= getTope(); indiceLista++){
                if(((Number) obtener(indiceLista)).doubleValue() != 0){
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    /**
     * Verifica si las listas son ortogonales.
     * @param lista2 Es la lista con la que comparará la ortogonalidad.
     * @return Regresa <b>true</b> si son ortogonales y <b>false</b> si no lo son.
     */
    public boolean esOrtogonal(ListaEstaticaNumerica lista2){
        return productoEscalar(lista2) == 0;
    }

    /**
     * Verifica si las listas son paralelas.
     * @param lista2 Es la lista con la que comparará la paralelidad.
     * @return Regresa <b>true</b> si son paralelas y <b>false</b> si no lo son.
     */
    public boolean esParalelo(ListaEstaticaNumerica lista2){
        if(validarDimensiones(lista2)){
            double escalar = ((Number) lista2.obtener(0)).doubleValue() / ((Number) obtener(0)).doubleValue();
            for(int indiceLista = 1; indiceLista <= getTope(); indiceLista++){
                if((int)Comparador.comparar(escalar, ((Number) lista2.obtener(indiceLista)).doubleValue() / ((Number) obtener(indiceLista)).doubleValue()) !=0){
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public void recibeBuffer(double[] buffer){
        for(int indiceArreglo = 0; indiceArreglo < getMAXIMO(); indiceArreglo++){
            agregar(buffer[indiceArreglo]);
        }
    }

    public double[] leerArregloNumerico(){
        double[] arregloAuxiliar = new double[getMAXIMO()];
        for(int indiceArreglo = 0; indiceArreglo <= getTope(); indiceArreglo++){
            arregloAuxiliar[indiceArreglo] = ((Number) informacion[indiceArreglo]).doubleValue();
        }
        return arregloAuxiliar;
    }

    @Override
    public void invertir() {
        ListaEstaticaNumerica listaAuxiliar = new ListaEstaticaNumerica(getMAXIMO());
        for(int indice = 0; indice <= getTope(); indice++){
            listaAuxiliar.informacion[getTope()-indice] = informacion[indice];
        }
        for(int indice = 0; indice <= getTope(); indice++){
            informacion[indice] = listaAuxiliar.informacion[indice];
        }
    }
}
