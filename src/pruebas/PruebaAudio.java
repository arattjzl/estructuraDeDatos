package pruebas;


import entradasalida.SalidaPorDefecto;
import estructurasLineales.ListaEstaticaNumerica;
import utils.commons.archivosAudio.AudioFileRecord;

public class PruebaAudio {
    public static void main(String[] args) {
        AudioFileRecord audio = new AudioFileRecord("C:\\Users\\aratt\\workspace\\escuela\\nuevaVocal.wav");

        audio.leerAudio();
        SalidaPorDefecto.terminal(audio.energia() + "\n");

        cualVocal(audio);

    }

    public static void cualVocal(AudioFileRecord vocal){
        AudioFileRecord vocalA = new AudioFileRecord("C:\\Users\\aratt\\workspace\\escuela\\archivoA.wav");
        AudioFileRecord vocalE = new AudioFileRecord("C:\\Users\\aratt\\workspace\\escuela\\archivoE.wav");
        AudioFileRecord vocalI = new AudioFileRecord("C:\\Users\\aratt\\workspace\\escuela\\archivoI.wav");
        AudioFileRecord vocalO = new AudioFileRecord("C:\\Users\\aratt\\workspace\\escuela\\archivoO.wav");
        AudioFileRecord vocalU = new AudioFileRecord("C:\\Users\\aratt\\workspace\\escuela\\archivoU.wav");

        vocalA.leerAudio();
        vocalE.leerAudio();
        vocalI.leerAudio();
        vocalO.leerAudio();
        vocalU.leerAudio();


        SalidaPorDefecto.terminal("\nA  " + vocalA.energia() + "\nE  " + vocalE.energia() + "\nI  " + vocalI.energia() + "\nO  " + vocalO.energia() + "\nU  " + vocalU.energia());
    }
}
