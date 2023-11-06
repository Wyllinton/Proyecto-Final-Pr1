/**
 * Clase que agrupa los datos de un Jugador
 * @author Área de programación UQ
 * @since 2023-09
 * 
 * Licencia GNU/GPL V3.0 (https://raw.githubusercontent.com/grid-uq/poo/main/LICENSE) 
 */
package co.edu.uniquindio.poo;

import static co.edu.uniquindio.poo.util.AssertionUtil.ASSERTION;

import java.time.LocalDate;

public class Juez extends Persona {
    private final LocalDate fechaNacimiento;
    private String licenciaJuez;

    public Juez(String nombre, String apellido, String email, String celular, LocalDate fechaNacimiento, String licenciaJuez) {
        super(nombre, apellido, email, celular);
        ASSERTION.assertion( fechaNacimiento != null , "La fecha de nacimiento es requerida");
        assert fechaNacimiento.isBefore(fechaNacimiento.now());
        assert lienciaJuez != null;
        this.licenciaJuez = licenciaJuez;
        this.fechaNacimiento = fechaNacimiento;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }
}