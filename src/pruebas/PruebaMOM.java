package pruebas;

import entradasalida.SalidaPorDefecto;
import registros.probabilidad.ModeloOcultoMarkov;
import vistas.VentanaPrincipal;

public class PruebaMOM {
    public static void main(String[] args) {
        ModeloOcultoMarkov mom = new ModeloOcultoMarkov(4);
        mom.agregarEstado("Exploracion", 0.4);
        mom.agregarEstado("Compra", 0.3);
        mom.agregarEstado("Retorno", 0.2);
        mom.agregarEstado("Abandono", 0.1);

                //TRANSICION//
        mom.agregarProbabilidadTransicion("Exploracion", "Exploracion", 0.6);
        mom.agregarProbabilidadTransicion("Exploracion", "Compra", 0.2);
        mom.agregarProbabilidadTransicion("Exploracion", "Retorno", 0.1);
        mom.agregarProbabilidadTransicion("Exploracion", "Abandono", 0.1);

        mom.agregarProbabilidadTransicion("Compra", "Exploracion", 0.1);
        mom.agregarProbabilidadTransicion("Compra", "Compra", 0.5);
        mom.agregarProbabilidadTransicion("Compra", "Retorno", 0.3);
        mom.agregarProbabilidadTransicion("Compra", "Abandono", 0.1);

        mom.agregarProbabilidadTransicion("Retorno", "Exploracion", 0.3);
        mom.agregarProbabilidadTransicion("Retorno","Compra",0.1);
        mom.agregarProbabilidadTransicion("Retorno","Retorno", 0.4);
        mom.agregarProbabilidadTransicion("Retorno", "Abandono", 0.2);

        mom.agregarProbabilidadTransicion("Abandono", "Exploracion", 0.1);
        mom.agregarProbabilidadTransicion("Abandono", "Compra", 0.1);
        mom.agregarProbabilidadTransicion("Abandono", "Retorno", 0.1);
        mom.agregarProbabilidadTransicion("Abandono", "Abandono", 0.7);

                //EMISION//
        mom.agregarProbabilidadEmision("Exploracion", "Navegar", 0.6);
        mom.agregarProbabilidadEmision("Exploracion", "Agregar al carrito", 0.1);
        mom.agregarProbabilidadEmision("Exploracion", "Finalizar compra", 0.1);
        mom.agregarProbabilidadEmision("Exploracion", "Solicitar devolucion", 0.1);
        mom.agregarProbabilidadEmision("Exploracion", "Salir", 0.1);

        mom.agregarProbabilidadEmision("Compra","Navegar", 0.2);
        mom.agregarProbabilidadEmision("Compra", "Agregar al carrito", 0.4);
        mom.agregarProbabilidadEmision("Compra", "Finalizar compra", 0.2);
        mom.agregarProbabilidadEmision("Compra", "Solicitar devolucion", 0.1);
        mom.agregarProbabilidadEmision("Compra", "Salir", 0.1);

        mom.agregarProbabilidadEmision("Retorno", "Navegar", 0.2);
        mom.agregarProbabilidadEmision("Retorno", "Agregar al carrito", 0.2);
        mom.agregarProbabilidadEmision("Retorno", "Finalizar compra", 0.1);
        mom.agregarProbabilidadEmision("Retorno", "Solicitar devolucion", 0.4);
        mom.agregarProbabilidadEmision("Retorno", "Salir", 0.1);

        mom.agregarProbabilidadEmision("Abandono", "Navegar", 0.2);
        mom.agregarProbabilidadEmision("Abandono", "Agregar al carrito", 0.1);
        mom.agregarProbabilidadEmision("Abandono", "Finalizar compra", 0.1);
        mom.agregarProbabilidadEmision("Abandono", "Solicitar devolucion", 0.5);
        mom.agregarProbabilidadEmision("Abandono", "Salir", 0.5);

        SalidaPorDefecto.terminal(mom.inicioEstado("Compra") + "\n");

        SalidaPorDefecto.terminal(mom.probabilidadDeRealizarActividad("Abandono", "Salir") + "\n");

        SalidaPorDefecto.terminal(mom.probabilidadCiertoEstado("Exploracion", "Compra") + "\n");

        SalidaPorDefecto.terminal(mom.pobabilidadDeSecuenciaDeEstados("Abandono,Compra,Abandono,Retorno,Exploracion") + "\n");

        VentanaPrincipal ventana = new VentanaPrincipal(mom);
    }
}
