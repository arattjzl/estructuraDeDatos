package utils.imagen;

import entradasalida.SalidaPorDefecto;
import estructurasLineales.ListaEstaticaNumerica;
import estructurasNoLineales.Matriz2Numerica;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

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
            nomArchivo = file.getName();
            rutaArchivo = file.getParent();
            height = imagen.getHeight();
            width = imagen.getWidth();
            imagen2 = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        } catch (Exception e){
            System.err.println(e);
        }
    }

    public void leerImagen() {
        try {
            imagen = ImageIO.read(new File(archivo));
            matrizImagen = new Matriz2Numerica(imagen.getHeight(), imagen.getWidth());
            for(int cadaHeight = 0; cadaHeight < height; cadaHeight++){
                for(int cadaWidth = 0; cadaWidth < width; cadaWidth++){
                    ListaEstaticaNumerica lista = new ListaEstaticaNumerica(4);
                    int alpha = imagen.getColorModel().getAlpha(imagen.getRGB(cadaHeight, cadaWidth));
                    int red = imagen.getColorModel().getRed(imagen.getRGB(cadaHeight, cadaWidth));
                    int green = imagen.getColorModel().getGreen(imagen.getRGB(cadaHeight, cadaWidth));
                    int blue = imagen.getColorModel().getBlue(imagen.getRGB(cadaHeight, cadaWidth));
                    lista.agregar(alpha);
                    lista.agregar(red);
                    lista.agregar(green);
                    lista.agregar(blue);
                }
            }
        } catch (Exception e) {
        }
    }

    public void escribirAudio(){
        try {
            File file = new File(rutaArchivo + "/2_" + nomArchivo);
            for(int cadaHeight = 0; cadaHeight < height; cadaHeight++){
                for(int cadaWidth = 0; cadaWidth < width; cadaWidth++){
                    String concatenacion = "";
                    for(int valorLista = 0; valorLista < li)
                }
            }
            ImageIO.write(imagen2, "JPEG", file);
        } catch (Exception e){
        }
    }
}
