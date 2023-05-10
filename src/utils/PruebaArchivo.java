package utils;

import entradasalida.SalidaPorDefecto;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class PruebaArchivo {
    public void verArchivo(String archivoS, int posicionEsp) throws IOException {
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

                if (cad==null)
                    break;
                System.out.println(" - " +cad);
//                if(posicionEsp == archivo.getFilePointer() ){
//                    archivo.seek(archivo.getFilePointer());
//                    System.out.println(archivo.readLine());
//                    //SalidaPorDefecto.terminal(archivo.readLine());
//                    //System.out.print("Pos: "+archivo.getFilePointer());
//                    //System.out.println(" - " +cad);
//                }
            }
        } catch (IOException fe) {
            System.out.println("No se encontro el archivo");
        }
//        System.out.println("\n");
//        archivo.seek(9071);
//        System.out.println(archivo.readLine());
//        System.out.println("\n");
        archivo.close();
    }

    public static void main(String[] args) throws IOException {
        PruebaArchivo archivo = new PruebaArchivo();
        archivo.verArchivo("C:\\Users\\aratt\\workspace\\escuela\\datos_ordenes\\order_items.txt", 63);
    }
}
