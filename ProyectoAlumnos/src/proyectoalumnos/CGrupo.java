/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoalumnos;

import java.util.ArrayList;

/**
 *
 * @author admin1
 */
public class CGrupo {
    private String nombre;
    private ArrayList<CAlumno> listaAlumnos;

    public CGrupo(String nombre) {
        this.nombre = nombre;
        listaAlumnos = new ArrayList ();
        listaAlumnos.ensureCapacity(30);
    }
    
    public CAlumno alumno(int pos){
        if (pos<listaAlumnos.size()&&pos>=0){
            return listaAlumnos.get(pos);
        }
        else{
            System.out.println("Error, el parámetro está fuera de los límites");
            return null;
        }
    }
    public void añadirAlumno(CAlumno alum){
        listaAlumnos.add(alum);
    }
    public CAlumno devolverAlumno(String nombre){
        CAlumno devolver=null;
        for (int i=0;i<listaAlumnos.size();i++){
            if (nombre.equals(listaAlumnos.get(i).getNombre())){
                devolver=listaAlumnos.get(i);
            }
        }
        return devolver;
    }    
    public boolean eliminar(String nombre){
        boolean devolver=false;
        for (int i=0;i<listaAlumnos.size();i++){
            if (nombre.equals(listaAlumnos.get(i).getNombre())){
                listaAlumnos.remove(i);
                devolver=true;
            }
        }
        return devolver;
    }    
    public int numeroAlumnos(){
        return listaAlumnos.size();
    }
}
