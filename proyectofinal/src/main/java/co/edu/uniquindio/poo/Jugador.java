/**
 *
 * Licencia GNU/GPL V3.0 (https://raw.githubusercontent.com/grid-uq/poo/main/LICENSE) 
 */
package co.edu.uniquindio.poo;

import java.time.LocalDate;
import java.time.Period;

import util.AssertionUtil;


public class Jugador extends Persona {
    //Atributos
    private final LocalDate fechaNacimiento;
    //Constructor
    public Jugador(String nombre, String apellido, String email, String celular, LocalDate fechaNacimiento, GeneroPersona generoPersona) {
        super(nombre, apellido, email, celular, generoPersona);
        AssertionUtil.ASSERTION.assertion( fechaNacimiento != null , "La fecha de nacimiento es requerida");
        this.fechaNacimiento = fechaNacimiento;
    }
    //setters y getters
    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }
    
    /**
     * Permite calcula la edad que tiene un jugador en una fecha dada.
     * @param fecha Fecha contra la cual se desea calcular la edad del jugador.
     * @return La edad que tiene en años en la fecha dada.
     */
    public byte calcularEdad(LocalDate fecha){
        return (byte) Period.between(fechaNacimiento, fecha).getYears();
    }
}