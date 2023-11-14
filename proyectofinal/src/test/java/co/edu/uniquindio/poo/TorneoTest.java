/**
 * Clase para probar el funcionamiento del Torneo
 * @author Área de programación UQ
 * @since 2023-08
 * 
 * Licencia GNU/GPL V3.0 (https://raw.githubusercontent.com/grid-uq/poo/main/LICENSE) 
 */
package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.logging.Logger;

import org.junit.jupiter.api.Test;

public class TorneoTest {
    /**
     * Instancia para el manejo de logs
     */
    private static final Logger LOG = Logger.getLogger(TorneoTest.class.getName());
    
    /**
     * Verificar que la clase Torneo almacene y recupere los datos 
     * 
     */
    @Test
    public void datosCompletos() {
        LOG.info("Inicio de prueba datos completos...");
        // Almacenar los datos de prueba Copa Mundo|2023-10-01|2023-08-01|2023-09-15|24|0|0|LOCAL
        Torneo torneo = new Torneo("Copa Mundo", LocalDate.of(2023, 10, 1), LocalDate.of(2023, 8, 1), LocalDate.of(2023, 9, 15), 24, 0, 0, TipoTorneo.LOCAL, GeneroTorneo.MIXTO);

        // Recuperación y verificación de datos
        assertEquals("Copa Mundo",torneo.getNombre());
        assertEquals(LocalDate.of(2023, 10, 1),torneo.getFechaInicio());
        assertEquals(LocalDate.of(2023, 8, 1),torneo.getFechaInicioInscripciones());
        assertEquals(LocalDate.of(2023, 9, 15),torneo.getFechaCierreInscripciones());
        assertEquals((int)24,torneo.getNumeroParticipantes());
        assertEquals((int)0,torneo.getLimiteEdad());
        assertEquals(0,torneo.getValorInscripcion());
        assertEquals(TipoTorneo.LOCAL,torneo.getTipoTorneo());
        assertEquals(GeneroTorneo.MIXTO, torneo.getGeneroTorneo());
        LOG.info("Fin de prueba datos completos...");
    }

    /**
     * Verificar que la clase Torneo valide que se ingrese los datos
     * 
     */
    @Test
    public void datosNulos() {
        LOG.info("Inicio de prueba datos nulos...");
        // Almacenar los datos de prueba null|null|null|null|24|0|0|null|LOCAL
        assertThrows(Throwable.class, ()-> new Torneo(null, null, null, null, 0, 0, 0, null, null));
        
        
        LOG.info("Fin de prueba datos nulos...");
    }

    /**
     * Verificar que la clase Torneo valide que el ingreso de número de participantes negativo 
     * 
     */
    @Test
    public void participantesNegativos() {
        LOG.info("Inicio de prueba número de participantes negativo...");
        // Almacenar los datos de prueba Copa Mundo|2023-10-01|2023-08-01|2023-09-15|-24|0|0|LOCAL
        assertThrows(Throwable.class, ()-> new Torneo("Copa Mundo", LocalDate.of(2023, 10, 1), LocalDate.of(2023, 8, 01), LocalDate.of(2023, 10, 15), -24, 0, 0,TipoTorneo.LOCAL, GeneroTorneo.FEMENINO));
        
        LOG.info("Fin de prueba  número de participantes negativo...");
    }

    /**
     * Verificar que la clase Torneo valide que el ingreso de limites de edades negativo 
     * 
     */
    @Test
    public void limiteEdadesNegativo() {
        LOG.info("Inicio de prueba limites de edades negativo...");
        // Almacenar los datos de prueba Copa Mundo|2023-10-01|2023-08-01|2023-09-15|24|-1|0|LOCAL
        assertThrows(Throwable.class, ()-> new Torneo("Copa Mundo", LocalDate.of(2023, 10, 1), LocalDate.of(2023, 8, 01), LocalDate.of(2023, 10, 15), 24, -1, 0,TipoTorneo.LOCAL, GeneroTorneo.FEMENINO));
        
        LOG.info("Fin de prueba  limites de edades negativo...");
    }

    /**
     * Verificar que la clase Torneo valide que el ingreso de valor de inscripción negativa
     * 
     */
    @Test
    public void inscripcionNegativa() {
        LOG.info("Inicio de prueba inscripción negativa...");
        // Almacenar los datos de prueba Copa Mundo|2023-10-01|2023-08-01|2023-09-15|24|0|-1|LOCAL
        assertThrows(Throwable.class, ()-> new Torneo("Copa Mundo", LocalDate.of(2023, 10, 1), LocalDate.of(2023, 8, 01), LocalDate.of(2023, 10, 15), 24, 0, -1,TipoTorneo.LOCAL, GeneroTorneo.FEMENINO));
        
        LOG.info("Fin de prueba inscripción negativa...");
    }

    /**
     * Verificar que la clase Torneo valide que el ingreso de inscripciones posteriores a la 
     * fecha de inicio del torneo
     * 
     */
    @Test
    public void inscripcionTardia() {
        LOG.info("Inicio de prueba inscripción tardia...");
        // Almacenar los datos de prueba Copa Mundo|2023-10-01|2023-11-01|2023-11-15|24|0|0|LOCAL
        assertThrows(Throwable.class, ()-> new Torneo("Copa Mundo", LocalDate.of(2023, 10, 1), LocalDate.of(2023, 11, 01), LocalDate.of(2023, 11, 15), 24, 0, 0,TipoTorneo.LOCAL, GeneroTorneo.MASCULINO));
        
        LOG.info("Fin de prueba inscripción tardia...");
    }

    /**
     * Verificar que la clase Torneo valide que el ingreso de inicio inscripciones posteriores a 
     * la fecha de cierre de inscripciones
     * 
     */
    @Test
    public void cierreInscripcionAnteriorInicio() {
        LOG.info("Inicio de prueba Cierre inscripción anterior al inicio...");
        // Almacenar los datos de prueba Copa Mundo|2023-10-01|2023-11-01|2023-11-15|24|0|0|LOCAL
        assertThrows(Throwable.class, ()-> new Torneo("Copa Mundo", LocalDate.of(2023, 10, 1), LocalDate.of(2023, 8, 15), LocalDate.of(2023, 8, 1), 24, 0, 0,TipoTorneo.LOCAL, GeneroTorneo.MASCULINO));
        
        LOG.info("Fin de prueba Cierre inscripción anterior al inicio...");
    }
    @Test 
    public void validacionGenero(){
        LOG.info("Inicio de prueba de validacion de genero en inscripción anterior al inicio...");





        Torneo torneo1 = new Torneo("Copa Mundo", LocalDate.of(2023, 10, 1), LocalDate.of(2023, 8, 1), LocalDate.of(2023, 9, 15), 24, 0, 0, TipoTorneo.LOCAL, GeneroTorneo.MASCULINO);
        
        Jugador jugadorMasculino1 = new Jugador("Milo", "Popez", "jaksjdhashdkasjhda@kjsadfsf.com", "32434535345",LocalDate.of(2005,11,1), GeneroPersona.MASCULINO);
        Jugador jugadorMasculino2 = new Jugador("Juan pablo", "lope", "adjhskdha@gmail.com", "30293484202", LocalDate.of(2005, 9, 8), GeneroPersona.MASCULINO);
        Jugador jugadorFemenino1 = new Jugador("Valen", "Nuñez", "rumeuv@rty", "345678", LocalDate.of(2000, 10, 8), GeneroPersona.FEMENINO);
        
        torneo1.validacionGeneroJugadorYTorneo(jugadorMasculino1);





        LOG.info("Fin de prueba de validacion de genero en inscripción anterior al inicio...");
    }
    
    @Test
    public void mostrarEnfrentamientosDeEquipo(){
        LOG.info("Fin de prueba Cierre inscripción anterior al inicio...");
        
        Torneo torneo1 = new Torneo("Copa Mundo", LocalDate.of(2023, 12, 1), LocalDate.of(2023, 11, 10), LocalDate.of(2023, 11, 15), 24, 0, 0, TipoTorneo.LOCAL, GeneroTorneo.MASCULINO);

        Jugador jugador1M = new Jugador("Milo", "Popez", "jaksjdhashdkasjhda@kjsadfsf.com", "32434535345",LocalDate.of(2005,11,1), GeneroPersona.MASCULINO);
        Jugador jugador2M = new Jugador("Juan pablo", "lope", "juanp.lopezuqvirtual.edu.co", "30293484202", LocalDate.of(2005, 9, 8), GeneroPersona.MASCULINO);
        Jugador jugador3M = new Jugador("Valen", "Nuñez", "rumeuv@rty", "345678", LocalDate.of(2000, 10, 8), GeneroPersona.MASCULINO);
        Jugador jugador4M = new Jugador("hector", "Popez", "jaksjdhashdkasjhda@kjsadfsf.com", "32434535345",LocalDate.of(2005,11,1), GeneroPersona.MASCULINO);
        Jugador jugador5M = new Jugador("arnoldo", "lope", "adjhskdha@gmail.com", "30293484202", LocalDate.of(2005, 9, 8), GeneroPersona.MASCULINO);
        Jugador jugador6M = new Jugador("verstappen", "Nuñez", "rumeuv@rty", "345678", LocalDate.of(2000, 10, 8), GeneroPersona.MASCULINO);
        
        Persona representante1 = new Persona("asJdadsadaasadsada", "Matallanera", "rataatata@gmail.com", "3146785432", GeneroPersona.MASCULINO);
        Persona representante2 = new Persona("asJdadsadaasadsada", "Matallanera", "rataatata@gmail.com", "3146785432", GeneroPersona.FEMENINO);
        Persona representante3 = new Persona("asJdadsadaasadsada", "Matallanera", "rataatata@gmail.com", "3146785432", GeneroPersona.MASCULINO);
        Persona representante4 = new Persona("asJdadsadaasadsada", "Matallanera", "rataatata@gmail.com", "3146785432", GeneroPersona.FEMENINO);

        Equipo equipo1 = new Equipo("Junior", representante1);
        Equipo equipo2 = new Equipo("asJdadsadaasadsada", representante4);
        Equipo equipo3 = new Equipo("Manchester", representante3);
        Equipo equipo4 = new Equipo("City", representante2);

        torneo1.registrarEquipo(equipo1);
        torneo1.registrarEquipo(equipo2);
        torneo1.registrarEquipo(equipo3);
        torneo1.registrarEquipo(equipo4);

        Enfrentamiento enfrentamiento1 = new Enfrentamiento("El campin", "Carrera 10", LocalDateTime.of(2023, 6, 28, 15, 30, 0), equipo3, equipo2, EstadoEnfrentamiento.PENDIENTE, 0, 0);
        Enfrentamiento enfrentamiento2 = new Enfrentamiento("Atanasio", "Asomeca", LocalDateTime.of(2023, 6, 27, 16, 0, 0), equipo1, equipo3, EstadoEnfrentamiento.PENDIENTE, 0, 0);
        Enfrentamiento enfrentamiento3 = new Enfrentamiento("Centenario", "Centro", LocalDateTime.of(2023, 11, 7, 20, 0, 0), equipo1, equipo4, EstadoEnfrentamiento.PENDIENTE, 0, 0);
        
        equipo1.agregarEnfrentamiento(enfrentamiento1);
        equipo1.agregarEnfrentamiento(enfrentamiento2);
        equipo1.agregarEnfrentamiento(enfrentamiento3);

        

        
        assertTrue(torneo1.mostrarEnfrentamientosDeEquipo(equipo1.getNombre()).contains(enfrentamiento2));
        assertEquals(3, torneo1.mostrarEnfrentamientosDeEquipo(equipo1.getNombre()).size());
        
        
        LOG.info("Fin de prueba Cierre inscripción anterior al inicio...");
    }
    @Test
    public void mostrarEnfrentamientosDeJuez(){
        LOG.info("Fin de prueba Cierre inscripción anterior al inicio...");
        
        Torneo torneo1 = new Torneo("Copa Mundo", LocalDate.of(2023, 12, 1), LocalDate.of(2023, 11, 10), LocalDate.of(2023, 11, 15), 24, 0, 0, TipoTorneo.LOCAL, GeneroTorneo.MASCULINO);

        Jugador jugador1M = new Jugador("Milo", "Popez", "jaksjdhashdkasjhda@kjsadfsf.com", "32434535345",LocalDate.of(2005,11,1), GeneroPersona.MASCULINO);
        Jugador jugador2M = new Jugador("Juan pablo", "lope", "juanp.lopezuqvirtual.edu.co", "30293484202", LocalDate.of(2005, 9, 8), GeneroPersona.MASCULINO);
        Jugador jugador3M = new Jugador("Valen", "Nuñez", "rumeuv@rty", "345678", LocalDate.of(2000, 10, 8), GeneroPersona.MASCULINO);
        Jugador jugador4M = new Jugador("hector", "Popez", "jaksjdhashdkasjhda@kjsadfsf.com", "32434535345",LocalDate.of(2005,11,1), GeneroPersona.MASCULINO);
        Jugador jugador5M = new Jugador("arnoldo", "lope", "adjhskdha@gmail.com", "30293484202", LocalDate.of(2005, 9, 8), GeneroPersona.MASCULINO);
        Jugador jugador6M = new Jugador("verstappen", "Nuñez", "rumeuv@rty", "345678", LocalDate.of(2000, 10, 8), GeneroPersona.MASCULINO);
        Juez juez1 = new Juez("Alberto", "Arbelaez", "ertyuijh@hjkl", "345678", LocalDate.of(2000, 12, 31), GeneroPersona.MASCULINO, "3456jh");
        Juez juez2 = new Juez("Mario", "Zapata", "pojhgf@dfg", "98345", LocalDate.of(1999, 12, 6), GeneroPersona.MASCULINO, "lmnb4");
        
        Persona representante1 = new Persona("asJdadsadaasadsada", "Matallanera", "rataatata@gmail.com", "3146785432", GeneroPersona.MASCULINO);
        Persona representante2 = new Persona("asJdadsadaasadsada", "Matallanera", "rataatata@gmail.com", "3146785432", GeneroPersona.FEMENINO);
        Persona representante3 = new Persona("asJdadsadaasadsada", "Matallanera", "rataatata@gmail.com", "3146785432", GeneroPersona.MASCULINO);
        Persona representante4 = new Persona("asJdadsadaasadsada", "Matallanera", "rataatata@gmail.com", "3146785432", GeneroPersona.FEMENINO);

        Equipo equipo1 = new Equipo("Junior", representante1);
        Equipo equipo2 = new Equipo("asJdadsadaasadsada", representante4);
        Equipo equipo3 = new Equipo("Manchester", representante3);
        Equipo equipo4 = new Equipo("City", representante2);

        torneo1.registrarEquipo(equipo1);
        torneo1.registrarEquipo(equipo2);
        torneo1.registrarEquipo(equipo3);
        torneo1.registrarEquipo(equipo4);
        torneo1.registrarJuez(juez1);

        Enfrentamiento enfrentamiento1 = new Enfrentamiento("El campin", "Carrera 10", LocalDateTime.of(2023, 6, 28, 15, 30, 0), equipo3, equipo2,EstadoEnfrentamiento.PENDIENTE, 0, 0);
        Enfrentamiento enfrentamiento2 = new Enfrentamiento("Atanasio", "Asomeca", LocalDateTime.of(2023, 6, 27, 16, 0, 0), equipo1, equipo3,EstadoEnfrentamiento.PENDIENTE, 0, 0);
        Enfrentamiento enfrentamiento3 = new Enfrentamiento("Centenario", "Centro", LocalDateTime.of(2023, 11, 7, 20, 0, 0), equipo1, equipo4,EstadoEnfrentamiento.PENDIENTE, 0, 0);
        
        //torneo1.registrarJugador(equipo1, jugador1M);
        //torneo1.registrarJugador(equipo1, jugador2M);
        //torneo1.registrarJugador(equipo2, jugador3M);
        //torneo1.registrarJugador(equipo2, jugador3M);
        //torneo1.registrarJugador(equipo2, jugador1M);
        
        torneo1.agregarEnfrentamiento(enfrentamiento1);
        torneo1.agregarEnfrentamiento(enfrentamiento2);
        torneo1.agregarEnfrentamiento(enfrentamiento3);

        enfrentamiento2.agregarJuez(juez1);
        enfrentamiento3.agregarJuez(juez1);

        assertTrue(torneo1.obtenerEnfrentamientosDeJuez(torneo1.getListaEnfrentamientos(),juez1.getLicenciaJuez()).contains(enfrentamiento2));
        assertEquals(2, torneo1.obtenerEnfrentamientosDeJuez(torneo1.getListaEnfrentamientos(),juez1.getLicenciaJuez()).size());
        
        
        LOG.info("Fin de prueba Cierre inscripción anterior al inicio...");
    }
}