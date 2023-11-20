/**
 * 
 * Licencia GNU/GPL V3.0 (URL de la licencia correcta aquí)
 */

//paquete
package co.edu.uniquindio.poo;
//imports
import java.time.LocalDate;

public class Juez extends Persona {
    // Atributos
    private final LocalDate fechaNacimiento;
    private String licenciaJuez;
//Constructor
    public Juez(String nombre, String apellido, String email, String celular, LocalDate fechaNacimiento, GeneroPersona generoPersona, String licenciaJuez) {
        super(nombre, apellido, email, celular, generoPersona);
        assert fechaNacimiento != null : "La fecha de nacimiento es requerida";
        assert fechaNacimiento.isBefore(LocalDate.now()) : "La fecha de nacimiento debe ser anterior a la fecha actual";
        assert licenciaJuez != null : "La licencia del juez no puede ser nula";
        
        this.licenciaJuez = licenciaJuez;
        this.fechaNacimiento = fechaNacimiento;
    }
//Setters y getters
    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getLicenciaJuez(){
        return licenciaJuez;
    }
}