package estructurasLineales;

import entradasalida.SalidaPorDefecto;
import utils.commons.Comparador;
import utils.commons.TipoPrioridad;

/**
 * Clase que contiene los métodos de cola de prioridad.
 * @author Aratt
 * @version 1.0
 */
public class ColaEstaticaPrioridad extends ColaEstatica {

    protected ListaEstaticaNumerica prioridades;
    protected TipoPrioridad tipoPrioridad;

    public ColaEstaticaPrioridad(int tamanio, TipoPrioridad tipoPrioridad) {
        super(tamanio);
        prioridades = new ListaEstaticaNumerica(getMAXIMO());
        this.tipoPrioridad = tipoPrioridad;
    }

    /**
     * Inserta la información dependiendo de la prioridad que se defina.
     * @param info Información que se insertará.
     * @param prioridad Prioridad de dicha información.
     * @return Regresa <b>true</b> si se pudo insertar el valor y <b>false</b> si no se pudo insertar.
     */
    public boolean agregar(Object info, int prioridad){
        boolean infoAgregada = poner(info);
        if(infoAgregada){
            prioridades.agregar(prioridad);
            if(tipoPrioridad == TipoPrioridad.MAYOR_MENOR){
                ordenarMayorMenor();
            } else {
                ordenarMenorMayor();
            }
        }
        return infoAgregada;
    }

    /**
     * Ordena la lista de mayor a menor por la prioridad que tenga la información.
     */
    public void ordenarMayorMenor(){
        for(int cadaPos = 0; cadaPos < getFin(); cadaPos++){
            for(int siguientePos = cadaPos+1; siguientePos <= getFin(); siguientePos++){
                if((int)Comparador.comparar(prioridades.obtener(cadaPos), prioridades.obtener(siguientePos)) < 0){
                    int prioridadRespaldo = (int) prioridades.obtener(cadaPos);
                    Object infoRespaldo = informacion[cadaPos];
                    prioridades.cambiar(cadaPos, prioridades.obtener(siguientePos));
                    prioridades.cambiar(siguientePos, prioridadRespaldo);
                    informacion[cadaPos] = informacion[siguientePos];
                    informacion[siguientePos] = infoRespaldo;
                }
            }
        }
    }

    /**
     * Ordena la lista de mayor a menor por la prioridad que tenga la información.
     */
    public void ordenarMenorMayor(){
        for(int cadaPos = 0; cadaPos < getFin(); cadaPos++){
            for(int siguientePos = cadaPos+1; siguientePos <= getFin(); siguientePos++){
                if((int)Comparador.comparar(prioridades.obtener(cadaPos), prioridades.obtener(siguientePos)) > 0){
                    int prioridadRespaldo = (int) prioridades.obtener(cadaPos);
                    Object infoRespaldo = informacion[cadaPos];
                    prioridades.cambiar(cadaPos, prioridades.obtener(siguientePos));
                    prioridades.cambiar(siguientePos, prioridadRespaldo);
                    informacion[cadaPos] = informacion[siguientePos];
                    informacion[siguientePos] = infoRespaldo;
                }
            }
        }
    }
}
