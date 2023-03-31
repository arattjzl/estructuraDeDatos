package pruebas;

import entradasalida.SalidaPorDefecto;
import estructurasLineales.ListaDinamica;
import registros.usoComputadoras.*;

import java.time.LocalDateTime;

public class PruebasControlCentroComputo {
    public static void main(String[] args) {
        // CENTRO DE COMPUTO
        ControlCentroComputo controlCentroComputo = new ControlCentroComputo();

        // COMPUTADORAS
        Computadora comp1 = new Computadora(1, 1, 16, 512, "i511th", "MSI");
        Computadora comp2 = new Computadora(2, 1, 16, 256, "r5", "Huawei");
        Computadora comp3 = new Computadora(3, 2, 8, 512, "M1", "Apple");
        Computadora comp4 = new Computadora(4, 2, 4, 1000, "i37th", "Toshiba");
        Computadora comp5 = new Computadora(5, 5, 8, 256, "r3", "Xiaomi");

        // APLICACIONES
        App app1 = new App("Discord", 'd', "Aratt Juarez", "3.5", 4);
        App app2 = new App("Chrome", 'c', "Alguien", "2.5", 2);
        App app3 = new App("Warzone", 'w', "activision", "5.3", 12);
        App app4 = new App("Soundcloud", 's', "alguien mas", "10.23", 2);
        App app5 = new App("Netflix", 'n', "los de netflix", "34.4", 8);

        // Usuarios
        Usuario usuario1 = new Usuario("Isaac");
        Usuario usuario2 = new Usuario("Armando");
        Usuario usuario3 = new Usuario("Regina");
        Usuario usuario4 = new Usuario("Maribel");
        Usuario usuario5 = new Usuario("Jager");

        // UsoComputadora
        UsoComputadora usoComputadora1 = new UsoComputadora(usuario1, "3/4/2022", "12:45");
        UsoComputadora usoComputadora2 = new UsoComputadora(usuario2, "4/8/2022", "1:12");
        UsoComputadora usoComputadora3 = new UsoComputadora(usuario3, "12/9/2022", "2:00");
        UsoComputadora usoComputadora4 = new UsoComputadora(usuario4, "1/10/2022", "3:45");
        UsoComputadora usoComputadora5 = new UsoComputadora(usuario5, "30/10/2022", "4:00");

        ListaDinamica todosUsuarios = new ListaDinamica();

        todosUsuarios.agregar(usuario1);
        todosUsuarios.agregar(usuario2);
        todosUsuarios.agregar(usuario3);
        todosUsuarios.agregar(usuario4);
        todosUsuarios.agregar(usuario5);

        controlCentroComputo.setTodosUsuarios(todosUsuarios);

        usoComputadora1.agregarAppUtilizada(app1);
        usoComputadora1.agregarAppUtilizada(app3);
        usoComputadora1.agregarAppUtilizada(app4);
        usoComputadora1.agregarAppUtilizada(app5);

        ListaDinamica listaApps = new ListaDinamica();
        listaApps.agregar(app1);
        listaApps.agregar(app3);
        listaApps.agregar(app5);

        comp1.agregarApp(app2);
        comp1.agregarApp(app1);
        comp1.agregarApp(app4);
        comp2.agregarApp(app5);
        comp2.agregarApp(app4);
        comp3.agregarApp(app2);
        comp4.agregarApp(app1);
        comp4.agregarApp(app2);
        comp5.agregarApp(app3);

        comp2.iniciarUsoComputadora(usoComputadora1);
        comp2.iniciarUsoComputadora(usoComputadora3);
        comp2.iniciarUsoComputadora(usoComputadora5);

        controlCentroComputo.agregarComputadora(comp1);
        controlCentroComputo.agregarComputadora(comp2);
        controlCentroComputo.agregarComputadora(comp3);
        controlCentroComputo.agregarComputadora(comp4);
        controlCentroComputo.agregarComputadora(comp5);

        SalidaPorDefecto.terminal("\n");

        controlCentroComputo.imprimirCaracteristicaComputadora(2);
    }
}
