/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listacontactos;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author admin1
 */
public class Persona implements Serializable{
    private String nombre, apellidos;
    private GregorianCalendar fechaNac;

    public Persona(String nombre, String apellidos, GregorianCalendar fechaNac) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNac = fechaNac;
    }

    public void mostrar() {
        System.out.print("Persona:" + "nombre=" + nombre + ", apellidos=" + apellidos + ", fecha de nacimiento=" + fechaNac.get(Calendar.DAY_OF_MONTH)+"/"+fechaNac.get(Calendar.MONTH)+"/"+fechaNac.get(Calendar.YEAR));
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public GregorianCalendar getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(GregorianCalendar fechaNac) {
        this.fechaNac = fechaNac;
    }
    
    
}
