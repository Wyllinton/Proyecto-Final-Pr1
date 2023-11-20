package co.edu.uniquindio.poo;
import util.AssertionUtil;

public class Persona {
    //Atributos
    private final String nombre;
    private final String apellido;
    private final String email;
    private final String celular;
    public GeneroPersona generoPersona;
    //Constructor
    public Persona(String nombre,String apellido,String email, String celular, GeneroPersona generoPersona){
        AssertionUtil.ASSERTION.assertion( nombre != null && !nombre.isBlank() , "El nombre es requerido");
        AssertionUtil.ASSERTION.assertion( apellido != null && !apellido.isBlank() , "El apellido es requerido");
        AssertionUtil.ASSERTION.assertion( celular != null && !celular.isBlank() , "El celular es requerido");
        AssertionUtil.ASSERTION.assertion( email != null && !email.isBlank() , "El email es requerido");
        
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.celular = celular;
        this.generoPersona = generoPersona;
    }
    //Setters y getters
    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getEmail() {
        return email;
    }

    public String getCelular() {
        return celular;
    }

    public GeneroPersona getGeneroPersona() {
        return generoPersona;
    }
}
