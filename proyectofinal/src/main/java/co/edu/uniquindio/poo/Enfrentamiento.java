package co.edu.uniquindio.poo;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

import util.AssertionUtil;

public class Enfrentamiento {
    public String nombreLugar;
    public String ubicacion;
    public LocalDateTime fechaHora;
    public Equipo equipoLocal;
    public Equipo equipoVisitante;
    public Collection<Juez> jueces;
    public EstadoEnfrentamiento estadoEnfrentamiento;
    public int resultadoLocal;
    public int resultadoVisitante;
    
    public Enfrentamiento(String nombreLugar, String ubicacion, LocalDateTime fechaHora, Equipo equipoLocal, Equipo equipoVisitante, EstadoEnfrentamiento estadoEnfrentamiento, int resultadoLocal,
            int resultadoVisitante) {
        AssertionUtil.ASSERTION.assertion( nombreLugar != null , "El nombre es requerido");
        AssertionUtil.ASSERTION.assertion( ubicacion != null , "La ubicación es requerida");
        AssertionUtil.ASSERTION.assertion( fechaHora != null , "La fecha y hora es requerida");
        this.nombreLugar = nombreLugar;
        this.ubicacion = ubicacion;
        this.fechaHora = fechaHora;
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
        this.jueces = new ArrayList<>();
        this.estadoEnfrentamiento = estadoEnfrentamiento;
        this.resultadoLocal = resultadoLocal;
        this.resultadoVisitante = resultadoVisitante;
    }
    public void agregarJuez(Juez juez){
        jueces.add(juez);
    }
    public void agregarPuntuacion(int resultadoLocal, int resultadoVisitante) {
        if (estadoEnfrentamiento == EstadoEnfrentamiento.TERMINADO) {
            this.resultadoLocal = resultadoLocal;
            this.resultadoVisitante = resultadoVisitante;
        } else {
            // Puedes manejar esto de acuerdo a tus requisitos.
            // Podrías lanzar una excepción, imprimir un mensaje, etc.
            System.out.println("No se puede agregar puntuación en este estado.");
        }
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

    public Equipo getEquipoLocal() {
        return equipoLocal;
    }

     public Equipo getEquipoVisitante() {
        return equipoVisitante;
    }

    public void setEquipoLocal(Equipo equipoLocal) {
        this.equipoLocal = equipoLocal;
    }

    public void setEquipoVisitante(Equipo equipoVisitante) {
        this.equipoVisitante = equipoVisitante;
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

    public boolean involucraJuez(String numeroLicencia) {
        for (Juez juez : jueces) {
            if (juez.getLicenciaJuez() == numeroLicencia) {
                return true;
            }
        }
        return false;
    }

    public void procesarResultados() {
        if (resultadoLocal > resultadoVisitante) {
            equipoLocal.incrementarPartidosGanados();
            equipoVisitante.incrementarPartidosPerdidos();
        } else if (resultadoLocal < resultadoVisitante) {
            equipoLocal.incrementarPartidosPerdidos();
            equipoVisitante.incrementarPartidosGanados();
        } else {
            equipoLocal.incrementarPartidosEmpatados();
            equipoVisitante.incrementarPartidosEmpatados();
        }
    }
}