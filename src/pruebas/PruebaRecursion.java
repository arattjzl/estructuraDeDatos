package pruebas;

import entradasalida.SalidaPorDefecto;
import estructurasLineales.ListaDinamicaClave;
import utils.PalabraDiccionario;
import utils.matematicas.ExpresionesMatematicas;

public class PruebaRecursion {
    public static void main(String[] args) {
        ListaDinamicaClave lista = new ListaDinamicaClave();

        PalabraDiccionario adios = new PalabraDiccionario("adios", "para despedirse", "hasta luego", "para despedirse");
        PalabraDiccionario hola = new PalabraDiccionario("hola", "para saludar, antonimo de adios", "buen dia", "para saludar");
        PalabraDiccionario hastaLuego = new PalabraDiccionario("hasta luego", "para despedirse, similar a adios", "adios", "para despedirse");
        PalabraDiccionario comoEstas = new PalabraDiccionario("como estas", "para saludar", "como te encuentras", "para preguntar un estado de animo");

        lista.agregar("adios", adios);
        lista.agregar("hola", hola);
        lista.agregar("hasta luego", hastaLuego);
        lista.agregar("como estas", comoEstas);

        lista.buscarPalabraClave("adios");
    }
}
