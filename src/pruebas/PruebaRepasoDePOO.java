package pruebas;

import repasoDePOO.implementaciones.*;
import repasoDePOO.interfaces.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class PruebaRepasoDePOO {

    // Esta clase tiene como objetivo hacer pruebas sobre toda las clases en conjunto
    // realizando dadas de alta y consultas

    public static void main(String[] args) {
        IAlta alta;
        IConsulta consulta;
        Aeropuerto aeropuerto;
        Avion avion;
        Piloto piloto;
        Vuelo vuelo;
        LocalDate fecha;
        ArrayList<Avion> aviones = new ArrayList<>();
        ArrayList<Piloto> pilotos = new ArrayList<>();
        ArrayList<Aeropuerto> aeropuertos = new ArrayList<>();
        ArrayList<Vuelo> vuelos = new ArrayList<>();
        consulta = new Consulta();
        alta = new Alta();

        System.out.println("Elige una opcion");
        System.out.println("a)Dar de alta un avion\nb)Consultar por tipo de avion\nc)Dar de alta piloto\nd)Dar de alta aeropuerto\ne)Registra vuelos de origen a destino con cierto piloto\nf)Consultar vuelos por origen\ng)Consultar vuelos por destino\nh)Consultar aeropuertos por ciudad\nq)Salir\nz)Opciones");

        Scanner scan = new Scanner(System.in);
        String opcion = null;
        do {
            opcion = scan.nextLine();
            switch (opcion) {
                case "a":
                    System.out.println("¿Que tipo de avion es? (carga, pasajaero, militar, recreacion, excursion)");
                    String tipo = scan.nextLine();
                    System.out.println("¿Cual es la matricula?");
                    String matricula = scan.nextLine();
                    System.out.println("¿Cual es el fabricante?");
                    String fabricante = scan.nextLine();
                    System.out.println("¿Cual es el modelo?");
                    String modelo = scan.nextLine();
                    System.out.println("¿Cual es la capacidad? (entero)");
                    int capacidad = scan.nextInt();
                    System.out.println("¿Cual es la autonomia?");
                    String autonomia = scan.nextLine();

                    avion = new Avion(tipo, matricula, fabricante, modelo, capacidad, autonomia);
                    alta.darDeAltaAvion(avion, aviones);
                    break;

                case "b":
                    System.out.println("¿Que tipo de avion quiere buscar?");
                    String tipoAvion = scan.next();
                    System.out.println(consulta.getAvionTipo(tipoAvion, aviones));
                    break;
                case "c":
                    System.out.println("¿Cual es su nombre?");
                    String nombre = scan.nextLine();
                    System.out.println("¿Cual es su matricula?");
                    String matriculaPiloto = scan.nextLine();
                    piloto = new Piloto(matriculaPiloto, nombre);
                    alta.darDeAltaPiloto(piloto, pilotos);
                    break;
                case "d":
                    System.out.println("¿Cual es la ciudad?");
                    String ciudad = scan.nextLine();
                    System.out.println("¿Cual es el pais?");
                    String pais = scan.nextLine();
                    aeropuerto = new Aeropuerto(ciudad, pais);
                    alta.darDeAltaAeropuerto(aeropuerto, aeropuertos);
                    break;
                case "e":
                    System.out.println(aeropuertos);
                    System.out.println("¿Cual es el aeropuerto de origen? elija el indice del arreglo");
                    int aeropuertoElegidoOrigen = scan.nextInt();
                    System.out.println(aeropuertos);
                    System.out.println("¿Cual es el aeropuerto de destino? elija el indice del arreglo");
                    int aeropuertoElegidoDestino = scan.nextInt();
                    fecha = LocalDate.now();
                    System.out.println(pilotos);
                    System.out.println("¿Quien es el piloto? elija el indice del arreglo");
                    int pilotoElegido = scan.nextInt();
                    System.out.println(aviones);
                    System.out.println("¿Que avion se utilizara? elija el indice del arreglo");
                    int avionElegido = scan.nextInt();
                    Vuelo nuevoVuelo = new Vuelo(aeropuertos.get(aeropuertoElegidoOrigen), aeropuertos.get(aeropuertoElegidoDestino), aviones.get(avionElegido), fecha, pilotos.get(pilotoElegido));
                    alta.darDeAltaVuelo(nuevoVuelo, vuelos);
                    break;
                case "f":
                    System.out.println("¿Que origen tiene el vuelo?");
                    String origen = scan.nextLine();
                    System.out.println(consulta.getVueloOrigen(origen, vuelos));
                    break;
                case "g":
                    System.out.println("¿Que destino tiene el vuelo?");
                    String destino = scan.nextLine();
                    System.out.println(consulta.getVueloDestino(destino, vuelos));
                    break;
                case "h":
                    System.out.println("¿Que ciudad es en la que quiere buscar aeropuerto?");
                    String ciudadAeropuerto = scan.nextLine();
                    System.out.println(consulta.getAeropuertoCiudad(ciudadAeropuerto, aeropuertos));
                    break;
                case "z":
                    System.out.println("Elige una opcion");
                    System.out.println("a)Dar de alta un avion\nb)Consultar por tipo de avion\nc)Dar de alta piloto\nd)Dar de alta aeropuerto\ne)Registra vuelos de origen a destino con cierto piloto\nf)Consultar vuelos por origen\ng)Consultar vuelos por destino\nh)Consultar aeropuertos por ciudad\nq)Salir");
                    break;
            }
        }while(!opcion.equals("q"));
    }
}
