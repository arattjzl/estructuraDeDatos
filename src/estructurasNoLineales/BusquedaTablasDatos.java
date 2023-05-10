package estructurasNoLineales;

import entradasalida.SalidaPorDefecto;
import estructurasLineales.ListaEstatica;
import estructurasLineales.auxiliares.NodoDoble;
import estructurasNoLineales.auxiliares.NodoBusquedaArbol;
import utils.commons.Comparador;
import utils.commons.Separador;

import java.io.IOException;
import java.io.RandomAccessFile;

public class BusquedaTablasDatos {
    protected ArbolBinarioBusqueda arbol1;
    protected ArbolBinarioBusqueda arbol2;

    public BusquedaTablasDatos(){
        arbol1 = new ArbolBinarioBusqueda();
        arbol2 = new ArbolBinarioBusqueda();
    }

    public void abrirArchivoArbol1(String archivoS, int posicion) throws IOException {
        boolean finArchivo = false;
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
                //System.out.println(" - " +cad);
//                if(posicionEsp == archivo.getFilePointer() ){
//
//                    System.out.println(archivo.readLine());
//                    //SalidaPorDefecto.terminal(archivo.readLine());
//                    //System.out.print("Pos: "+archivo.getFilePointer());
//                    //System.out.println(" - " +cad);
//                }
            }
        } catch (IOException fe) {
            System.out.println("No se encontro el archivo");
        }
        archivo.close();
    }

    public void abrirArchivoArbol2(String archivoS, int posicion) throws IOException {
        boolean finArchivo = false;
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
                NodoBusquedaArbol nuevoNodo = new NodoBusquedaArbol(valores.obtener(posicion), archivo.getFilePointer());
                if(arbol2.buscar(valores.obtener(posicion)) == null){
                    ArbolBinarioBusqueda auxiliar = new ArbolBinarioBusqueda();
                    auxiliar.agregar(nuevoNodo);
                    arbol2.agregar(auxiliar);
                } else {
                    NodoDoble raizArbol = arbol2.raiz;
                    ArbolBinarioBusqueda auxiliar = buscarArbolAux(raizArbol, valores.obtener(posicion));
                    auxiliar.agregar(nuevoNodo);
                }
                //System.out.println(" - " +cad);
//                if(posicionEsp == archivo.getFilePointer() ){
//
//                    System.out.println(archivo.readLine());
//                    //SalidaPorDefecto.terminal(archivo.readLine());
//                    //System.out.print("Pos: "+archivo.getFilePointer());
//                    //System.out.println(" - " +cad);
//                }
            }
        } catch (IOException fe) {
            System.out.println("No se encontro el archivo");
        }
        archivo.close();
    }

    private ArbolBinarioBusqueda buscarArbolAux(NodoDoble arbolBase, Object porAgregar){
        if((int) Comparador.comparar(arbolBase.getInfo(), porAgregar) == 0){
            return (ArbolBinarioBusqueda) arbolBase.getInfo();
        } else if((int) Comparador.comparar(arbolBase.getInfo(), porAgregar) > 0){
            buscarArbolAux(arbolBase.getApuntadorAIzquierda(), porAgregar);
        } else {
            buscarArbolAux(arbolBase.getApuntadorADerecha(), porAgregar);
        }
        return null;
    }

    public void primerArbolInnorden(){
        arbol1.innorden();
    }

    public void segundoArbolInnorden(){
        segundoArbolInnorder(arbol2.raiz);
    }

    private void segundoArbolInnorder(NodoDoble subraiz){
        if (subraiz != null){
            segundoArbolInnorder(subraiz.getApuntadorAIzquierda());
            if(subraiz.getInfo() instanceof ArbolBinarioBusqueda arbolHijo){
                arbolHijo.innorden();
            } else {
                SalidaPorDefecto.terminal(subraiz.getInfo() + " ");
            }
            segundoArbolInnorder(subraiz.getApuntadorADerecha());
        }
    }
}
