package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.logging.Logger;

import org.junit.jupiter.api.Test;

public class JuezTest {
    private static final Logger LOG = Logger.getLogger(EquipoTest.class.getName());

@Test
public void obtenerListaJuez (){
    LOG.info("Inicio de prueba obtenerListaJuez...");

    Torneo torneo = new Torneo("UCL", LocalDate.of(2023, 11, 30), LocalDate.of(2023, 11, 15), LocalDate.of(2023, 11, 25), 10, 30, 0, TipoTorneo.REGIONAL, GeneroTorneo.MIXTO);

    Juez juez = new Juez("Andres", "Ibarra", "tyuujk@ghj", "321453", LocalDate.of(2000, 1, 23), GeneroPersona.MASCULINO, "efnri43");
    
    torneo.registrarJuez(juez);

    assertTrue(torneo.getJueces().contains(juez));


    LOG.info("Fin de prueba obtenerListaJuez...");


}

}