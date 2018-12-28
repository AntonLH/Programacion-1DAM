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
public class CAlumno {
    private String dni, nombre, direccion;
    private ArrayList<CAsignatura> listaAsignaturas;

    public CAlumno(String dni, String nombre, String direccion) {
        this.dni = dni;
        this.nombre = nombre;
        this.direccion = direccion;
        listaAsignaturas = new ArrayList<CAsignatura> ();
        listaAsignaturas.ensureCapacity(100);
    }

    public CAlumno(CAlumno alumno) {
        this.dni = alumno.getDni();
        this.nombre = alumno.getNombre();
        this.direccion = alumno.getDireccion();
        listaAsignaturas = new ArrayList<CAsignatura> ();
        CAsignatura asig;
        for (int i=0;i<listaAsignaturas.size();i++){
            asig=new CAsignatura (alumno.listaAsignaturas.get(i));
            listaAsignaturas.add(asig);
        }
        this.listaAsignaturas = alumno.getListaAsignaturas() ;
    }
    
    
    public CAsignatura obtenerAsignatura(int pos){
        if (pos<listaAsignaturas.size()&&pos>=0){
            return listaAsignaturas.get(pos);
        }
        else{
            System.out.println("Error, el parámetro está fuera de los límites");
            return null;
        }
    }
    public void añadirAsignatura(CAsignatura asignatura){
        listaAsignaturas.add(asignatura);
    }
    public int numeroAsignaturas(){
        return listaAsignaturas.size();
    }
    @Override
    public String toString() {
        double media=0;
        String devolver="DNI:" + dni + " Nombre:" + nombre + " Dir:" + direccion + " Nº Asig: "+listaAsignaturas.size()+"\n";
        for (int i=0;i<listaAsignaturas.size();i++){
            devolver+=listaAsignaturas.get(i).getNombre()+":"+listaAsignaturas.get(i).getNota()+"\n";
            media+=listaAsignaturas.get(i).getNota();
        }
        devolver+="Media: "+media/listaAsignaturas.size()+"\n";
        return devolver;
    
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public ArrayList<CAsignatura> getListaAsignaturas() {
        return listaAsignaturas;
    }

    public void setListaAsignaturas(ArrayList<CAsignatura> listaAsignaturas) {
        this.listaAsignaturas = listaAsignaturas;
    }
    

}
