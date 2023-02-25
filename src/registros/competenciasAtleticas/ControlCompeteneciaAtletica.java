package registros.competenciasAtleticas;

import entradasalida.SalidaPorDefecto;
import estructurasLineales.ListaEstatica;
import estructurasNoLineales.Matriz3;

public class ControlCompeteneciaAtletica {
    protected Matriz3 kmRecorridos;
    protected ListaEstatica anios;
    protected ListaEstatica corredores;
    protected ListaEstatica eventosCompetenecias;

    public ControlCompeteneciaAtletica(int numAnios, int numCorredores, int numEventosCompetencias){
        kmRecorridos = new Matriz3(numAnios, numCorredores, numEventosCompetencias);
        anios = new ListaEstatica(numAnios);
        corredores = new ListaEstatica(numCorredores);
        eventosCompetenecias = new ListaEstatica(numEventosCompetencias);
        kmRecorridos.rellenar(0.0);
    }

    public boolean agregarAnio(int anio){
        int indiceAnio = (int) anios.buscar(anio);
        if(indiceAnio==-1){
            //puedo agregarlo
            int retorno = anios.agregar(anio);
            return retorno != -1;
        }
        return false;
    }

    public boolean agregarCorredor(Corredor corredor){
        int indiceCorredor = (int) corredores.buscar(corredor);
        if(indiceCorredor==-1){
            //puedo agregarlo
            int retorno = corredores.agregar(corredor);
            return retorno != -1;
        }
        return false;
    }

    public boolean agregarEvento(EventoCompetencia evento){
        int indiceEvetno = (int) eventosCompetenecias.buscar(evento);
        if(indiceEvetno==-1){
            //puedo agregarlo
            int retorno = eventosCompetenecias.agregar(evento);
            return retorno != -1;
        }
        return false;
    }

    public boolean agregarKm(int anio, int corredor, String evento, double kilometros){
        ListaEstatica indicesCubo = buscarIndicesCubo(anio, corredor, evento);
        if(indicesCubo != null){
            return kmRecorridos.cambiar((int) indicesCubo.obtener(0),
                    (int) indicesCubo.obtener(1),
                    (int) indicesCubo.obtener(2), kilometros);
        }
        return false;
    }

    private ListaEstatica buscarIndicesCubo(int anio, int corredor, String evento){
        int indiceAnio = (int) anios.buscar(anio);
        int indiceCorredor = (int) corredores.buscar(corredor);
        int indiceEvento = (int) eventosCompetenecias.buscar(evento);
        if(indiceAnio >= 0 && indiceCorredor >= 0 && indiceEvento >= 0){
            ListaEstatica indicesCubo = new ListaEstatica(3);
            indicesCubo.agregar(indiceAnio);
            indicesCubo.agregar(indiceCorredor);
            indicesCubo.agregar(indiceEvento);
            return indicesCubo;
        }
        return null;
    }

    public void imprimirAnios(){
        SalidaPorDefecto.terminal("Anio: \n");
        anios.imprimir();
    }

    public void imprimirCorredores(){
        SalidaPorDefecto.terminal("Corredores: \n");
        corredores.imprimir();
    }

    public void imprimirEventos(){
        SalidaPorDefecto.terminal("Eventos: \n");
        eventosCompetenecias.imprimir();
    }

    public void imprimirKm(){
        SalidaPorDefecto.terminal("Kilometros: \n");
        kmRecorridos.imprimirPorColumna();
    }

    public void imprimirDatosCompetencia(){
        imprimirAnios();
        imprimirCorredores();
        imprimirEventos();
        imprimirKm();
    }

    public double kmPorCorredorPorEvento(int corredor, String evento, ListaEstatica anios){
        double kmsAcumulados = 0.0;
        for(int cadaAnio = 0; cadaAnio < anios.cantidad(); cadaAnio++){
            int anioPedido = (int)anios.obtener(cadaAnio);
            double kmaIndividuales = kmPorCorredorPorEventoPorAnio(corredor,evento,anioPedido);
            if(kmaIndividuales>=0){
                kmsAcumulados += kmaIndividuales;
            }
        }
        return kmsAcumulados;
    }

    public double kmPorCorredorPorEventoPorAnio(int corredor, String evento, int anio){
        ListaEstatica indices = buscarIndicesCubo(anio,corredor,evento);
        if(indices!=null){
            return (double)kmRecorridos.obtener((int) indices.obtener(0),(int) indices.obtener(1), (int) indices.obtener(2));
        }
        return -1.0;
    }
}
