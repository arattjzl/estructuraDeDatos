package pruebas;

import utils.imagen.ArchivoImagen;

import java.awt.*;

public class PruebaImgen {
    public static void main(String[] args) {
        ArchivoImagen imagen = new ArchivoImagen("C:\\Users\\aratt\\workspace\\escuela\\imagen.jpg");
        imagen.leerImagen();
        imagen.negativo();
        imagen.escribirImagen();
    }
}
