package pruebas;

import entradasalida.SalidaPorDefecto;
import estructurasLineales.ListaEstatica;
import registros.competenciasAtleticas.ControlCompeteneciaAtletica;
import registros.competenciasAtleticas.Corredor;
import registros.competenciasAtleticas.EventoCompetencia;

public class PruebaCompetenciaCorredores {
    public static void main(String[] args) {
        ControlCompeteneciaAtletica competencias = new ControlCompeteneciaAtletica(4,3,5);
        competencias.agregarAnio(1989);
        competencias.agregarAnio(2002);
        competencias.agregarAnio(2013);
        competencias.agregarAnio(2021);

        Corredor corredor1 = new Corredor("Duki", 101, 24, "Argentino");
        Corredor corredor2 = new Corredor("Luis", 201, 19, "Mexicano");
        Corredor corredor3 = new Corredor("Messi", 301, 37, "Argentino");

        competencias.agregarCorredor(corredor1);
        competencias.agregarCorredor(corredor2);
        competencias.agregarCorredor(corredor3);

        EventoCompetencia evento1 = new EventoCompetencia("Viva la alegria", "Mexico");
        EventoCompetencia evento2 = new EventoCompetencia("Lola", "Argentina");
        EventoCompetencia evento3 = new EventoCompetencia("Algo mal", "Peru");
        EventoCompetencia evento4 = new EventoCompetencia("Californication", "California");
        EventoCompetencia evento5 = new EventoCompetencia("Otro evento", "No se");

        competencias.agregarEvento(evento1);
        competencias.agregarEvento(evento2);
        competencias.agregarEvento(evento3);
        competencias.agregarEvento(evento4);
        competencias.agregarEvento(evento5);

        competencias.agregarKm(2021,301,"Algo mal",307.8);
        competencias.agregarKm(2002,101,"Lola",500.4);
        competencias.agregarKm(2021,101,"Lola",281.3);
        competencias.agregarKm(1989,201,"Californication",198.8);

        competencias.imprimirDatosCompetencia();

        //Invocación a preguntas comunes:
        //Indicar los kilómetros recorridos de Lencho en "Viva la vida"
        //en los años 2000, 2005, 2019, 2020

        ListaEstatica aniosPedidosCorredor = new ListaEstatica(3);
        aniosPedidosCorredor.agregar(2002);
        aniosPedidosCorredor.agregar(2021);
        aniosPedidosCorredor.agregar(1989);

        double kmPedidos = competencias.kmPorCorredorPorEvento(101, "Lola", aniosPedidosCorredor);

        SalidaPorDefecto.terminal("La salida acumulada de kms de la solicitud es: " + kmPedidos);
    }
}
