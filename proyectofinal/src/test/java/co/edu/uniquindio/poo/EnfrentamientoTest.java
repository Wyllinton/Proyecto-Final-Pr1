package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.logging.Logger;

import org.junit.jupiter.api.Test;

public class EnfrentamientoTest {
    private static final Logger LOG = Logger.getLogger(EquipoTest.class.getName());

@Test
public void crearEnfrentamiento (){
    LOG.info("Inicio de prueba de creación de enfrentamientos");
    Torneo torneo = new Torneo("UCL", LocalDate.of(2023, 11, 30), LocalDate.of(2023, 11, 15), LocalDate.of(2023, 11, 25), 10, 30, 0, TipoTorneo.REGIONAL, GeneroTorneo.MIXTO);

    Persona representante1 = new Persona("Maria", "Alvarez", "ujbvgyuik@fd", "2345678", GeneroPersona.FEMENINO);
    Persona representante2 = new Persona("Miyer", "Quiñones", "tyuvghik@dfh", "34587", GeneroPersona.FEMENINO);
    Equipo equipo1 = new Equipo("Barcitas FC", representante1);
    Equipo equipo2 = new Equipo("Quindio FC", representante2);

    Enfrentamiento partido1 = new Enfrentamiento("Estadio Alfonso", "Colombia", LocalDateTime.of(2023, 11, 30, 10, 0, 0), equipo1, equipo2, EstadoEnfrentamiento.TERMINADO, 3, 0);
    Enfrentamiento partido2 = new Enfrentamiento("Atanasio", "Colombia", LocalDateTime.of(2023, 11, 30, 14, 0, 0), equipo2, equipo1, EstadoEnfrentamiento.APLAZADO, 0, 0);
   
    torneo.agregarEnfrentamiento(partido1);
    torneo.agregarEnfrentamiento(partido2);

    assertEquals(2, torneo.getListaEnfrentamientos().size());

    LOG.info("Fin de prueba de creación de enfrentamientos");
}
    @Test
public void crearEnfrentamientoyActualizar(){
    LOG.info("Inicio de prueba de creación de enfrentamiento y actualización de su estado");

    Persona representante1 = new Persona("Maria", "Alvarez", "ujbvgyuik@fd", "2345678", GeneroPersona.FEMENINO);
    Persona representante2 = new Persona("Miyer", "Quiñones", "tyuvghik@dfh", "34587", GeneroPersona.FEMENINO);
    Equipo equipo1 = new Equipo("Barcitas FC", representante1);
    Equipo equipo2 = new Equipo("Quindio FC", representante2);

    Enfrentamiento partido1 = new Enfrentamiento("Estadio Alfonso", "Colombia", LocalDateTime.of(2023, 11, 30, 10, 0, 0), equipo1, equipo2, EstadoEnfrentamiento.APLAZADO, 3, 0);
    Enfrentamiento partido2 = new Enfrentamiento("Atanasio", "Colombia", LocalDateTime.of(2023, 11, 18, 17, 0, 0), equipo2, equipo1, EstadoEnfrentamiento.EN_JUEGO, 0, 0);
    Enfrentamiento partido3 = new Enfrentamiento("Atanasio", "Colombia", LocalDateTime.of(2023, 11, 19, 19, 5, 0), equipo2, equipo1, EstadoEnfrentamiento.PENDIENTE, 0, 0);
   
    partido1.actualizarEstadoEnfrentamiento();
    partido2.actualizarEstadoEnfrentamiento();
    partido3.actualizarEstadoEnfrentamiento();

    assertEquals(EstadoEnfrentamiento.APLAZADO, partido1.getEstadoEnfrentamiento());
    assertEquals(EstadoEnfrentamiento.TERMINADO, partido2.getEstadoEnfrentamiento());
    assertEquals(EstadoEnfrentamiento.EN_JUEGO, partido3.getEstadoEnfrentamiento());
    

    LOG.info("Fin de prueba de creación de enfrentamientos y actualización de su estado");
}
@Test
    public void mostrarEnfrentamientosDeJuez(){
        LOG.info("Inicio prueba obtener los enfrentamientos del Juez");
        
        Torneo torneo1 = new Torneo("Copa Mundo", LocalDate.of(2023, 12, 1), LocalDate.of(2023, 11, 10), LocalDate.of(2023, 11, 20), 24, 0, 0, TipoTorneo.LOCAL, GeneroTorneo.MASCULINO);

        Juez juez1 = new Juez("Alberto", "Arbelaez", "ertyuijh@hjkl", "345678", LocalDate.of(2000, 12, 31), GeneroPersona.MASCULINO, "3456jh");
        Juez juez2 = new Juez("Maria", "Martinez", "qwfgfds@fh", "328545678", LocalDate.of(1990, 8, 20), GeneroPersona.FEMENINO, "wetvd");
        
        Persona representante1 = new Persona("asJdadsadaasadsada", "Matallanera", "rataatata@gmail.com", "3146785432", GeneroPersona.MASCULINO);
        Persona representante2 = new Persona("asJdadsadaasadsada", "Matallanera", "rataatata@gmail.com", "3146785432", GeneroPersona.FEMENINO);

        Equipo equipo1 = new Equipo("Junior", representante1);
        Equipo equipo2 = new Equipo("City", representante2);

        Enfrentamiento enfrentamiento1 = new Enfrentamiento("El campin", "Carrera 10", LocalDateTime.of(2023, 6, 28, 15, 30, 0), equipo1, equipo2,EstadoEnfrentamiento.PENDIENTE, 0, 0);
        
        Enfrentamiento enfrentamiento2 = new Enfrentamiento("Centenario", "Centro", LocalDateTime.of(2023, 11, 7, 20, 0, 0), equipo2, equipo1,EstadoEnfrentamiento.PENDIENTE, 0, 0);
        
        torneo1.agregarEnfrentamiento(enfrentamiento1);
        torneo1.agregarEnfrentamiento(enfrentamiento2);

        enfrentamiento1.agregarJuez(juez1);
        enfrentamiento2.agregarJuez(juez1);
        enfrentamiento2.agregarJuez(juez2);

        assertTrue(torneo1.obtenerEnfrentamientosDeJuez(torneo1.getListaEnfrentamientos(),juez1.getLicenciaJuez()).contains(enfrentamiento2));
        
        assertEquals(2, torneo1.obtenerEnfrentamientosDeJuez(torneo1.getListaEnfrentamientos(),juez1.getLicenciaJuez()).size());
        
        
        LOG.info("Fin de prueba obtener los enfrentamientos del Juez");
    }
}
