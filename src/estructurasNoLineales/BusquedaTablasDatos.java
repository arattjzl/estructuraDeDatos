package estructurasNoLineales;

import entradasalida.SalidaPorDefecto;
import estructurasLineales.ListaEstatica;
import estructurasLineales.auxiliares.NodoDoble;
import estructurasNoLineales.auxiliares.NodoBusquedaArbol;
import utils.commons.Comparador;
import utils.commons.Separador;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Clase que contiene los métodos para guardar los registros de dos tablas de una base de datos.
 * @author Aratt
 * @version 1.0
 */
public class BusquedaTablasDatos {
    protected ArbolBinarioBusqueda arbol1;
    protected ArbolBinarioBusqueda arbol2;

    public BusquedaTablasDatos(){
        arbol1 = new ArbolBinarioBusqueda();
        arbol2 = new ArbolBinarioBusqueda();
    }

    /**
     * Abre el archivo de la primera tabla de la base de datos y mete los registros en un árbol.
     * @param archivoS Ruta del archivo de la primera tabla.
     * @param posicion Posición de donde agarrará el id.
     * @throws IOException
     */
    public void abrirArchivoArbol1(String archivoS, int posicion) throws IOException {
        RandomAccessFile archivo = null;
        try {
            archivo = new RandomAccessFile(archivoS, "r");
            System.out.println("El tamaño es: " + archivo.length());
            String cad="";
            archivo.readLine();
            while(true) {
                //System.out.print("Pos: "+archivo.getFilePointer());
                cad = archivo.readLine();
                if (cad==null) break;
                ListaEstatica valores = Separador.separar(cad, ",");
                NodoBusquedaArbol nuevoNodo = new NodoBusquedaArbol(valores.obtener(posicion), archivo.getFilePointer());
                arbol1.agregar(nuevoNodo);
            }
        } catch (IOException fe) {
            System.out.println("No se encontro el archivo");
        }
        archivo.close();
    }

    /**
     * Abre el archivo de la primera tabla de la base de datos y mete los registros en un árbol y aquellos que tengan id igual, serán metidos en
     * otro árbol que estará dentro de este mismo.
     * @param archivoS Ruta del archivo de la primera tabla.
     * @param viejoId Identificador de la tabla que se repite.
     * @param nuevoId Identificador de la table que no se repite.
     * @throws IOException
     */
    public void abrirArchivoArbol2(String archivoS, int viejoId, int nuevoId) throws IOException {
        RandomAccessFile archivo = null;
        try {
            archivo = new RandomAccessFile(archivoS, "r");
            System.out.println("El tamaño es: " + archivo.length());
            String cad="";
            archivo.readLine();
            while(true) {
                cad = archivo.readLine();
                if (cad==null) break;
                ListaEstatica valores = Separador.separar(cad, ",");
                NodoBusquedaArbol nuevoNodo = new NodoBusquedaArbol(valores.obtener(viejoId), archivo.getFilePointer());
                if(arbol2.buscar(valores.obtener(viejoId)) == null){
                    ArbolBinarioBusqueda auxiliar = new ArbolBinarioBusqueda();
                    auxiliar.agregar(valores.obtener(viejoId));
                    nuevoNodo.setIndice(valores.obtener(nuevoId));
                    auxiliar.agregar(nuevoNodo);
                    arbol2.agregar(auxiliar);
                } else {
                    ArbolBinarioBusqueda auxiliar = (ArbolBinarioBusqueda) arbol2.buscar(valores.obtener(viejoId));
                    nuevoNodo.setIndice(valores.obtener(nuevoId));
                    auxiliar.agregar(nuevoNodo);
                }
            }
        } catch (IOException fe) {
            System.out.println("No se encontro el archivo");
        }
        archivo.close();
    }

    /**
     * Imprime el árbol perteneciente a la primera tabla.
     */
    public void primerArbolInnorden(){
        arbol1.innorden();
    }

    /**
     * Imprime el árbol perteneciente a la segunda tabla.
     */
    public void segundoArbolInnorden(){
        segundoArbolInnorder(arbol2.raiz);
    }

    /**
     * Imprime el árbol completo y si un nodo es un árbol, ese árbol lo imprime de manera innorden.
     * @param subraiz Sub raíz en la que se encuentra.
     */
    private void segundoArbolInnorder(NodoDoble subraiz){
        if (subraiz != null){
            segundoArbolInnorder(subraiz.getApuntadorAIzquierda());
            if(subraiz.getInfo() instanceof ArbolBinarioBusqueda arbolHijo){
                SalidaPorDefecto.terminal(" { ");
                arbolHijo.innorden();
                SalidaPorDefecto.terminal(" } ");
            } else {
                SalidaPorDefecto.terminal(subraiz.getInfo() + " ");
            }
            segundoArbolInnorder(subraiz.getApuntadorADerecha());
        }
    }
}
