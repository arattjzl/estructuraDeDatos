package utils.imagen;

import estructurasNoLineales.Matriz2Numerica;
import utils.commons.TipoInvertir;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * @author Aratt
 * @version 1.0
 */
public class ArchivoImagen {
    public BufferedImage imagen;
    public BufferedImage imagen2;
    public Matriz2Numerica matrizImagen;
    public int width;
    public int height;
    public String archivo;
    public String nomArchivo;
    public String rutaArchivo;

    public ArchivoImagen(String archivo){
        this.archivo = archivo;
        try{
            File file = new File(archivo);
            leerImagen();
            nomArchivo = file.getName();
            rutaArchivo = file.getParent();
            height = imagen.getHeight();
            width = imagen.getWidth();
        } catch (Exception e){
            System.err.println(e);
        }
    }

    /**
     * Obtiene el valor de width.
     * @return Regresa el valor que tiene width.
     */
    public int getWidth() {
        return width;
    }

    /**
     * Cambia el valor de width.
     * @param width Es el valor por el cual se cambiará width.
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * Obtiene el valor de height.
     * @return Es el valor por el cual se cambiará height.
     */
    public int getHeight() {
        return height;
    }

    /**
     * Cambia el valor de height.
     * @param height Es el valor por el cual se cambiará height.
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * Lee la imagen y pasa los valores de los pixeles a una matriz bidimensional numérica.
     */
    public void leerImagen() {
        try {
            imagen = ImageIO.read(new File(archivo));
            matrizImagen = new Matriz2Numerica(imagen.getWidth(), imagen.getHeight());
            for(int cadaHeight = 0; cadaHeight < height; cadaHeight++){
                for(int cadaWidth = 0; cadaWidth < width; cadaWidth++){
                    matrizImagen.cambiar(cadaWidth, cadaHeight, imagen.getRGB(cadaWidth, cadaHeight));
                }
            }
        } catch (Exception e) {
        }
    }

    /**
     * Escribe la imagen ya cambiada a la imagen nueva.
     */
    public void escribirImagen(){
        try {
            imagen2 = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
            File file = new File(rutaArchivo + "/2_" + nomArchivo);
            for(int cadaHeight = 0; cadaHeight < height; cadaHeight++){
                for(int cadaWidth = 0; cadaWidth < width; cadaWidth++){
                    imagen2.setRGB(cadaWidth, cadaHeight, (int)matrizImagen.obtener(cadaWidth, cadaHeight));
                }
            }
            ImageIO.write(imagen2, "JPEG", file);
        } catch (Exception e){
        }
    }

    /**
     * Cambia la imagen a escalas de grises.
     */
    public void aEscalaGrises( ){
        for(int cadaHeight = 0; cadaHeight < height; cadaHeight++){
            for(int cadaWidth = 0; cadaWidth < width; cadaWidth++){
                int pixel = imagen.getRGB(cadaWidth, cadaHeight);
                int alpha = pixel>>24 & 0xff;
                int red = pixel>>16 & 0xff;
                int green = pixel>>8 & 0xff;
                int blue = pixel & 0xff;
                int gris = (alpha+red+green+blue)/4;
                int nuevoPixel = (gris<<24) + (gris<<16) + (gris<<8) + (gris);
                matrizImagen.cambiar(cadaWidth,cadaHeight, nuevoPixel);
            }
        }
    }

    /**
     * Modifica el brillo de la imagen después de que se convierta a escalas de grises.
     * @param brillo
     */
    public void modificarBrillo(int brillo){
        for (int cadaHeight = 0; cadaHeight < height; cadaHeight++) {
            for (int cadaWidth = 0; cadaWidth < width; cadaWidth++) {
                int pixel = (imagen.getRGB(cadaWidth, cadaHeight))+brillo;
                int alpha = pixel >> 24 & 0xff;
                int red = pixel >> 16 & 0xff;
                int green = pixel >> 8 & 0xff;
                int blue = pixel & 0xff;
                int gris = (alpha + red + green + blue) / 4;
                int nuevoPixel = (gris << 24) + (gris << 16) + (gris << 8) + (gris);
                matrizImagen.cambiar(cadaWidth, cadaHeight, nuevoPixel);
            }
        }
    }

    /**
     * Le da a la imagen un efecto de espejo.
     */
    public void invertirImagen(){
        Matriz2Numerica matrizClonada = matrizImagen.clonar();
        for(int cadaHeight = 0; cadaHeight < height; cadaHeight++){
            int nuevoWidth = 0;
            for(int cadaWidth = width-1; cadaWidth >= 0; cadaWidth--){
                matrizImagen.cambiar(nuevoWidth, cadaHeight, matrizClonada.obtener(cadaWidth, cadaHeight));
                nuevoWidth++;
            }
            nuevoWidth = 0;
        }
    }

    /**
     * Pone la imagen de cabeza,
     */
    public void imagenDeCabeza(){
        Matriz2Numerica matrizClonada = matrizImagen.clonar();
        int nuevoHeight = 0;
        for(int cadaHeight = height-1; cadaHeight >= 0; cadaHeight--){
            int nuevoWidth = 0;
            for(int cadaWidth = 0; cadaWidth < width; cadaWidth++){
                matrizImagen.cambiar(nuevoWidth, nuevoHeight, matrizClonada.obtener(cadaWidth, cadaHeight));
                nuevoWidth++;
            }
            nuevoWidth = 0;
            nuevoHeight++;
        }
    }

    /**
     * Invierte la imagen a 90 grados.
     */
    public void imagenA90(){
        Matriz2Numerica matrizAuxliar = new Matriz2Numerica(height, width);
        for(int cadaHeight = width-1; cadaHeight >=0 ; cadaHeight--){
            int nuevoWidth =0;
            for(int cadaWidth = height-1; cadaWidth >=0 ; cadaWidth--){
                matrizAuxliar.cambiar(nuevoWidth, cadaHeight, matrizImagen.obtener(cadaHeight, cadaWidth));
                nuevoWidth++;
            }
        }
        setHeight(matrizAuxliar.getColumnas());
        setWidth(matrizAuxliar.getRenglones());
        matrizImagen.redefinir(matrizAuxliar);
    }

    /**
     * Invierte la imagen 180 grados.
     */
    public void imagenA180(){
        imagenA90();
        imagenA90();
    }

    /**
     * Invierte la imagen 270 grados.
     */
    public void imagenA270(){
        imagenA90();
        imagenA90();
        imagenA90();
    }

    /**
     * Invierte la imagen a lo que le digamos.
     * @param invertir Cuantos grados debemos de invertir.
     */
    public void imagenA(TipoInvertir invertir){
        if(invertir == TipoInvertir.A90){
            imagenA90();
        } else if(invertir == TipoInvertir.A180){
            imagenA180();
        }
        if(invertir == TipoInvertir.A270){
            imagenA270();
        }
    }

    /**
     * Realiza la transpuesta de la imagen.
     */
    public void transpuesta(){
        Matriz2Numerica matrizAuxiliar = matrizImagen.clonar();
        matrizAuxiliar.transpuesta();
        setWidth(matrizAuxiliar.getRenglones());
        setHeight(matrizAuxiliar.getColumnas());
        matrizImagen.redefinir(matrizAuxiliar);
    }

    /**
     * Crea un marco de los pixeles que se diga y rellena esos pixeles con un color.
     * @param pixeles Número de pixeles que será el marco.
     * @param color Color con el que se rellenará el marco.
     */
    public void nuevoMarco(int pixeles, Color color){
        int nuevoWidth = width+(2*pixeles);
        int nuevoHeight = height+(2*pixeles);
        Matriz2Numerica matrizAuxiliar = new Matriz2Numerica(nuevoWidth, nuevoHeight);
        for(int cadaHeight = 0; cadaHeight < nuevoHeight; cadaHeight++){
            for(int cadaWidth = 0; cadaWidth < nuevoWidth; cadaWidth++){
                matrizAuxiliar.cambiar(cadaWidth, cadaHeight, color.getRGB());
            }
        }
        for(int cadaHeight = pixeles; cadaHeight < nuevoHeight-pixeles; cadaHeight++){
            for(int cadaWidth = pixeles; cadaWidth <nuevoWidth-pixeles; cadaWidth++){
                matrizAuxiliar.cambiar(cadaWidth, cadaHeight, matrizImagen.obtener(cadaWidth-pixeles, cadaHeight-pixeles));
            }
        }
        setHeight(nuevoHeight);
        setWidth(nuevoWidth);
        matrizImagen.redefinir(matrizAuxiliar);
    }

    /**
     * Le saca el valor negativo del pixel a la imagen.
     */
    public void negativo(){
        for(int cadaHeight = 0; cadaHeight < height; cadaHeight++){
            for(int cadaWidth = 0; cadaWidth < width; cadaWidth++){
                matrizImagen.cambiar(cadaWidth, cadaHeight, (int)(matrizImagen.obtener(cadaWidth, cadaHeight))*-1);
            }
        }
    }
}
