/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciosud5_repaso2_3;

/**
 *
 * @author admin1
 */
public class Usuario {
    private String nombre,apellido,telefono;

    public Usuario(String nombre, String apellido, String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
    }
    public boolean esDeCantabria(){
        return (telefono.substring(0, 3).equals("942"));
    }
    public String generaEmail(){
        return nombre+"_"+apellido+telefono.substring(8)+"@javamail.com";
    }
    public String getNombre() {
        return nombre;
    }
    public int contieneLetra(char letra){
        int cont=0;
        for (int i=0;i<nombre.length();i++){
            if (nombre.charAt(i)==letra)cont++;
        }
        return cont;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
}
