package co.edu.uniquindio.poo;

import java.time.LocalDate;
import java.util.logging.Logger;

import org.junit.jupiter.api.Test;

public class EnfrentamientoTest {
    private static final Logger LOG = Logger.getLogger(EquipoTest.class.getName());

@Test
public void crearEnfrentamiento (){
    LOG.info("Inicio de prueba obtenerListaJuez...");
    Torneo torneo = new Torneo("UCL", LocalDate.of(2023, 11, 30), LocalDate.of(2023, 11, 15), LocalDate.of(2023, 11, 25), 10, 30, 0, TipoTorneo.REGIONAL, GeneroTorneo.MIXTO);

    Persona representante1 = new Persona("Maria", "Alvarez", "ujbvgyuik@fd", "2345678", GeneroPersona.FEMENINO);
    Persona representante2 = new Persona("Miyer", "Quiñones", "tyuvghik@dfh", "34587", GeneroPersona.FEMENINO);
    Equipo equipo1 = new Equipo("Barcitas FC", representante1);
    Equipo equipo2 = new Equipo("Quindio FC", representante2);

    Jugador jugador1 = new Jugador("Alexis", "Barco", "drtyh@dfg", "234567", LocalDate.of(2000, 4, 6), GeneroPersona.MASCULINO);
    Jugador jugador2 = new Jugador("Carmen", "Amaranto", "frtb@dh", "098765", LocalDate.of(2000, 4, 6), GeneroPersona.FEMENINO);
    Jugador jugador3 = new Jugador("Pamela", "Velez", "rtgbnkh@dfgb", "350853", LocalDate.of(2000, 4, 6), GeneroPersona.FEMENINO);
    Jugador jugador4 = new Jugador("Luis", "Acosta", "jhftgvb@vjk", "0851368", LocalDate.of(2000, 4, 6), GeneroPersona.MASCULINO);

    equipo1.registrarJugador(jugador1);
    equipo1.registrarJugador(jugador2);
    equipo2.registrarJugador(jugador3);
    equipo2.registrarJugador(jugador4);
}
}
