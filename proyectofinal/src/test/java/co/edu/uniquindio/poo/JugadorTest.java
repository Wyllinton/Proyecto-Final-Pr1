/**
 * 
 * Licencia GNU/GPL V3.0 (https://raw.githubusercontent.com/grid-uq/poo/main/LICENSE) 
 */
package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.logging.Logger;

import org.junit.jupiter.api.Test;

public class JugadorTest {
    private static final Logger LOG = Logger.getLogger(JugadorTest.class.getName());
    
    @Test
    public void registrarJugadorEquipo() {
        LOG.info("Inicio de prueba registrarJugadorEquipo...");

        var representante = new Persona("Robinson", "Pulgarin", "rpulgarin@email.com", "6067359300", GeneroPersona.MASCULINO);
        var equipo = new Equipo("Uniquindio", representante);
        var jugador = new Jugador("Marlon", "Ruiz", "ertgb@guj", "3124567", LocalDate.of(2000, 6, 24), GeneroPersona.MASCULINO);

        equipo.registrarJugador(jugador);

        assertTrue(equipo.getJugadores().contains(jugador));
        assertEquals(1, equipo.getJugadores().size());
        
        LOG.info("Fin de prueba registrarJugadorEquipo...");
    }

    @Test
    public void registrarJugadorTorneo() {
        LOG.info("Inicio de prueba registrarJugadorTorneo...");

        
        Torneo torneo = new Torneo("Copa Mundo", LocalDate.now().plusMonths(1), LocalDate.now().minusDays(15), LocalDate.now().plusDays(15), 24, 18, 0,TipoTorneo.LOCAL, GeneroTorneo.MASCULINO);

        var representante = new Persona("Robinson", "Pulgarin", "rpulgarin@email.com", "6067359300", GeneroPersona.MASCULINO);
        var equipo = new Equipo("Uniquindio", representante);
        var jugador = new Jugador("Christian", "Candela", "chrcandela@email.com", "6067431234",LocalDate.now().minusYears(15), GeneroPersona.MASCULINO);

        torneo.registrarEquipo(equipo);
        torneo.registrarJugador("Uniquindio",jugador);

        assertTrue(equipo.getJugadores().contains(jugador));
        assertEquals(1, equipo.getJugadores().size());
        LOG.info("Fin de prueba registrarJugadorTorneo...");
    }

    @Test
    public void registrarJugadorTorneoSinLimiteEdad() {
        LOG.info("Inicio de prueba registrarJugadorTorneoSinLimiteEdad...");

        
        Torneo torneo = new Torneo("Copa Mundo", LocalDate.now().plusMonths(1), LocalDate.now().minusDays(15), LocalDate.now().plusDays(15),24,0, 0,TipoTorneo.LOCAL, GeneroTorneo.MASCULINO);

        var representante = new Persona("Robinson", "Pulgarin", "rpulgarin@email.com", "6067359300", GeneroPersona.MASCULINO);
        var equipo = new Equipo("Uniquindio", representante);
        var jugador = new Jugador("Christian", "Candela", "chrcandela@email.com", "6067431234",LocalDate.now().minusYears(21), GeneroPersona.MASCULINO);

        torneo.registrarEquipo(equipo);
        torneo.registrarJugador("Uniquindio",jugador);

        assertTrue(equipo.getJugadores().contains(jugador));
        assertEquals(1, equipo.getJugadores().size());
        LOG.info("Fin de prueba registrarJugadorTorneoSinLimiteEdad...");
    }

    @Test
    public void registrarJugadorTorneoConLimiteEdad() {
        LOG.info("Inicio de prueba registrarJugadorTorneoConLimiteEdad...");
        
        Torneo torneo = new Torneo("Copa Mundo", LocalDate.now().plusMonths(1), LocalDate.now().minusDays(15), LocalDate.now().plusDays(15), 24,18, 0,TipoTorneo.LOCAL, GeneroTorneo.MASCULINO);

        var representante = new Persona("Robinson", "Pulgarin", "rpulgarin@email.com", "6067359300", GeneroPersona.MASCULINO);
        var equipo = new Equipo("Uniquindio", representante);
        var jugador = new Jugador("Christian", "Candela", "chrcandela@email.com", "6067431234",LocalDate.now().minusYears(21), GeneroPersona.MASCULINO);

        torneo.registrarEquipo(equipo);
        assertThrows(Throwable.class,()->torneo.registrarJugador("Uniquindio",jugador));

        
        LOG.info("Fin de prueba registrarJugadorTorneoConLimiteEdad...");
    }

    @Test
    public void registrarJugadorTorneoInscripcionesCerradas() {
        LOG.info("Inicio de prueba registrarJugadorTorneoInscripcionesCerradas...");
        
        Torneo torneo = new Torneo("Copa Mundo", LocalDate.now().plusMonths(1), LocalDate.now().minusDays(15), LocalDate.now().plusDays(1), 24, 18, 0,TipoTorneo.LOCAL, GeneroTorneo.MASCULINO);

        var representante = new Persona("Robinson", "Pulgarin", "rpulgarin@email.com", "6067359300", GeneroPersona.MASCULINO);
        var equipo = new Equipo("Uniquindio", representante);
        var jugador = new Jugador("Christian", "Candela", "chrcandela@email.com", "6067431234",LocalDate.now().minusYears(15), GeneroPersona.MASCULINO);

        torneo.registrarEquipo(equipo);
        torneo.setFechaCierreInscripciones(LocalDate.now().minusDays(1));
        assertThrows(Throwable.class,()->torneo.registrarJugador("Uniquindio",jugador));

        
        LOG.info("Fin de prueba registrarJugadorTorneoInscripcionesCerradas...");
    }

    @Test
    public void registrarJugadoresRepetidosEquipo() {
        LOG.info("Inicio de prueba registrarJugadorEquipo...");

        var representante = new Persona("Robinson", "Pulgarin", "rpulgarin@email.com", "6067359300", GeneroPersona.MASCULINO);
        var equipo = new Equipo("Uniquindio", representante);
        var jugador = new Jugador("Christian", "Candela", "chrcandela@email.com", "6067431234",LocalDate.now().minusYears(15), GeneroPersona.MASCULINO);
        var jugador2 = new Jugador("Christian", "Candela", "ccandela@email.com", "6067431235",LocalDate.now().minusYears(15), GeneroPersona.MASCULINO);
        equipo.registrarJugador(jugador);
        assertThrows(Throwable.class,()->equipo.registrarJugador(jugador2));
        
        LOG.info("Fin de prueba registrarJugadorEquipo...");
    }

    @Test
    public void registrarJugadoresRepetidosTorneo() {
        LOG.info("Inicio de prueba registrarJugadoresRepetidosTorneo...");

        var torneo = new Torneo("Copa Mundo", LocalDate.now().plusMonths(1), LocalDate.now().minusDays(15), LocalDate.now().plusDays(15),24,18, 0,TipoTorneo.LOCAL, GeneroTorneo.MASCULINO);

        var representante = new Persona("Robinson", "Pulgarin", "rpulgarin@email.com", "6067359300", GeneroPersona.MASCULINO);
        var equipo = new Equipo("Uniquindio", representante);
        var equipo2 = new Equipo("Quindío", representante);
        torneo.registrarEquipo(equipo);
        torneo.registrarEquipo(equipo2);

        var jugador = new Jugador("Christian", "Candela", "chrcandela@email.com", "6067431234",LocalDate.now().minusYears(15), GeneroPersona.MASCULINO);
        var jugador2 = new Jugador("Christian", "Candela", "ccandela@email.com", "6067431235",LocalDate.now().minusYears(15), GeneroPersona.MASCULINO);
                
        torneo.registrarJugador("Uniquindio",jugador);
        assertThrows(Throwable.class,()->torneo.registrarJugador("Quindío",jugador2));

        
        LOG.info("Fin de prueba registrarJugadoresRepetidosTorneo...");
    }


}
