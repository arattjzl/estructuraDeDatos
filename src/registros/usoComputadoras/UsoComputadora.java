package registros.usoComputadoras;

import estructurasLineales.ListaDinamica;

import java.time.LocalDateTime;

public class UsoComputadora {
    protected Usuario usuario;
    protected LocalDateTime fechaHoraInicio;
    protected LocalDateTime fechaHoraFin;
    protected ListaDinamica appsUtilizadas;

    public UsoComputadora(Usuario usuario){
        this.usuario = usuario;
        fechaHoraInicio = LocalDateTime.now();
        fechaHoraFin = null;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LocalDateTime getFechaHoraInicio() {
        return fechaHoraInicio;
    }

    public void setFechaHoraInicio(LocalDateTime fechaHoraInicio) {
        this.fechaHoraInicio = fechaHoraInicio;
    }

    public LocalDateTime getFechaHoraFin() {
        return fechaHoraFin;
    }

    public void setFechaHoraFin(LocalDateTime fechaHoraFin) {
        this.fechaHoraFin = fechaHoraFin;
    }
}
