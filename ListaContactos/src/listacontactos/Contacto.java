/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listacontactos;

import java.util.GregorianCalendar;

/**
 *
 * @author admin1
 */
public class Contacto extends Persona {
    private String telefono, email;
    private String [] grupo ={"familia", "Amigos", "Trabajo"};
    private int grupo_int;

    public Contacto(String telefono, String email,int grupo, String nombre, String apellidos, GregorianCalendar fechaNac) {
        super(nombre, apellidos, fechaNac);
        this.telefono = telefono;
        this.email = email;
        this.grupo_int=grupo;
    }

    public void mostrar() {
        super.mostrar();
        System.out.println("telefono=" + telefono + ", email=" + email + ", grupo=" + grupo[grupo_int-1]);
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String[] getGrupo() {
        return grupo;
    }

    public void setGrupo(String[] grupo) {
        this.grupo = grupo;
    }
    
}
