/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoalumnos;

/**
 *
 * @author admin1
 */
public class CAsignatura {
    private String nombre;
    private int nota;

    public CAsignatura(String nombre) {
        this.nombre = nombre;
        this.nota=nota;
    }

    public CAsignatura(CAsignatura asignatura) {
        this.nombre = asignatura.getNombre();
        this.nota = asignatura.getNota();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        if (nota<=10&&nota>=1) this.nota = nota;
        else System.out.println("La nota tiene que estar entre 1 y 10");
                
    }
    
}
