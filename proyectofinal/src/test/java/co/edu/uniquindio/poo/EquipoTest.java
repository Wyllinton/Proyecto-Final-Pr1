
package co.edu.uniquindio.poo;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.logging.Logger;

import org.junit.jupiter.api.Test;

public class EquipoTest {
    /**
     * Instancia para el manejo de logs
     */
    private static final Logger LOG = Logger.getLogger(EquipoTest.class.getName());
    
    /**
     * Verificar que sea posible registrar un equipo en el torneo 
     * 
     */
    @Test
    public void registrarEquipo() {
        LOG.info("Inicio de prueba registrarEquipo...");
        // Almacenar los datos de prueba Torneo{Copa Mundo\|fechaActual+ 1mes\| fechaActual - 15 días\|fechaActual+15 días\|24\|0\|0\|LOCAL}  Equipo{Uniquindio} Representante{Robinson,Pulgarin,rpulgarin@email.com,6067359300}

        
        Torneo torneo = new Torneo("Copa Mundo", LocalDate.now().plusMonths(1), LocalDate.now().minusDays(15), LocalDate.now().plusDays(15), 24, 0, 0,TipoTorneo.LOCAL, GeneroTorneo.MASCULINO);

        var representante = new Persona("Robinson", "Pulgarin", "rpulgarin@email.com", "6067359300", GeneroPersona.MASCULINO);

        var equipo = new Equipo("Uniquindio", representante);

        torneo.registrarEquipo(equipo);

        // Recuperación y verificación de datos
        assertTrue(torneo.getEquipos().contains(equipo));
        assertEquals(1, torneo.getEquipos().size());
        LOG.info("Fin de prueba registrarEquipo...");
    }

    /**
     * Verificar que la clase Torneo valide que no se ingresen equipos con nombre repetido
     * 
     */
    @Test
    public void nombreEquipoRepetido() {
        LOG.info("Inicio de prueba nombreEquipoRepetido...");
        // Almacenar los datos de prueba Torneo{Copa Mundo\|fechaActual+ 1mes\| fechaActual - 15 días\|fechaActual+15 días\|24\|0\|0\|LOCAL}  Equipo{Uniquindio} Representante{Robinson,Pulgarin,rpulgarin@email.com,6067359300}

        
        Torneo torneo = new Torneo("Copa Mundo", LocalDate.now().plusMonths(1), LocalDate.now().minusDays(15), LocalDate.now().plusDays(15),24, 0, 0,TipoTorneo.LOCAL, GeneroTorneo.MASCULINO);

        var representante = new Persona("Robinson", "Pulgarin", "rpulgarin@email.com", "6067359300", GeneroPersona.MASCULINO);

        var equipo = new Equipo("Uniquindio", representante);
        var equipo2 = new Equipo("Uniquindio", representante);
        torneo.registrarEquipo(equipo);

        assertThrows(Throwable.class, ()-> torneo.registrarEquipo(equipo2));
        
        LOG.info("Fin de prueba nombreEquipoRepetido...");
    }

    /**
     * Verificar que la clase Torneo valide que no se ingresen equipos cuando las inscripciones ya cerraron
     * 
     */
    @Test
    public void inscripcionCerrada() {
        LOG.info("Inicio de prueba inscripcionCerrada...");
        // Almacenar los datos de prueba Torneo{Copa Mundo\|fechaActual+ 1mes\| fechaActual - 15 días\|fechaActual-1 días\|24\|0\|0\|LOCAL}  Equipo{Uniquindio} Representante{Robinson,Pulgarin,rpulgarin@email.com,6067359300}

        
        Torneo torneo = new Torneo("Copa Mundo", LocalDate.now().plusMonths(1), LocalDate.now().minusDays(15), LocalDate.now().minusDays(1), 24, 0, 0,TipoTorneo.LOCAL, GeneroTorneo.MASCULINO);

        var representante = new Persona("Robinson", "Pulgarin", "rpulgarin@email.com", "6067359300", GeneroPersona.MASCULINO);

        var equipo = new Equipo("Uniquindio", representante);

        assertThrows(Throwable.class, ()-> torneo.registrarEquipo(equipo));
        
        LOG.info("Fin de prueba inscripcionCerrada...");
    }

    /**
     * Verificar que la clase Torneo valide que no se ingresen equipos cuando las inscripciones aun no han abrierto
     * 
     */
    @Test
    public void inscripcionNoAbierta() {
        LOG.info("Inicio de prueba inscripcionNoAbierta...");
        // Almacenar los datos de prueba Torneo{Copa Mundo\|fechaActual+ 1mes\| fechaActual + 1 día\|fechaActual+15 días\|24\|0\|0\|LOCAL}  Equipo{Uniquindio} Representante{Robinson,Pulgarin,rpulgarin@email.com,6067359300}

        
        Torneo torneo = new Torneo("Copa Mundo", LocalDate.now().plusMonths(1), LocalDate.now().plusDays(1), LocalDate.now().plusDays(15), 24, 0, 0,TipoTorneo.LOCAL, GeneroTorneo.MASCULINO);

        var representante = new Persona("Robinson", "Pulgarin", "rpulgarin@email.com", "6067359300", GeneroPersona.MASCULINO);

        var equipo = new Equipo("Uniquindio", representante);

        assertThrows(Throwable.class, ()-> torneo.registrarEquipo(equipo));
        
        LOG.info("Fin de prueba inscripcionNoAbierta...");
    }
    @Test
    public void partidosGanados(){
        LOG.info("");
        Torneo torneo1 = new Torneo("Mundial", LocalDate.of(2024, 1, 1), LocalDate.of(2023, 11, 27), LocalDate.of(2023, 12, 27), 2, 0, 0, TipoTorneo.REGIONAL, GeneroTorneo.MIXTO);

        Persona representante = new Persona("Jorge", "lopez", "asdjais@gmail.co", "3093725645", GeneroPersona.MASCULINO);
        
        Equipo equipo1 = new Equipo("A", representante);
        Equipo equipo2 = new Equipo("B", representante);

        Enfrentamiento enfrentamiento1 = new Enfrentamiento("Atanasio", "Carrera 10", LocalDateTime.of(2024, 1, 10, 10, 10), equipo1, equipo2, EstadoEnfrentamiento.TERMINADO, 1, 0);

        Enfrentamiento enfrentamiento2 = new Enfrentamiento("Centenario", "Calle 29", LocalDateTime.of(2024, 1, 10, 10, 10, 0), equipo1, equipo2, EstadoEnfrentamiento.APLAZADO, 2, 0);

        enfrentamiento1.procesarResultados();
        enfrentamiento2.procesarResultados();

        assertEquals(1, equipo1.getPartidosGanados());
        
        LOG.info("");
    }
}
