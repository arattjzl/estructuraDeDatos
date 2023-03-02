package estructurasNoLineales;

import entradasalida.SalidaPorDefecto;
import estructurasLineales.ListaEstatica;
import utils.commons.Comparador;
import utils.commons.TipoColumna;
import utils.commons.TipoRenglon;

/**
 * Clase con los métodos de una matriz bidimensional.
 * @author Aratt
 * @version 1.0
 */
public class Matriz2 {
    protected int renglones;
    protected int columnas;
    protected Object informacion[][];
    protected TipoColumna tipoColumna;

    public Matriz2(int renglones, int columnas) {
        this.renglones = renglones;
        this.columnas = columnas;
        informacion = new Object[renglones][columnas];
    }

    public Matriz2(int renglones, int columnas, Object info) {
        this.renglones = renglones;
        this.columnas = columnas;
        informacion = new Object[renglones][columnas];
        rellenar(info);
    }

    /**
     * Rellena la matriz con el valor dado como parámetro.
     * @param info Es el valor con el cual llenará la matriz.
     */
    public void rellenar(Object info){
        //recorrer todos los renglones
        for(int cadaRenglon = 0; cadaRenglon < renglones; cadaRenglon++){
            //recorre todas las columnas
            for(int cadaColumna = 0; cadaColumna < columnas; cadaColumna++){
                //siempre van en ese orden :: renglon, columna, profundidad ::
                informacion[cadaRenglon][cadaColumna] = info;
            }
        }
    }

    /**
     * Regresa el número de renglones que tiene la matriz
     * @return Regresa el número de renglones
     */
    public int getRenglones() {
        return renglones;
    }

    /**
     * Cambia el número de renglones.
     * @param renglones Es el nuevo número de renglones.
     */
    public void setRenglones(int renglones) {
        this.renglones = renglones;
    }

    /**
     * Regresa el número de renglones que tiene la matriz
     * @return Regresa el número de renglones.
     */
    public int getColumnas() {
        return columnas;
    }

    /**
     * Cambia el número de columnas.
     * @param columnas Es el nuevo número de columnas.
     */
    public void setColumnas(int columnas) {
        this.columnas = columnas;
    }

    /**
     * Cambia la información que se encuentra en la posición de renglón y columna.
     * @param renglon Es la posición del renglón.
     * @param columna Es la posición de la columna.
     * @param info Es la información nueva por la cual cambiaremos.
     * @return Regresa <b>true</b> si si se cambió o <b>false</b> si no se cambió.
     */
    public boolean cambiar(int renglon, int columna, Object info){
        if(validarRango(renglon, getRenglones()) && validarRango(columna, getColumnas())){
            informacion[renglon][columna] = info;
            return true;
        }
        return false;
    }

    /**
     * Obtenemos la información que se encuentra en la posición de los parámetros pasados.
     * @param renglon Es la posición del renglón.
     * @param columna Es la posición de la columna.
     * @return Regresa el objeto si se encontró o null si no.
     */
    public Object obtener(int renglon, int columna){
        if(validarRango(renglon, getRenglones()) && validarRango(columna, getColumnas())){
            return informacion[renglon][columna];
        }
        return null;
    }

    /**
     * Valida el rango del índice que se encuentre entre 0 y el parámetro límite superior
     * @param indice Es el entero que queremos validar.
     * @param limiteSup Es el límite superior en el cual debe de estar el índice.
     * @return Regresa <b>true</b> si se encuentra en el rango y <b>false</b> si no se encuentra.
     */
    public boolean validarRango(int indice, int limiteSup){
        return indice >= 0 && indice < limiteSup;
    }

    /**
     * Imprime la matriz por columnas.
     */
    public void imprimirPorColumna(){
        for(int cadaRenglon = 0; cadaRenglon < renglones; cadaRenglon++){
            for(int cadaColumna = 0; cadaColumna < columnas; cadaColumna++){
                SalidaPorDefecto.terminal(informacion[cadaRenglon][cadaColumna] + " ");
            }
            //despues de cada columna se hace el salto de linea
            SalidaPorDefecto.terminal("\n");
        }
    }

    /**
     * Imprime la matriz por renglones.
     */
    public void imprimirPorRenglon(){
        for(int cadaRenglon = 0; cadaRenglon < renglones; cadaRenglon++){
            for(int cadaColumna = 0; cadaColumna < columnas; cadaColumna++){
                SalidaPorDefecto.terminal(informacion[cadaColumna][cadaRenglon] + " ");
            }
            //despues de cada columna se hace el salto de linea
            SalidaPorDefecto.terminal("\n");
        }
    }

    /**
     * Realiza la transpuesta de la matriz (cambia los valores de la parte inferior de la diagonal a la parte superior y viceversa).
     */
    public void transpuesta(){
        Matriz2 matrizAuxiliar = new Matriz2(getRenglones(), getColumnas());
        for(int nuevoRenglon = 0; nuevoRenglon < getRenglones(); nuevoRenglon++){
            for(int nuevaColumna = 0; nuevaColumna < getColumnas(); nuevaColumna++){
                matrizAuxiliar.cambiar(nuevoRenglon, nuevaColumna, informacion[nuevaColumna][nuevoRenglon]);
            }
        }
        for(int cadaRenglon = 0; cadaRenglon < getRenglones(); cadaRenglon++){
            for(int cadaColumna = 0; cadaColumna < getColumnas(); cadaColumna++){
                cambiar(cadaRenglon, cadaColumna, matrizAuxiliar.informacion[cadaRenglon][cadaColumna]);
            }
        }
    }

    /**
     * Clona la matriz actual.
     * @return Regresa la matriz clonada como una instancia de Matriz2.
     */
    public Matriz2 clonar(){
        Matriz2 nuevaMatriz = new Matriz2(getRenglones(), getColumnas());
        for(int cadaRenglon = 0; cadaRenglon < getRenglones(); cadaRenglon++){
            for(int cadaColumna = 0; cadaColumna < getColumnas(); cadaColumna++){
                nuevaMatriz.cambiar(cadaRenglon, cadaColumna, informacion[cadaRenglon][cadaColumna]);
            }
        }
        return nuevaMatriz;
    }

    /**
     * Compara la matriz actual con la matriz que pasamos como parámetro.
     * @param matriz Es la matriz con la cual compararemos la matriz actual.
     * @return Regresa <b>true</b> si las matrices son iguales o <b>false</b> si no lo son.
     */
    public boolean esIgual(Matriz2 matriz){
        for(int cadaRenglon = 0; cadaRenglon < getRenglones(); cadaRenglon++){
            for(int cadaColumna = 0; cadaColumna < getColumnas(); cadaColumna++){
                if((int)Comparador.comparar(obtener(cadaRenglon, cadaColumna),
                        matriz.obtener(cadaRenglon, cadaColumna)) != 0){
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Agrega en una columna la información pasada como parámetro.
     * @param filas La fila en la cual se agregará la información.
     * @param info La información que se agregará.
     * @return Regresa <b>true</b> si se realizo algo y <b>false</b> si no.
     */
    public boolean vectorColumna(int filas, Object info){
        if ((int) Comparador.comparar(getColumnas(),filas)>=0){
            for (int cadaRenglon=0;cadaRenglon<getRenglones();cadaRenglon++){
                cambiar(filas,cadaRenglon,info);
            }
            return true;
        }
        return false;
    }

    /**
     * Agrega en una fila la información pasada como parámetro.
     * @param columnas La columna en la cual se agregará la información.
     * @param info La información que se agregará.
     * @return Regresa <b>true</b> si se realizo algo y <b>false</b> si no.
     */
    public boolean vectorRenglon(int columnas,Object info){
        if ((int) Comparador.comparar(getColumnas(),columnas)>=0){
            for (int cadaColumna=0;cadaColumna<getColumnas();cadaColumna++){
                cambiar(cadaColumna, columnas, info);
            }
            return true;
        }
        return false;
    }

    /**
     * Permite redefinir/crear/redimensionar la matriz actual con la matriz parámetro.
     * @param matriz2 Es la matriz con la cual redefiniremos la actual.
     * @return Regresa <b>true</b> si se realizo algo y <b>false</b> si no.
     */
    public boolean redefinir(Matriz2 matriz2){
        new Matriz2(matriz2.getRenglones(), matriz2.getColumnas());
        for(int cadaRenglon = 0; cadaRenglon < matriz2.getRenglones(); cadaRenglon++){
            for(int cadaColumna = 0; cadaColumna < matriz2.getColumnas(); cadaColumna++){
                cambiar(cadaRenglon, cadaColumna, matriz2.obtener(cadaRenglon, cadaColumna));
            }
        }
        return true;
    }

    /**
     * Agrega un renglón con los valores que se encuentran en la lista.
     * @param arreglo Lista con valores a agregar.
     * @return Regresa <b>true</b> si se realizo el cambio.
     */
    public boolean agregarRenglon(ListaEstatica arreglo){
        if(validarRango(arreglo.getTope(), getRenglones())){
            for(int indiceRenglones = 0; indiceRenglones <= arreglo.getTope(); indiceRenglones++){
                cambiar(indiceRenglones, 0, arreglo.obtener(indiceRenglones));
            }
            return true;
        }
        return false;
    }

    /**
     * Agrega una columna con los valores que se encuentran en la lista.
     * @param arreglo Lista con valores a agregar.
     * @return Regresa <b>true</b> si se realizo el cambio.
     */
    public boolean agregarColumna(ListaEstatica arreglo){
        if(validarRango(arreglo.getTope(), getColumnas())){
            for(int indiceColumnas = 0; indiceColumnas <= arreglo.getTope(); indiceColumnas++){
                cambiar(0, indiceColumnas, arreglo.obtener(indiceColumnas));
            }
            return true;
        }
        return false;
    }

    /**
     * Agregar una matriz nueva a la matriz actual de manera de columnas.
     * @param matriz Matriz que se agregará a la actual.
     * @return Regresa <b>true</b> si se realizo el cambio.
     */
    public boolean agregarMatrizXColumna(Matriz2 matriz){

        for(int cadaColumna = 0; cadaColumna < getColumnas(); cadaColumna++){
            for(int cadaRenglon = 0; cadaRenglon < getRenglones(); cadaRenglon++){
                cambiar(cadaRenglon, cadaColumna, matriz.obtener(cadaRenglon, cadaColumna));
            }
        }
        return true;
    }

    /**
     * Agregar una matriz nueva a la matriz actual de manera de renglones.
     * @param matriz Matriz que se agregará a la actual.
     * @return Regresa <b>true</b> si se realizo el cambio.
     */
    public boolean agregarMatrizXRenglon(Matriz2 matriz){
        for(int cadaRenglon = 0; cadaRenglon < getRenglones(); cadaRenglon++){
            for(int cadaColumna = 0; cadaColumna < getColumnas(); cadaColumna++){
                cambiar(cadaRenglon, cadaColumna, matriz.obtener(cadaRenglon, cadaColumna));
            }
        }
        return true;
    }

    /**
     * Convierte la matriz actual a una matriz de dos dimensiones en una de tres dimensiones.
     * @param matrices Es una lista que contiene matrices las cuales también serán agregadas a la nueva matriz de tres dimensiones.
     * @return Regresa la nueva matriz de tres dimensiones.
     */
    public Matriz3 aMatriz3(ListaEstatica matrices){
        Matriz3 matriz3 = new Matriz3(getRenglones(),getColumnas(),matrices.maximo()+1);
        Matriz2 matriz2D;
        Object objeto;
        for(int nuevoRenglon = 0; nuevoRenglon <getRenglones(); nuevoRenglon++){
            for(int nuevoCol = 0; nuevoCol <getColumnas(); nuevoCol++){
                matriz3.cambiar(nuevoRenglon,nuevoCol,0, obtener(nuevoRenglon,nuevoCol));
            }
        }
        for(int cadaMatriz = 0; cadaMatriz < matrices.maximo(); cadaMatriz++){
            matriz2D = (Matriz2) matrices.obtener(cadaMatriz);
            if((int)Comparador.comparar(getRenglones(), ((Matriz2) matrices.obtener(cadaMatriz)).getRenglones()) >= 0
                    && (int)Comparador.comparar(getColumnas(), ((Matriz2) matrices.obtener(cadaMatriz)).getColumnas()) >= 0){
                for(int cadaRenglon = 0; cadaRenglon < getRenglones(); cadaRenglon++){
                    for(int cadaColumna = 0; cadaColumna < getColumnas(); cadaColumna++){
                        objeto = matriz2D.obtener(cadaRenglon,cadaColumna);
                        matriz3.cambiar(cadaRenglon,cadaColumna,cadaMatriz+1, objeto);
                    }
                }
            }
        }
        return matriz3;
    }

    /**
     * Convierte la matriz actual acomodando cada columna una debajo de otra para formar un vector columna.
     * @return Regresa la lista estática con valores de la matriz.
     */
    public ListaEstatica aVectorColumna(){
        ListaEstatica nuevaLista = new ListaEstatica(getRenglones()*getColumnas());
        for(int nuevoReng = 0; nuevoReng < getRenglones(); nuevoReng++){
            for(int nuevoCol = 0; nuevoCol < getColumnas(); nuevoCol++){
                nuevaLista.agregar(obtener(nuevoCol,nuevoReng));
            }
        }
        return nuevaLista;
    }

    /**
     * Convierte la matriz actual acomodando cada renglón una enseguida de otro para formar un vector renglón.
     * @return Regresa la lista estática con valores de la matriz.
     */
    public ListaEstatica aVectorRenglon(){
        ListaEstatica nuevaLista = new ListaEstatica(getRenglones()*getColumnas());
        for(int nuevoReng = 0; nuevoReng < getRenglones(); nuevoReng++){
            for(int nuevoCol = 0; nuevoCol < getColumnas(); nuevoCol++){
                nuevaLista.agregar(obtener(nuevoReng,nuevoCol));
            }
        }
        return nuevaLista;
    }

    /**
     * Elimina la columna que se le indique.
     * @param tipoColumna Tipo de columna que queremos quitar (izquierda o derecha).
     * @return Regresa <b>true</b> si se quitó y <b>false</b> no lo hizo.
     */
    public boolean quitarColumna(TipoColumna tipoColumna){
        ListaEstatica nuevaLista = new ListaEstatica(getRenglones());
        if(tipoColumna==TipoColumna.DER){
            for(int cadaCol = getColumnas(); cadaCol >= 0; cadaCol--){
                for(int cadaReng = 0; cadaReng < getRenglones(); cadaReng++){
                    nuevaLista.agregar(obtener(cadaCol, cadaReng));
                }
                for(int indiceLista = 0; indiceLista < nuevaLista.maximo(); indiceLista++){
                    if(nuevaLista.obtener(indiceLista) != null){
                        return eliminarRenglon(cadaCol);
                    }
                }
                nuevaLista.vaciar();
            }
            return true;
        } else if (tipoColumna==TipoColumna.IZQ) {
            for(int cadaCol = 0; cadaCol < getColumnas(); cadaCol++){
                for(int cadaReng = 0; cadaReng < getRenglones(); cadaReng++){
                    nuevaLista.agregar(obtener(cadaCol, cadaReng));
                }
                for(int indiceLista = 0; indiceLista < nuevaLista.maximo(); indiceLista++){
                    if(nuevaLista.obtener(indiceLista) != null){
                        return eliminarRenglon(cadaCol);
                    }
                }
                nuevaLista.vaciar();
            }
            return true;
        }
        return false;
    }

    /**
     * Elimina el renglón que se le indique.
     * @param tipoRenglon Tipo de renglón que queremos quitar (izquierda o derecha).
     * @return Regresa <b>true</b> si se quitó y <b>false</b> no lo hizo.
     */
    public boolean quitarRenglon(TipoRenglon tipoRenglon){
        ListaEstatica nuevaLista = new ListaEstatica(getRenglones());
        if(tipoRenglon==TipoRenglon.INF){
            for(int cadaCol = getColumnas(); cadaCol >= 0; cadaCol--){
                for(int cadaReng = 0; cadaReng < getRenglones(); cadaReng++){
                    nuevaLista.agregar(obtener(cadaReng, cadaCol));
                }
                for(int indiceLista = 0; indiceLista < nuevaLista.maximo(); indiceLista++){
                    if(nuevaLista.obtener(indiceLista) != null){
                        return eliminarColumna(cadaCol);
                    }
                }
                nuevaLista.vaciar();
            }
        } else if (tipoRenglon==TipoRenglon.SUP) {
            for(int cadaCol = 0; cadaCol < getColumnas(); cadaCol++){
                for(int cadaReng = 0; cadaReng < getRenglones(); cadaReng++){
                    nuevaLista.agregar(obtener(cadaReng, cadaCol));
                }
                for(int indiceLista = 0; indiceLista < nuevaLista.maximo(); indiceLista++){
                    if(nuevaLista.obtener(indiceLista) != null){
                        return eliminarColumna(cadaCol);
                    }
                }
                nuevaLista.vaciar();
            }
        }
        return false;
    }

    /**
     * Elimina el renglón que se le indique.
     * @param renglon Posición del renglón que se quiere eliminar.
     * @return Regresa <b>true</b> si se pudo eliminar el renglón o <b>false</b> si no lo hizo.
     */
    public boolean eliminarRenglon(int renglon){
        if(validarRango(renglon,getRenglones())){
            for(int cadaColumna = 0; cadaColumna < getColumnas(); cadaColumna++){
                cambiar(cadaColumna, renglon, null);
            }
            return true;
        }
        return false;
    }

    /**
     * Elimina la columna que se le indique.
     * @param columna Posición del renglón que se quiere eliminar.
     * @return Regresa <b>true</b> si se pudo eliminar el renglón o <b>false</b> si no lo hizo.
     */
    public boolean eliminarColumna(int columna){
        if(validarRango(columna, getColumnas())){
            for(int cadaRenglon = 0; cadaRenglon < getColumnas(); cadaRenglon++){
                cambiar(columna, cadaRenglon, null);
            }
            return true;
        }
        return false;
    }
}
