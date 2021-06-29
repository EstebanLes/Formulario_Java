package TPIFormulario;

import java.util.Date;

public class Empleado {

    public int Legajo;
    public String Nombre;
    public String Apellido;
    public Date FechaNac;
    public int DNI;
    public String Genero;
    public String Cargo;
    public int SueldoBruto;

       
    public String getNombre() {
        return Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public String getGenero() {
        return Genero;
    }

    public String getCargo() {
        return Cargo;
    }

    public Date getFechaNac() {
        return FechaNac;
    }

    public int getLegajo() {
        return Legajo;
    }

    public int getDNI() {
        return DNI;
    }

    public int getSueldoBruto() {
        return SueldoBruto;
    }

    public Empleado (int legajo, String nombre, String apellido, Date fechaNac, int dni, String genero, String cargo, int sueldo) {

        this.Legajo = legajo;
        this.Nombre = nombre;
        this.Apellido = apellido;
        this.FechaNac = fechaNac;
        this.DNI = dni;
        this.Genero = genero;
        this.Cargo = cargo;
        this.SueldoBruto = sueldo;
    }

}
