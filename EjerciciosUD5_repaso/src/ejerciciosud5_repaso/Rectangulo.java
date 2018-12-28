/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciosud5_repaso;

/**
 *
 * @author admin1
 */
public class Rectangulo {
    private int ancho, largo;

    public Rectangulo(int ancho, int largo) {
        this.ancho = ancho;
        this.largo = largo;
    }

    public Rectangulo() {
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public void setLargo(int largo) {
        this.largo = largo;
    }

    public int getAncho() {
        return ancho;
    }

    public int getLargo() {
        return largo;
    }
    public double area(){
        return ancho*largo;
    }
    public double diagonal(){
        double diagonal;
        diagonal=Math.sqrt(ancho*ancho)+Math.sqrt(largo*largo);
        return diagonal;
    }
}
