package registros.constructora;

import entradasalida.EntradaPorDefecto;
import entradasalida.SalidaPorDefecto;
import estructurasLineales.ListaDinamica;
import estructurasLineales.auxiliares.Nodo;

import java.time.LocalDate;

public class MenuConstructora {
    public static void main(String[] args) {
//        Sucursal sucursal1 = new Sucursal(1, "Sucursal Isaac");
//        Sucursal sucursal2 = new Sucursal(2, "Sucursal Regina");
//        Sucursal sucursal3 = new Sucursal(3, "Sucursal Aratt");
//
//        Trabajador trabajador1 = new Trabajador("Juan", "Gonzales");
//        Trabajador trabajador2 = new Trabajador("Pancho", "Perez");
//        Trabajador trabajador3 = new Trabajador("Saul", "Luna");
//        Trabajador trabajador4 = new Trabajador("Valeria", "Loera");
//        Trabajador trabajador5 = new Trabajador("Sandra", "Andrade");
//        Trabajador trabajador6 = new Trabajador("Emiliano", "Palacios");
//        Trabajador trabajador7 = new Trabajador("Eduardo", "Reveles");
//        Trabajador trabajador8 = new Trabajador("Cesar", "Marquez");
//        Trabajador trabajador9 = new Trabajador("Carlos", "Martinez");
//        Trabajador trabajador10 = new Trabajador("Said", "Contreras");
//
//        Obra obra1 = new Obra("Hospital",  "Zacatecas", 890000, LocalDate.of(2023,6,12),
//                "Iniciando", trabajador1, "Hospital de 5 pisos");
//        Obra obra2 = new Obra("Carretera",  "Guadalupe", 1350000, LocalDate.of(2022,7,25),
//                "Obra negra", trabajador2, "Carretera de Siglo XXI a Guadalupe");
//
//        sucursal1.agregarObra(obra1);
//        sucursal1.agregarObra(obra2);
//
//        sucursal1.imprimirObras();

        ListaDinamica sucursales = new ListaDinamica();
        ListaDinamica obras = new ListaDinamica();
        ListaDinamica trabajadores = new ListaDinamica();
        String opcion;
        do {
            SalidaPorDefecto.terminal("""
                a. Dar de alta sucursal
                b. Dar de alta obra
                c. Dar de alta trabajador
                d. Listar obras de sucursal
                e. Borrar una obra
                f. Buscar obra con base a descripcion
                g. Buscar el encargado de la obra
                q. Salir
                """);

             opcion = EntradaPorDefecto.consolaCadenas();

            switch (opcion) {
                case "a":
                    sucursales.imprimir();
                    SalidaPorDefecto.terminal("\nNumero de sucursal\n");
                    int num = EntradaPorDefecto.consolaDouble().intValue();

                    SalidaPorDefecto.terminal("Estado en el que se encuentra la sucursal\n");
                    String estado = EntradaPorDefecto.consolaCadenas();

                    Sucursal nuevaSucursal = new Sucursal(num, estado);
                    SalidaPorDefecto.terminal(nuevaSucursal + "");
                    sucursales.agregar(nuevaSucursal);
                    break;
                case "b":
                    SalidaPorDefecto.terminal("Tipo de construccion\n");
                    String construccion = EntradaPorDefecto.consolaCadenas();

                    SalidaPorDefecto.terminal("Localizacion\n");
                    String localizacion = EntradaPorDefecto.consolaCadenas();

                    SalidaPorDefecto.terminal("Presupuesto\n");
                    Double presupuesto = EntradaPorDefecto.consolaDouble();

                    SalidaPorDefecto.terminal("Año de fecha\n");
                    int anio = EntradaPorDefecto.consolaDouble().intValue();

                    SalidaPorDefecto.terminal("Mes de fecha\n");
                    int mes = EntradaPorDefecto.consolaDouble().intValue();

                    SalidaPorDefecto.terminal("Dia de fecha\n");
                    int dia = EntradaPorDefecto.consolaDouble().intValue();

                    SalidaPorDefecto.terminal("Estado de obra\n");
                    String estadoObra = EntradaPorDefecto.consolaCadenas();

                    SalidaPorDefecto.terminal("Descripcion\n");
                    String descripcion = EntradaPorDefecto.consolaCadenas();

                    SalidaPorDefecto.terminal("Nombre del encargado\n");
                    String nomEnc = EntradaPorDefecto.consolaCadenas();

                    SalidaPorDefecto.terminal("Apellido del encargado\n");
                    String apEnc = EntradaPorDefecto.consolaCadenas();

                    Trabajador encargado = new Trabajador(nomEnc, apEnc);

                    Obra nuevaObra = new Obra(construccion, localizacion, presupuesto, LocalDate.of(anio, mes, dia), estadoObra, encargado, descripcion);

                    sucursales.imprimir();

                    SalidaPorDefecto.terminal("\n\nQue sucursal es la que se encarga de la obra\n");
                    int sucNum = EntradaPorDefecto.consolaDouble().intValue();

                    Nodo nodosuc = (Nodo) sucursales.obtener(sucNum-1);
                    Sucursal suc = (Sucursal) nodosuc.getInfo();

                    suc.agregarObra(nuevaObra);
                    break;
                case "c":
                    SalidaPorDefecto.terminal("Nombre del trabajador\n");
                    String nomTrab = EntradaPorDefecto.consolaCadenas();

                    SalidaPorDefecto.terminal("Apellido del trabajador\n");
                    String apTrab = EntradaPorDefecto.consolaCadenas();

                    Trabajador nuevoTrabajador = new Trabajador(nomTrab, apTrab);

                    sucursales.imprimir();
                    SalidaPorDefecto.terminal("\nSeleccione el num de sucursal\n");
                    int seleccio = EntradaPorDefecto.consolaDouble().intValue();

                    sucursales.inicializarIterador();
                    while(sucursales.hayNodo()){
                        Sucursal cadaSuc = (Sucursal) sucursales.obtenerNodo();
                        if(cadaSuc.getNumSucursal() == seleccio){
                            cadaSuc.imprimirObras();
                            SalidaPorDefecto.terminal("Ingrese la obra en la que se agregara el trabajador (empezando a 0) \n");
                            int indice = EntradaPorDefecto.consolaDouble().intValue();
                            Nodo nobr = (Nodo) cadaSuc.obras.obtener(indice);
                            Obra obr = (Obra) nobr.getInfo();
                            obr.agregarTrabajador(nuevoTrabajador);
                        }
                    }
                    trabajadores.agregar(nuevoTrabajador);
                    break;
                case "d":
                    sucursales.imprimir();
                    SalidaPorDefecto.terminal("\nSeleccione el num de sucursal\n");
                    int seleccion = EntradaPorDefecto.consolaDouble().intValue();

                    sucursales.inicializarIterador();
                    while(sucursales.hayNodo()){
                        Sucursal cadaSuc = (Sucursal) sucursales.obtenerNodo();
                        if(cadaSuc.getNumSucursal() == seleccion){
                            cadaSuc.imprimirObras();
                        }
                    }
                    break;
                case "e":
                    sucursales.imprimir();
                    SalidaPorDefecto.terminal("\nSeleccione el num de sucursal\n");
                    int seleccion1 = EntradaPorDefecto.consolaDouble().intValue();

                    sucursales.inicializarIterador();
                    while(sucursales.hayNodo()){
                        Sucursal cadaSuc = (Sucursal) sucursales.obtenerNodo();
                        if(cadaSuc.getNumSucursal() == seleccion1){
                            cadaSuc.imprimirObras();
                            SalidaPorDefecto.terminal("Ingrese el indice a borar (empezando de 0) \n");
                            int indiceBorrar = EntradaPorDefecto.consolaDouble().intValue();
                            cadaSuc.obras.eliminarObjeto(cadaSuc.obras.obtener(indiceBorrar));
                        }
                    }
                    break;
                case "f":
                    SalidaPorDefecto.terminal("\nIngresa la descripcion\n");
                    String desc = EntradaPorDefecto.consolaCadenas();

                    sucursales.inicializarIterador();
                    while (sucursales.hayNodo()){
                        Sucursal cadasucursal = (Sucursal) sucursales.obtenerNodo();
                        cadasucursal.obras.inicializarIterador();
                        while (cadasucursal.obras.hayNodo()){
                            Obra cadaobra = (Obra) cadasucursal.obras.obtenerNodo();
                            if(cadaobra.descripcion.equalsIgnoreCase(desc)){
                                SalidaPorDefecto.terminal("\n" + cadaobra + "\n");
                            }
                        }
                    }
                    break;
                case "g":
                    sucursales.imprimir();
                    SalidaPorDefecto.terminal("\nElija la sucursal\n");
                    int elegir = EntradaPorDefecto.consolaDouble().intValue();

                    sucursales.inicializarIterador();
                    while (sucursales.hayNodo()){
                        Sucursal cs = (Sucursal) sucursales.obtenerNodo();
                        if(cs.numSucursal == elegir){
                            cs.imprimirObras();
                            SalidaPorDefecto.terminal("Elige una obra (indice empezando de 0)\n");
                            int eleccion = EntradaPorDefecto.consolaDouble().intValue();

                            Nodo nob = (Nodo) cs.obras.obtener(eleccion);
                            Obra ob = (Obra) nob.getInfo();
                            SalidaPorDefecto.terminal("Encargado: " + ob.getEncargado().nombre + " " + ob.getEncargado().getApellido()+ "\n\n");
                        }
                    }
                    break;
                case "h":
                    sucursales.imprimir();
                    SalidaPorDefecto.terminal("\nElija la sucursal\n");
                    int elegi = EntradaPorDefecto.consolaDouble().intValue();

                    sucursales.inicializarIterador();
                    while (sucursales.hayNodo()){
                        Sucursal cs = (Sucursal) sucursales.obtenerNodo();
                        if(cs.numSucursal == elegi){
                            cs.imprimirObras();
                            SalidaPorDefecto.terminal("Elige una obra (indice empezando de 0)\n");
                            int eleccion = EntradaPorDefecto.consolaDouble().intValue();

                            Obra ob = (Obra) cs.obras.obtener(eleccion);
                            SalidaPorDefecto.terminal("Presupuesto: " + ob.getPresupuesto()+"\n");

                        }
                    }
                    break;
            }
        } while (opcion != "q");
    }
}
