package examenes.parcial1;

import estructurasLineales.ListaEstatica;
import java.io.*;

/**
 * Esta clase contiene los métodos para poder leer y escribir un archivo mediante su ruta de acceso.
 */
public class ArchivoTexto {

    public static ListaEstatica leer(String archivo){
        FileReader input=null;
        int registro=0;
        ListaEstatica datos=null;
        BufferedReader buffer = null;

        try {
            String cadena;
            input = new FileReader(archivo);
            buffer = new BufferedReader(input);
            datos=new ListaEstatica((int)buffer.lines().count());
            buffer.close();
            input.close();
            input = new FileReader(archivo);
            buffer = new BufferedReader(input);
            while((cadena = buffer.readLine())!=null) {
                datos.agregar(cadena);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try{
                input.close();
                buffer.close();
            }catch(IOException e){
                e.printStackTrace();
            }
        }
        return datos;
    }
    public static void escribir(ListaEstatica arreglo, String archivo){
        FileWriter output=null;
        try {
            output = new FileWriter(archivo);
            for(int posicion=0;posicion<arreglo.getMAXIMO() -1 ;posicion++) {
                output.write((String)arreglo.obtener(posicion)+ "\n");
            }
            output.write((String)arreglo.obtener(arreglo.getMAXIMO() - 1));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try{
                output.close();
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }
}