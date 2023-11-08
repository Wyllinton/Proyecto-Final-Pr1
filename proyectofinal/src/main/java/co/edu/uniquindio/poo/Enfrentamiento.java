package co.edu.uniquindio.poo;


import java.time.LocalDateTime;
import java.util.Collection;

import util.AssertionUtil;

public class Enfrentamiento {
    public String nombreLugar;
    public String ubicacion;
    public LocalDateTime fechaHora;
    public Collection<Equipo> equipos;
    public Collection<Juez> jueces;
    public EstadoEnfrentamiento estadoEnfrentamiento;
    public int resultadoLocal;
    public int resultadoVisitante;
    
    public Enfrentamiento(String nombreLugar, String ubicacion, LocalDateTime fechaHora, Collection<Equipo> equipos,
            Collection<Juez> jueces, EstadoEnfrentamiento estadoEnfrentamiento, int resultadoLocal,
            int resultadoVisitante) {
        AssertionUtil.ASSERTION.assertion( nombreLugar != null , "El nombre es requerido");
        AssertionUtil.ASSERTION.assertion( ubicacion != null , "La ubicación es requerida");
        AssertionUtil.ASSERTION.assertion( fechaHora != null , "La fecha y hora es requerida");
        this.nombreLugar = nombreLugar;
        this.ubicacion = ubicacion;
        this.fechaHora = fechaHora;
        this.equipos = equipos;
        this.jueces = jueces;
        this.estadoEnfrentamiento = estadoEnfrentamiento;
        this.resultadoLocal = resultadoLocal;
        this.resultadoVisitante = resultadoVisitante;
    }

    public String getNombreLugar() {
        return nombreLugar;
    }

    public void setNombreLugar(String nombreLugar) {
        this.nombreLugar = nombreLugar;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public Collection<Equipo> getEquipos() {
        return equipos;
    }

    public void setEquipos(Collection<Equipo> equipos) {
        this.equipos = equipos;
    }

    public Collection<Juez> getJueces() {
        return jueces;
    }

    public void setJueces(Collection<Juez> jueces) {
        this.jueces = jueces;
    }

    public EstadoEnfrentamiento getEstadoEnfrentamiento() {
        return estadoEnfrentamiento;
    }

    public void setEstadoEnfrentamiento(EstadoEnfrentamiento estadoEnfrentamiento) {
        this.estadoEnfrentamiento = estadoEnfrentamiento;
    }

    public int getResultadoLocal() {
        return resultadoLocal;
    }

    public void setResultadoLocal(int resultadoLocal) {
        this.resultadoLocal = resultadoLocal;
    }

    public int getResultadoVisitante() {
        return resultadoVisitante;
    }

    public void setResultadoVisitante(int resultadoVisitante) {
        this.resultadoVisitante = resultadoVisitante;
    }
    
    
     
}

/*Se desea poder agendar los enfrentamientos, indicando el lugar donde se realizará el
enfrentamiento (nombre, ubicación), la fecha y hora del enfrentamiento, los equipos que
se enfrentarán, el juez o jueces que arbitraran el encuentro, el resultado del
enfrentamiento cuando haya concluido (puntos realizados por cada equipo) y el estado
del enfrentamiento. Los posibles estados de un enfrentamiento son:*/