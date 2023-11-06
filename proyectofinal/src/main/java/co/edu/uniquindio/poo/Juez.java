/**
 * Clase que agrupa los datos de un Juez
 * @author Área de programación UQ
 * @since 2023-09
 * 
 * Licencia GNU/GPL V3.0 (URL de la licencia correcta aquí)
 */
package co.edu.uniquindio.poo;

import java.time.LocalDate;

public class Juez extends Persona {
    private final LocalDate fechaNacimiento;
    private String licenciaJuez;

    public Juez(String nombre, String apellido, String email, String celular, LocalDate fechaNacimiento, String licenciaJuez) {
        super(nombre, apellido, email, celular);
        assert fechaNacimiento != null : "La fecha de nacimiento es requerida";
        assert fechaNacimiento.isBefore(LocalDate.now()) : "La fecha de nacimiento debe ser anterior a la fecha actual";
        assert licenciaJuez != null : "La licencia del juez no puede ser nula";
        
        this.licenciaJuez = licenciaJuez;
        this.fechaNacimiento = fechaNacimiento;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }
}
