/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciosud5_repaso2;

/**
 *
 * @author admin1
 */
public class Alimentos {
    private String nombre;
    private int grasas, hidratos;
    private boolean origenAnimal;

    public Alimentos(String nombre, int grasas, int hidratos, boolean origenAnimal) {
        this.nombre = nombre;
        this.grasas = grasas;
        this.hidratos = hidratos;
        this.origenAnimal = origenAnimal;
    }

    @Override
    public String toString() {
        return "Alimentos{" + "nombre=" + nombre + ", grasas=" + grasas + ", hidratos=" + hidratos + ", origenAnimal=" + origenAnimal + '}';
    }
    
    public void mostrarAtributos(){
        System.out.println(toString());
    }
    public boolean esDietetico(){
        return (grasas<12&&!origenAnimal);
    }
    public String claveA(){
        return nombre.substring(0, 3).toUpperCase()+grasas;
    }
    public double calorias(double gramos){
        return gramos*(grasas*5.3+hidratos*2.1);
    }
}
