/**
 * Licencia GNU/GPL V3.0 (URL de la licencia correcta aquí)
 */
package co.edu.uniquindio.poo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.function.Predicate;

import util.AssertionUtil;

public class Equipo{
    private String nombre;
    private Persona representante;
    private Collection<Jugador> jugadores;
    private Collection<Enfrentamiento> enfrentamientos;
    private int partidosEmpatados;
    private int partidosGanados;
    private int partidosPerdidos;

    public Equipo (String nombre, Persona representante) {
        AssertionUtil.ASSERTION.assertion(nombre != null && !nombre.trim().isEmpty(), "El nombre es requerido");
        AssertionUtil.ASSERTION.assertion(representante != null, "El representante es requerido");
        this.nombre = nombre;
        this.representante = representante;
        this.jugadores = new ArrayList<>();
        this.enfrentamientos = new ArrayList<>();
    }
    public void agregarEnfrentamiento(Enfrentamiento enfrentamiento){
        enfrentamientos.add(enfrentamiento);
    }
    /**
     * Permite registrar un jugador en un equipo siempre y cuando no exista ya un jugador registrado en el equipo con el mismo nombre y apellido
     * @param jugador Jugador que se desea registrar.
     */
    public void registrarJugador(Jugador jugador) {
        validarJugadorExiste(jugador);
        jugadores.add(jugador);
    }

    /**
     * Permite buscar un jugador en el equipo basado en su nombre y apellido.
     * @param jugador Jugador que se desea buscar
     * @return Optional con el jugador que coincida con el nombre y apellido del jugador buscado, 
     * o Optional vacío en caso de no encontrar un jugador en el equipo con dicho nombre y apellido.
     */
    public Optional<Jugador> buscarJugador(Jugador jugador) {
        Predicate<Jugador> nombreIgual = j -> j.getNombre().equals(jugador.getNombre());
        Predicate<Jugador> apellidoIgual = j -> j.getApellido().equals(jugador.getApellido());
        return jugadores.stream().filter(nombreIgual.and(apellidoIgual)).findAny();
    }

    /**
     * Valida que no exista ya un jugador registrado con el mismo nombre y apellido, en caso de haberlo genera un AssertionError.
     */
    private void validarJugadorExiste(Jugador jugador) {
        boolean existeJugador = buscarJugador(jugador).isPresent();
        AssertionUtil.ASSERTION.assertion(!existeJugador, "El jugador ya está registrado");
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Persona getRepresentante() {
        return representante;
    }

    public void setRepresentante(Persona representante) {
        this.representante = representante;
    }

    public Collection<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(Collection<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public Collection<Enfrentamiento> getEnfrentamientos() {
        return enfrentamientos;
    }

    public void incrementarPartidosGanados() {
        partidosGanados++;
    }

    public void incrementarPartidosPerdidos() {
        partidosPerdidos++;
    }

    public void incrementarPartidosEmpatados() {
        partidosEmpatados++;
    }

    public int getPartidosGanados(){
        return partidosGanados;
    }

    public int getPartidosPerdidos(){
        return partidosPerdidos;
    }
    
    public int getPartidosEmpatados(){
        return partidosEmpatados;
    }
    //Funcionalidad que permite obtener una puntuación, basado en sus partidos ganados y empatados
    public int getPuntuacion() {
        return partidosGanados * 3 + partidosEmpatados;
    }

}